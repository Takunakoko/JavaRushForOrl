package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        boolean evenOfArray = (array.length % 2 == 0);
        int middleOfArray = array.length / 2;
        double median;
        Arrays.sort(array);

        if(!evenOfArray)
            median = array[middleOfArray];
        else
            median = (array[middleOfArray] + array[middleOfArray-1]) / 2.0;

        final double finalMedian = median;
        Arrays.sort(array, new Comparator<Integer>()
        {

            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result = (int) (Math.abs(o1 - finalMedian) - Math.abs(o2 - finalMedian));
                return result == 0 ? o1 - o2 : result;
            }
        });

        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = new Integer[(int) (7 + Math.random() * 5)];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int) (Math.random() * 50);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();
        sort(array);

        for (Integer n : array)
            System.out.print(n + " ");
    }
}
