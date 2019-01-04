package com.zhang.myjava.interview;

import java.util.*;

public class CollectTest {


    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        Integer[] array1 = new Integer[3];
        String[] array2 = new String[5];
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>();
        Map<String, String> map3 = new TreeMap<>();

        list1.add("haha");
        list1.add(null);
        list1.add("wow");
        System.out.println(list1.contains(null));

        array2 = list1.toArray(array2);
        for(String str: array2) {
            System.out.println(str);
        }



    }

}
