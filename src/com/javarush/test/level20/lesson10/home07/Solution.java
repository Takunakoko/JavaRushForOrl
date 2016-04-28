package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    public String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception
    {
        String fileName = "C:\\1\\t1.txt";
        String file = "C:\\1\\tt.txt";

        Solution solution = new Solution(fileName);
        solution.writeObject("Запись до сериализации");

        ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(file));
        oOS.writeObject(solution);
        oOS.close();

        ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(file));
        Solution newSolution = (Solution) oIS.readObject();

        newSolution.writeObject("Запись после сериализации");
        oIS.close();
        solution.close();
    }
}
//происходит вот что, если мы в этих методах не напишем ничего, кроме in.defaultReadObject() и out.defaultWriteObject()
//поведение механизма сериализации не изменится. Поэтому, чтобы сериализовать поле fileName, которое многие успешно
// догадались добавить, вообще-то незачем писать в методе writeObject() еще эту строку out.writeObject(fileName);
// ибо это за вас делает out.defaultWriteObject(ObjectOutputStream out); т.е. получается, что вы дважды сериализуете
// это поле. Так же и в методе readObject(ObjectInputStream in), незачем считывать еще раз это поле, т.к. оно уже
// десериализовано методом in.defaultReadObject();. В этом методе надо лишь создать новый файловый поток
// и инициализировать этим потоком наше поле из Solution. Так же правильно указывают в комментах на лшибку закрытия
// потоков в методах, которые не должны по своей логике этого делать.
