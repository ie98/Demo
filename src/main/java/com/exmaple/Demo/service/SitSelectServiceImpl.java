package com.exmaple.Demo.service;


import com.exmaple.Demo.dto.SelectConfirm;
import com.exmaple.Demo.mapper.ChairMapper;
import com.exmaple.Demo.mapper.RecordMapper;
import com.exmaple.Demo.mapper.TaberMapper;
import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;
import com.exmaple.Demo.model.Record;
import com.exmaple.Demo.util.RedisUtil;
import com.exmaple.Demo.util.SelectChairUtil;
import com.exmaple.Demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SitSelectServiceImpl implements SitSelectService {
    @Autowired
    private ChairMapper chairMapper;
    @Autowired
    private TaberMapper taberMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private List<Chair> chairs;

    @Override
    public List<DiningTable> selectAllChair(String table) {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        RedisUtil redisUtil = new RedisUtil(redisTemplate);
        Set<Chair> chairs = new LinkedHashSet<Chair>();
        List<DiningTable> Table = new ArrayList<DiningTable>();
        List<Chair> Chairs = new ArrayList<Chair>();
        String[] AllSelect;
        if ("diningtable_1".equals(table)) {
            Chairs = chairMapper.selectAllChairsOne();
            Table = taberMapper.selectAllTableOne();
//            chairs.addAll((Set<Chair>) redisUtil.keys("Chairs_1*"));
//            System.out.println(chairs.isEmpty());
//            int len = redisUtil.keys("Chairs_1*").size();
            AllSelect = (String[]) redisUtil.keys("Chairs_1*").toArray(new String[redisUtil.keys("Chairs_1*").size()]);
        } else {
            Chairs = chairMapper.selectAllChairsTwo();
            Table = taberMapper.selectAllTableTwo();

            AllSelect = (String[]) redisUtil.keys("Chairs_2*").toArray(new String[redisUtil.keys("Chairs_2*").size()]);  //获取已经预选过的座位对应key值

        }

        System.out.println(Table.size());
        System.out.println(AllSelect.length);
        int star = 0;
        for (int i = 0; i < Table.size(); i++) {  //分配椅子给对应桌子
            List<Chair> chairList = new ArrayList<>(Chairs.subList(star, star + Table.get(i).getSumnumber()));
            Table.get(i).setChairs(chairList);
            star += Table.get(i).getSumnumber();
        }
        List<Chair> temp = new ArrayList<>();
        for (int i = 0; i < AllSelect.length; i++) {
            temp.addAll((List<Chair>) redisUtil.get(AllSelect[i]));
        }
        Table = SelectChairUtil.updateChairs(Table, temp);
        return Table;
    }

    @Override
    public Chair selectOne() {
        Chair chair = chairMapper.selectOne();
        System.out.println(chair.toString());
        return chair;
    }

    public Boolean tooMany(String tables, int peopleNumber) {
        List<DiningTable> alltable = this.selectAllChair(tables);
        int sitCount = 0;
        for (int i = 0; i < alltable.size(); i++) {
            for (int j = 0; j < alltable.get(i).getChairs().size(); j++) {
                if (alltable.get(i).getChairs().get(j).getEmpty() == true)
                    sitCount++;
            }

        }
        if (sitCount >= peopleNumber)
            return true;
        else
            return false;
    }

     public Boolean selectConfirm(SelectConfirm selectConfirm){
        String allSit = "";
        String allpeoplename = "";
        StringBuffer stringBuffer = new StringBuffer(allpeoplename);
        for (int i = 0; i < selectConfirm.getAllPeopleName().length; i++) {
            System.out.println(selectConfirm.getAllPeopleName()[i].getName());
            stringBuffer.append(selectConfirm.getAllPeopleName()[i].getName());
            if (i<selectConfirm.getAllPeopleName().length-1)
                stringBuffer.append(" ; ");
//            allpeoplename = allpeoplename +selectConfirm.getAllPeopleName()[i].toString();
        }
        allpeoplename = stringBuffer.toString();
        System.out.println(allpeoplename);
//        System.out.println(selectConfirm.getAllPeopleName().toString());
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        RedisUtil redisUtil = new RedisUtil(redisTemplate);
        List<Chair> chairs = new ArrayList<Chair>();
        System.out.println("id:" + selectConfirm.getUserId());
        System.out.println("location:" + selectConfirm.getLocation());
        for (int i = 0; i < selectConfirm.getTables().size(); i++) {
            for (int j = 0; j < selectConfirm.getTables().get(i).getChairs().size(); j++) {
                if (selectConfirm.getTables().get(i).getChairs().get(j).getRecommendSit()) {
                    chairs.add(selectConfirm.getTables().get(i).getChairs().get(j));
                }
            }
        }
        System.out.println(chairs.get(0).getIntable()+"-"+chairs.get(0).getChairnumber());
        //获取当前的tables
        synchronized (this) {
            List<DiningTable> diningTables = ("diningtable_1".equals(selectConfirm.getLocation()) ? this.selectAllChair("diningtable_1") : this.selectAllChair("diningtable_2"));
            for (int i = 0; i < chairs.size(); i++) {
                if (diningTables.get(chairs.get(i).getIntable()-1).getChairs().get(chairs.get(i).getChairnumber()-1).getEmpty() == false){
                    System.out.println("位置已经被抢走");
                    return false;

                }
            }
        }
        System.out.println("1111");
         for (int i = 0; i < chairs.size(); i++) {
             allSit += (chairs.get(i).getIntable()) +"-"+ (chairs.get(i).getChairnumber());
                if (i!=chairs.size()-1)
                    allSit+=";";
         }
        User user = userMapper.findById(selectConfirm.getUserId());
         System.out.println(user.getPhone());
        Record record = new Record();
         BeanUtils.copyProperties(user,record);
         record.getPhone();
         record.setAllpeople(allpeoplename);
        record.setIndate(new Date());
        record.setSit(allSit);
        record.setPeoplenumber(selectConfirm.getPeopleNumber());
        record.setLocation(selectConfirm.getLocation());
         recordMapper.insertRecord(record);
        String str1 = "Chairs_1" + selectConfirm.getUserId();
        String str2 = "Chairs_2" + selectConfirm.getUserId();
        if ("diningtable_1".equals(selectConfirm.getLocation()))
            redisUtil.set(str1, chairs, 1200);
        else redisUtil.set(str2, chairs, 1200);
        return true;

    }

}
