package com.javarush.test.level25.lesson02.task02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new LinkedList<>();
            while(wheels.size() != 4){                          //создаем список из 4 пустых элементов
                wheels.add(null);                               //чтоб можно было заполнять его в разнобой
            }
            String[] loadWheels = loadWheelNamesFromDB();
            if (loadWheels.length == 4)
                for (String string : loadWheels){
                    Wheel wheel = Wheel.valueOf(string);
                    int index = wheel.ordinal();                //ищем нужную позицию текущего элемента
                    wheels.set(index,wheel);                    //пишем в лист на нужную позицию
                }
            else
                throw new IllegalArgumentException();

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT", "FRONT_LEFT"};
        }
    }

    public static void main(String[] args)
    {
        Car car = new Car();
        for (Wheel wheel : car.wheels){
            System.out.println(wheel);
        }


    }
}
