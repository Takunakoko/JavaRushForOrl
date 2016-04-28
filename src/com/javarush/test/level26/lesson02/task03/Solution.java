package com.javarush.test.level26.lesson02.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T>{

        ArrayList<Comparator<T>> listOfComparators;
        public CustomizedComparator(Comparator<T>...comparators)        //Надо создавать массив переменной длинны :-/
        {
            this.listOfComparators = new ArrayList<>(comparators.length);
            Collections.addAll(this.listOfComparators, comparators);
        }

        @Override
        public int compare(T o1, T o2)
        {
            int result = 0;
            for (Comparator compr : listOfComparators){
                result = compr.compare(o1, o2);
                if (result !=0){//Сравниваем по первому компаратору, если не равны, то выходим из цикла
                    return result;
                }
                else
                    continue;
            }//Если объекты одинаковые по всем компараторам, то вернется проинициализированный 0
            return result;
        }
    }
}
