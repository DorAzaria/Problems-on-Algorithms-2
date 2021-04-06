package MaximumSubarray;

import java.util.Arrays;

public class MaxSubarrayCycle {

    public static int[] best(int[] arr) {
        int arrSum = 0;
        int[] NegArr = new int[arr.length];

        for(int i = 0 ; i < arr.length; i++) {
            arrSum += arr[i];
            NegArr[i] = (-1)*arr[i];
        }

        int[] regular = bestLinear(arr);
        int[] negative = bestLinear(NegArr);
        int cycleMax = arrSum - (-negative[0]);

        if(regular[0] > cycleMax) {
            return regular;
        }
        return new int[] {cycleMax, (negative[2] + 1)%arr.length, negative[1] - 1};
    }

    private static int[] bestLinear(int[] arr) {
        int maxSum = Integer.MIN_VALUE, tempSum = 0;
        int startIndex = 0, endIndex = 0, startTemp = 0;
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            temp[i] = tempSum;

            if(tempSum > maxSum) {
                maxSum = tempSum;
                startIndex = startTemp;
                endIndex = i;
            }
            if(tempSum < 0) {
                tempSum = 0;
                startTemp = i + 1;
            }
        }

        System.out.println(Arrays.toString(temp));

        return new int[] {maxSum, startIndex, endIndex};
    }


    public static void main(String[] args) {
        int[] sol = best(new int[] {6,74,-1,3});
        System.out.println("Max = "+sol[0] +", Start = " + sol[1] + ", End = "+sol[2]);
    }
}
