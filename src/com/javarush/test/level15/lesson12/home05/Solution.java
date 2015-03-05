package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {


    public Solution(){ }
    public Solution(int i, int j){ }
    public Solution(int i, int j, int k){}

    protected Solution(int i, String s){ }
    protected Solution(int i, int j, String s){}
    protected Solution(int i, int j, int k, String s){}

    Solution(int i, String s, String d){}
    Solution(int i, int j, String s, String d){}
    Solution(int i, int j, int k, String s, String d){}

    private Solution(String s){}
    private Solution(String s, String d){}
    private Solution(String s, String d, String f){}



}

