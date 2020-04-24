package ru.geekbrains.main.site.at.exceptions;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryExample {

    public static void main(String[] args) {
        List<Object> qqq = new ArrayList<>();
        
        for(int i=0;;i++){
            System.out.println(i);
            qqq.add(new Array[100000000]);
        }
    }
}
