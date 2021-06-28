package MaximumSubmatrix;

public class MSM_SuperBestProON3 {

    public static int[] maxSumMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;

        int maxSum = 0;
        int ii = 0, jj = 0, kk = 0, ll =0;

        for(int i = 0; i < m; i++) { // O(N*M^2)
            int[] arr = new int[n];
            for(int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    arr[k] += mat[k][j];
                }
                int[] best = bestLinear(arr);
                if(best[0] > maxSum) {
                    maxSum = best[0];
                    ii = best[1];
                    kk = best[2];
                    jj = i;
                    ll = j;
                }
            }
        }

        return new int[] {maxSum, ii, jj, kk, ll};
    }


    /*
    ###########################################################################
    ###########################################################################
    ###########################################################################
    ###########################################################################
     */
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

        return new int[] {maxSum, startIndex, endIndex};
    }


}
