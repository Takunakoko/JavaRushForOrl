package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Администратор on 20.12.2015.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse : horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        double winnerDistance = 0;
        Horse horseWinner = null;
        for (Horse horse : horses){
            if (horse.distance > winnerDistance){
                winnerDistance = horse.distance;
                horseWinner = horse;
            }
        }
        return horseWinner;
    }

    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        Horse horseFirst = new Horse("Сережа", 3, 0);
        Horse horseSecond = new Horse("Петя", 3, 0);
        Horse horseThird = new Horse("Валя", 3, 0);

        game.getHorses().add(horseFirst);
        game.getHorses().add(horseSecond);
        game.getHorses().add(horseThird);

        game.run();

        game.printWinner();
    }
}
