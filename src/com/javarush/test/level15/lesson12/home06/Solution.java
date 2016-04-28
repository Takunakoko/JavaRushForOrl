package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()                                          1   +
Static block                                                2   +
public static void main                                     3   +
non-static block                                            4   +
static void printAllFields                                  5   +
0                                                           6
null                                                        7
Solution constructor                                        8   +
static void printAllFields                                  9   +
6                                                           10  +
First name                                                  11  +
*/

public class Solution {
    static {
        init();
    }                                                       //1
    static {
        System.out.println("Static block");
    }                                                       //2

    {
        System.out.println("non-static block");
        printAllFields(this);                               //5
    }                                                       //4

    public int i = 6;

    public String name = "First name";



    public Solution() {
        System.out.println("Solution constructor");         //8
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }                                                       //3

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");   //9
        System.out.println(obj.i);                          //10
        System.out.println(obj.name);                       //11
    }
}
