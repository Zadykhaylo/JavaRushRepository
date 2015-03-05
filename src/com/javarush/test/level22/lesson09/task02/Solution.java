package com.javarush.test.level22.lesson09.task02;


import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main (String[] args) throws Exception{
        Map<String, String> map = new LinkedHashMap<>();
        map.put(null, "Ivanov");
        map.put("country", "Ukraine");
        map.put("dfvdfv", "ffvsfv");
        map.put("ev", null);
        map.put(null, null);
        System.out.println(getCondition(map));
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        if (params.isEmpty()) return new StringBuilder("");

        StringBuilder stringBuilder = new StringBuilder();

            for (Map.Entry<String, String> pair : params.entrySet())

            if(pair.getValue()!=null && pair.getKey() != null) stringBuilder.append(pair.getKey()+" = '"+pair.getValue()+"' and ");


        if (stringBuilder.length() == 0) return new StringBuilder("");

        return stringBuilder.replace(stringBuilder.length()-5,stringBuilder.length()-1,"");
    }
}
