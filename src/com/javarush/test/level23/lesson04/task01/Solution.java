package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();
        InnerClass innerClass1 = solution1.new InnerClass();
        InnerClass innerClass2 = solution1.new InnerClass();
        solution1.innerClasses [0] = innerClass1;
        solution1.innerClasses [1] = innerClass2;
        solution2.innerClasses [0] = innerClass1;
        solution2.innerClasses [1] = innerClass2;
        Solution [] solutions = {solution1, solution2};

        return solutions;
    }
}
