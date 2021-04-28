package MaximumSubarray;

import java.util.Arrays;

public class MaxSubarrayDP1 {

    public static int maxSub(int[] arr) {
        int[][] mat = new int[arr.length][arr.length];
        int positiveCaseSum = 0;
        boolean positiveCase = true;

        /**
         * Fill the diagonal with arr values
         * And also check if there is no negative value,
         * If all values are positive, then just return the sum
         * of all the array itself.
         * else, continue to calculate the dynamic program.
         */
        for(int i = 0; i < mat.length; i++) {
            mat[i][i] = arr[i];
            if(arr[i] > 0) {
                positiveCaseSum += arr[i];
            } else {
                positiveCase &= false;
            }
        }
        if(positiveCase) {
            System.out.println("The max subarray is at mat[0]["+(arr.length-1)+"] = "+positiveCaseSum+".");
            return positiveCaseSum;
        }

        int max = Integer.MIN_VALUE;
        String subarray = "";

        for(int i = mat.length-2 ; i >= 0 ; i--) {
            for(int j = i+1 ; j < mat.length; j++) {
                mat[i][j] = arr[j] + mat[i][j-1];

                if(max < mat[i][j]) {
                    max = Math.max(Math.max(mat[i][j], arr[i]),arr[j]);
                }
            }
        }
        System.out.println(subarray);
        printMatrix(mat);
        return max;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix)
                .replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "));
    }

    public static void main(String[] args) {
        int[] arr = {-10,2,4,-3};
        int[] arr2= {2,4,-7,100,-90,1};
        System.out.println(maxSub(arr2));
    }
}
