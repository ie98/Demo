package com.exmaple.Demo.service;

import com.exmaple.Demo.mapper.ChairMapper;
import com.exmaple.Demo.mapper.TaberMapper;
import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SitSelectServiceImpl implements SitSelectService {
    @Autowired
    ChairMapper chairMapper;
    @Autowired
    TaberMapper taberMapper;

    @Override
    public List<DiningTable> selectAllChair(String table) {
 //       String chairs = table.equals("diningtable_1")?"chair_1":"chait_2";
        List<DiningTable> Table = null;
        List<Chair> Chairs = null;
        if ("diningtable_1".equals(table)){
            Chairs = chairMapper.selectAllChairsOne();
            Table = taberMapper.selectAllTableOne();
        }else{
            Chairs = chairMapper.selectAllChairsTwo();
            Table = taberMapper.selectAllTableTwo();
        }

        System.out.println(Table.size());
        int star = 0;
        for (int i = 0; i < Table.size(); i++) {
            Table.get(i).setChairs(Chairs.subList(star,star+Table.get(i).getSumnumber()));
            star += Table.get(i).getSumnumber();
        }

        return Table;
    }

    @Override
    public Chair selectOne() {
        Chair chair = chairMapper.selectOne();
        System.out.println(chair.toString());
        return chair;
    }

    public List<DiningTable> adjust(List<DiningTable> tables, List<Chair> chairs) {

        for (int i = 0; i <chairs.size() ; i++) {
            tables.get((int) chairs.get(i).getIntable()-1).getChairs().get((int) chairs.get(i).getChairnumber()-1).setRecommendSit(false);
        }
        return tables;
    }


}
