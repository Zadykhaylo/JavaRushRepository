package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldSystem = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(oldSystem);

        String [] s = result.split(" ");
        if (s[1].equals("+")) result = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + (Integer.parseInt(s[0]) + Integer.parseInt(s[2]));
        if (s[1].equals("-")) result = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + (Integer.parseInt(s[0]) - Integer.parseInt(s[2]));
        if (s[1].equals("*")) result = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + (Integer.parseInt(s[0]) * Integer.parseInt(s[2]));
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

