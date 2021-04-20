package MaximumSubmatrix;

public class MSM_BestON4 {


    public static int[] maxSumMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;
        int maxSum = 0;
        int ii = 0, jj = 0, kk = 0, ll = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = i ; j < n; j++) {
                int[] arr = new int[m];
                for(int k = i ; k <= j; k++) {
                    for(int l = 0 ; l < m; l++) {
                        arr[l] += mat[k][l];
                    }
                }
                int[] best = bestLinear(arr);
                if(best[0] > maxSum) {
                    maxSum = best[0];
                    ii = i;
                    jj = best[1];
                    kk = j;
                    ll = best[2];
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
