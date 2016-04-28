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

        Solution[] solutions = {solution1, solution2};

        solutions[0].innerClasses = new InnerClass[]{solution1.new InnerClass(), solution1.new InnerClass()};
        solutions[1].innerClasses = new InnerClass[]{solution2.new InnerClass(), solution2.new InnerClass()};
        return solutions;
    }
}
