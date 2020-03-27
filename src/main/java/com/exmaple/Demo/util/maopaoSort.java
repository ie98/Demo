package com.exmaple.Demo.util;

import com.exmaple.Demo.dto.Point;

public class maopaoSort {

    public static void mpSort(Point[] row ){
        int index = 0;

        for (int i = 0; i <144 ; i++) {
            index = i;
            for (int j = i+1; j <144 ; j++) {
                    if (row[index].getDistance()>row[j].getDistance()){
                            index = j;
                    }
            }
            exchange(row[i],row[index]);
        }

    }
    public static void exchange(Point p1 , Point p2){
        Point temp = new Point();
        temp.setDistance(p1.getDistance());
        temp.setLocation(p1.getLocation());
        p1.setDistance(p2.getDistance());
        p1.setLocation(p2.getLocation());
        p2.setDistance(temp.getDistance());
        p2.setLocation(temp.getLocation());
    }
}
