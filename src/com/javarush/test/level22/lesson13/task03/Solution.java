package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
***1) если номер начинается с '+', то он содержит 12 цифр
***2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
***3) может содержать 0-2 знаков '-', которые не могут идти подряд
***4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
***5) скобки внутри содержат четко 3 цифры
***6) номер не содержит букв
***7) номер заканчивается на цифру
 +38051202(345)-7
Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    static int count = 1;
    public static void main(String[] args)
    {

        System.out.println(count +" "+ checkTelNumber("+180501234567"));
        System.out.println(count +" "+ checkTelNumber("+28(050)1234567"));
        System.out.println(count +" "+ checkTelNumber("+38050123-45-67"));
        System.out.println(count +" "+ checkTelNumber("450123-4567"));
        System.out.println(count +" "+ checkTelNumber("+58)050(1234567"));
        System.out.println(count +" "+ checkTelNumber("+68(050)1-23-45-6-7"));
        System.out.println(count +" "+ checkTelNumber("750xxx4567"));
        System.out.println(count +" "+ checkTelNumber("+850123456"));
        System.out.println(count +" "+ checkTelNumber("(9)501234567"));

        System.out.println(count +" "+ checkTelNumber("+10-(050)1234567"));
        System.out.println(count +" "+ checkTelNumber("+11((050)1234567"));
        System.out.println(count +" "+ checkTelNumber("+1(2--5)1234567"));
        System.out.println(count +" "+ checkTelNumber("1-3-4123689-5"));
        System.out.println(count +" "+ checkTelNumber("1-43456789-0"));
        System.out.println(count +" "+ checkTelNumber("+15051202(345)7"));

        System.out.println(count +" "+ checkTelNumber("+16051202(345)-7"));
        System.out.println(count +" "+ checkTelNumber("(175)0512027"));
        System.out.println(count +" "+ checkTelNumber("+-183450531202"));


    }

    public static boolean checkTelNumber(String telNumber) {
        count++;
        if (telNumber.matches(".*[a-zA-Z]+.*") || telNumber.matches(".+\\D$") ) return false;
        if ( !(telNumber.matches("^(\\d[\\-\\(\\)]?)(\\d[\\-\\(\\)]?){9}") || telNumber.matches("^(\\+[\\-\\(\\)]?)(\\d[\\-\\(\\)]?){12}") || telNumber.matches("^\\((\\d[\\-\\(\\)]?){10}")  ) ) return false;
        if (telNumber.matches("(.*\\-.*){3,}") || telNumber.matches("(.*\\-\\-.*)+")) return false;
        if ( telNumber.matches("(.*\\(.*){2,}") || telNumber.matches("(.*\\).*){2,}") ) return false;
        if ( ( telNumber.matches(".*\\(+.*") || telNumber.matches(".*\\)+.*")) && !telNumber.matches(".*(\\(\\d{3}\\))+.*")) return false;
        if ( telNumber.matches(".*\\-.*(\\(\\d{3}\\)){1}.*")) return false;

        return  true;
    }
}
