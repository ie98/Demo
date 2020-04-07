package com.exmaple.Demo.util;

import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SelectChairUtil {

    public static List<DiningTable> adjust(List<DiningTable> tables, List<Chair> chairs) {

        for (int i = 0; i <chairs.size() ; i++) {
            tables.get((int) chairs.get(i).getIntable()-1).getChairs().get((int) chairs.get(i).getChairnumber()-1).setRecommendSit(true);
        }
        return tables;
    }
    public static List<DiningTable> updateChairs(List<DiningTable> tables , List<Chair> chairs){
//        return Jackson.classtoJson(sitSelectServiceImpl.selectAllChair("diningtable_1"));
if (chairs != null )
            for (Chair chair : chairs) {
                System.out.println(chair);
                tables.get((int) chair.getIntable()-1).getChairs().get((int) chair.getChairnumber()-1).setEmpty(false);
            }
            return tables;

    }

}
