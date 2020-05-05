package com.exmaple.Demo.util;

import com.exmaple.Demo.dto.Query;
import com.exmaple.Demo.dto.QueryReturn;
import com.exmaple.Demo.model.Food;
import com.exmaple.Demo.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static  <T> QueryReturn selectUtil(List<T> list, Query query){
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

    public static void tagStringToObject(List<Tag> tags , List<Food> foods){
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i).getTags());
            if (foods.get(i).getTags() == null ||  "".equals(foods.get(i).getTags())) {
            }else {  //生成级联选择器可以渲染的List<List<Integer>> 集合对象
                String[] str  = foods.get(i).getTags().split("/");
                List<List<Integer>> list = new ArrayList<>();
                for (int i1 = 0; i1 < str.length; i1++) {
                    String[] arr = str[i1].split(",");
                    List<Integer> temp = new ArrayList<>();
                    for (int i2 = 0; i2 < arr.length; i2++) {
                        temp.add(Integer.parseInt(arr[i2]));
                    }
                    list.add(temp);
                }
                foods.get(i).setTagList(list);
            }

        }
        for (int i = 0; i < foods.size(); i++) {  //将标签的id值转为对用的标签对象
            for (List<Integer> taglist : foods.get(i).getTagList()) {
                for (int i1 = 0; i1 < tags.size(); i1++) {
                    if (tags.get(i1).getId() == taglist.get(taglist.size()-1)){
                        foods.get(i).getTagDetail().add(tags.get(i1));
                        break;
                    }
                }
            }
        }
//        return foods;
    }
}
