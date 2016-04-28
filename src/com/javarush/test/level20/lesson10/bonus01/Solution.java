package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int[] result;
        List<Integer> temp = new ArrayList<>();
        int[][] matrix = new int[10][11];                   //таблица степеней 0-9 чесел
        for (int m = 0; m < 10; m++){
            for (int n =0; n < 11; n++){
                matrix[m][n] = (int) Math.pow(m, n);
            }
        }
        for (int i = 1; i < N; i++){
            int num = (int)Math.log10(i)+1;                  //узнаем количество цифр
            int summ = 0;
            int base = i;
            int modulo;
            while(base > 0){
                int temp1 = base / 10;
                modulo = base - temp1 * 10;
                summ += matrix[modulo][num];
                base = temp1;
            }
            if (summ == i) {
                temp.add(i);
            }
        }
        result = new int[temp.size()];
        for (int j = 0; j < temp.size(); j++)
            result[j] = temp.get(j);

        return result;
    }

    public static void main(String args[]){

        int N = 146_511_209;
        long start = System.currentTimeMillis();
        int[] res = getNumbers(N);
        long end = System.currentTimeMillis();
        long memory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /1024 /1024;

        System.out.println("Потрачено: \t" + (end - start) /1000 + "сек ("+(end-start)+"мс)");
        System.out.println("Память: \t" + memory + "mb");

        for(int i = 0; i < res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
