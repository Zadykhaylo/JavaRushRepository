package com.javarush.test.level20.lesson10.home03;

import java.io.Serializable;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите и исправьте ошибку.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable{
    static final long serialVersionUID = 41L;
    public static class A {
        protected String name = "A";

        public A(){

        }
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        static final long serialVersionUID = 40L;
        public B(String name) {
            super(name);
            this.name += name;
        }
    }
}
