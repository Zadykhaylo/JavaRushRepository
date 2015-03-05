package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(50d,"50");
        labels.put(60d,"50");
        labels.put(70d,"50");
        labels.put(80d,"50");
        labels.put(90d,"50");


    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
