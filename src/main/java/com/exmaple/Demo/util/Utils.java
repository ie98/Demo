package com.exmaple.Demo.util;

import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.QueryReturn;

import java.util.List;

public class Utils<T> {

    public  QueryReturn selectUtil(List<T> list, Query query){
        int start = query.getPageSize()*(query.getPageNum()-1);
        int end = start +query.getPageSize();
        QueryReturn queryReturn = new QueryReturn();
        if (query.getPageNum() == 1 && end >= list.size())
            queryReturn. getList().addAll(list);
        else
        {
            for (int i = start; i < end; i++) {
                if(i>=list.size()) break;
                queryReturn.getList().add(list.get(i));
            }
        }

        queryReturn.setNum(list.size());
        return queryReturn;
    }
}
