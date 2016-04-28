package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach beach)
    {
        int nameParam = name.compareTo(getName());
        int distParam = (int) (distance - beach.getDistance());
        int qualParam =  - quality + beach.getQuality();

        int result = 10000 * nameParam + 100 * distParam + qualParam;   //Объекты сравниваются по 3 параметрам
                                                                        //Независимо друг от друга
        return result;
    }
    public static void main(String []args){
        ArrayList<Beach> beaches = new ArrayList<Beach>();

        Beach beach1 = new Beach("Сосенки", 1f, 5);
        Beach beach2 = new Beach("Ижевскк", 1.5f, 5);
        Beach beach3 = new Beach("Воронеж", 1.4f, 6);
        Beach beach4 = new Beach("Шампань", 1.3f, 8);
        Beach beach5 = new Beach("Берегъа", 5.0f, 10);

        Beach beach[] = {beach1, beach2, beach3, beach4, beach5};
        Arrays.sort(beach);
        for (Beach x : beach){
            beaches.add(x);
            System.out.println(x.getName() + "/" + x.getDistance() + "/" + x.getQuality());
        }
        System.out.println(beach[1].compareTo(beach[2]));
        System.out.println(beach[2].compareTo(beach[3]));
        System.out.println(beach[1].compareTo(beach[3]));
    }

}

