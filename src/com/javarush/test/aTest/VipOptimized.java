package com.javarush.test.aTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 18.10.2015.
 */
public class VipOptimized
{
        private static final int MAX_DIGITS = 14;

        public static long[]  getNumbers(int maxVal)
        {
            List<Integer> result = new ArrayList<>();

            int[] digits = new int[MAX_DIGITS];
            int length = 1;
            long sum = 0;
            long[][] diffCache = new long[10][MAX_DIGITS];

            // Set up the diffCache array.
            {
                long[] powerValues = {0,1,2,3,4,5,6,7,8,9};
                for (int j = 1; j < MAX_DIGITS; j++) {
                    // powerValues[i] holds the value of: i ^ j
                    diffCache[0][j] = -powerValues[9];
                    for (int i = 1; i < 10; i++)
                        diffCache[i][j] = powerValues[i] - powerValues[i-1];

                    // Update powerValues[i] to hold the next higher power
                    for (int i = 1; i < 10; i++)
                        powerValues[i] *= i;
                }
            }

            // Iterate through every number from 0..maxVal to find Armstrong numbers.
            for (int num = 0; num <= maxVal; num++) {
                // If the number is equal to the sum, this is an Armstrong number.
                if (num == sum)
                    result.add(num);

                // Update digits by adding 1 to the ones digit and carrying to higher
                // digits as necessary.  We update the length of the number if we
                // carry to a digit not previously used.  The sum is also updated
                // as we update each digit.
                int i = 0;
                while (true) {
                    if (++digits[i] == 10) {
                        digits[i] = 0;
                        sum += diffCache[0][length];
                        if (++i == length) {
                            // Note that the sum must be 0 at this point, because
                            // all the digits are 0 when we carry over to a new length.
                            length++;
                        }
                        continue;
                    }
                    sum += diffCache[digits[i]][length];
                    break;
                }
            }

            long[] res = new long[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i]=result.get(i);
            }
            return res;

        }
        public static void main(String[] args) {

            int N = Integer.MAX_VALUE-1;

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

