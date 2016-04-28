package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream oOS) throws IOException{
            throw new NotSerializableException("Нельзя сериализовать класс");
        }
		private void readObject(ObjectInputStream oIS) throws IOException, ClassNotFoundException{
			throw new NotSerializableException("Нельзя десериализовать класс");
		}
    }
}
