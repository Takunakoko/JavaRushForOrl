package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String file = "C:\\1\\tt.txt";
        Solution savedObject = new Solution(2);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(savedObject);
        oos.close();

        Solution newObject = new Solution(1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        newObject = (Solution) ois.readObject();

    }
    transient private Thread runner;
    private int speed;

    public Solution(){
    }
    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        System.out.println("Нить запущена со скростью " + speed + " ударов в секунду:");
       try {
           runner.sleep(1000/speed);
       }catch (InterruptedException e) {e.printStackTrace(); }
            System.out.println("Нить остановлена со скростью " + speed + " ударов в секунду:");
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);              //Здесь запускаем объект класса по новой
        runner.start();                         //Для запуска нити после загрузки объекта
    }
}
