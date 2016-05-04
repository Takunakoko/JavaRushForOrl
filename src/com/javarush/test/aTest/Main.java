package com.javarush.test.aTest;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static long[] getNumbers(long N){
        List<Long> result = new ArrayList<>();
        long[] pows = {0,1,2,3,4,5,6,7,8,9};
        int[] nums = new int[32];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=0;
        }
        int length = 1;
        boolean flag = false;
        for (long i = 1; i < N; i++) {
            long t = i;
            int iter = 0;
            while (t!=0){
                int b = (int)t%10;
                if (length==iter && flag){
                    flag = false;
                    length++;
                    for (int i1 = 2; i1 < pows.length; i1++) {
                        pows[i1]=pows[i1]*i1;
                    }
                }
                if (b!=0){
                    nums[iter] = b;
                    break;
                } else if (iter==0){
                    nums[iter] = b;
                    flag = true;
                }
                else nums[iter] = b;
                t = t/10;
                iter++;
            }
            //CALC
            long sum = 0;
            for (int i1 = 0; i1 < length; i1++) {
                int num = nums[i1];
                sum += pows[num];
            }
            if (sum==i)
                result.add(i);
        }
        long[] res = new long[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i]=result.get(i);
        }
        return res;
    }


    public static void main(String[] args) {

        long N = Integer.MAX_VALUE-1;

        long start = System.currentTimeMillis();

        long[] res = getNumbers(N);

        long end = System.currentTimeMillis();
        long memory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /1024 /1024;
        System.out.println("Потрачено: \t" + (end - start) /1000 + "сек ("+(end-start)+"мс)");
        System.out.println("Память: \t" + memory + "mb");

        for (long re : res) {
            System.out.print(re + " ");
        }
    }


}