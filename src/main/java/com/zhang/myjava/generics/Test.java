package com.zhang.myjava.generics;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zck on 2018/8/29.
 */
public class Test {
    private Map<String, String> linkedMap = new LinkedHashMap<>();


    public static void main(String[] args) {

        /**不指定泛型的时候*/
        Integer i = Test.add(1, 2);   //这两个参数都是Integer，所以T为Integer类型
        Number f = Test.add(1, 1.2);  //这两个参数一个是Integer，一个是Double，所以取同一父类的最小级，为Number
        Object o = Test.add(1, "asd");  //这两个参数一个是Integer，一个是String，所以取同一父类的最小级，为Object

        System.out.println(i.getClass().getName());   //输出： java.lang.Integer
        System.out.println(f.getClass().getName());   //输出： java.lang.Double
        System.out.println(o.getClass().getName());   //输出： java.lang.String

        /**指定泛型的时候*/
        int a = Test.<Integer>add(1, 2);  //指定了Integer，所以只能为Integer类型或者其子类
        //int b = Test.<Integer>add(1, 2.2);  //编译错误，指定了Integer，不能为Double
        Number c = Test.<Number>add(1, 2.2);  //指定为Number，所以可以为Integer和Double
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }
}
