package com.javarush.test.level20.lesson04.task05;

import java.io.Serializable;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static class Object implements Serializable{
        public String string1;
        public String string2;
        static final long serialVersionUID = 42L;
    }

    public static int countStrings;

    public static class String implements Serializable{
        private final int number;
        static final long serialVersionUID = 43L;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
