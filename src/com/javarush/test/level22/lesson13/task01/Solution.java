package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<String>();
        StringTokenizer tok = new StringTokenizer(query, delimiter);
        while (tok.hasMoreTokens())
        {
           list.add(tok.nextToken());
        }
        String [] ss = new String[list.size()];
        for (int i = 0; i < ss.length; i++)
        {
          ss[i] = list.get(i);
        }
        return ss;
    }
}
