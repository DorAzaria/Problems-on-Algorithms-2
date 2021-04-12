package MaximumSubarray;

import java.util.Arrays;

public class MaxSubarrayLinearTime {

    public static int[] bestLinear(int[] arr) {
        int maxSum = Integer.MIN_VALUE, tempSum = 0;
        int startIndex = 0, endIndex = 0, startTemp = 0;
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            if(tempSum > maxSum) {
                maxSum = tempSum;
                startIndex = startTemp;
                endIndex = i;
            }
            if(tempSum < 0) {
                tempSum = 0;
                startTemp = i + 1;
            }
            temp[i] = tempSum;
        }
        System.out.println(Arrays.toString(temp));

        return new int[] {maxSum, startIndex, endIndex};
    }

    public static void main(String[] args) {
        int[] sol = bestLinear(new int[] {7,-9,2,1});
        System.out.println("Max = "+sol[0] +", Start = " + sol[1] + ", End = "+sol[2]);
        sol = bestLinear(new int[] {2,-2,1,-4});
        System.out.println("Max = "+sol[0] +", Start = " + sol[1] + ", End = "+sol[2]);
    }
}
