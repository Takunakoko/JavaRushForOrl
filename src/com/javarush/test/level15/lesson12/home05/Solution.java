package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(String name) {}
    public Solution(Integer name) {}
    public Solution(boolean name) {}

    protected Solution(float name) {}
    protected Solution(Double name) {}
    protected Solution(double name) {}

    private Solution(short name) {}
    private Solution(long name) {}
    private Solution(char name) {}

    Solution(String name, String name2) {}
    Solution(String name, Integer name2) {}
    Solution(String name, double name2) {}

}

