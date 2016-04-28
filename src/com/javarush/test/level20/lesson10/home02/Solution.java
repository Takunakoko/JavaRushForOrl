package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{                  //в классе содержится метод, который тоже необходимо серелизовать
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException
    {
        Object object = objectStream.readObject();
        if (object instanceof B) {
            return  (B) object;
        }else if (object instanceof A){
            return (A) object;
        }else {
            return null;
        }
    }

    public class A implements Serializable{
        public A(){
        }
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String fileA = "C:\\1\\t1.txt";
        Solution solution = new Solution();
        Solution.B objectB = solution.new B();

        ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileA));

        oOS.writeObject(objectB);
        oOS.close();

        ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileA));
        solution.getOriginalObject(oIS);
    }
}
