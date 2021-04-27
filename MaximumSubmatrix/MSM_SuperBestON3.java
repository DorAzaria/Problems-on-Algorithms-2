package MaximumSubmatrix;

public class MSM_SuperBestON3 {

    public static int[] maxSumMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;

        int maxSum = 0;
        int ii = 0, jj = 0, kk = 0, ll =0;
        int[][] preSum = new int[n][m+1];

        for (int i = 0; i < n; i++) { // O(N*M)
            for (int j = 0; j < m; j++) {
                preSum[i][j+1] = preSum[i][j] + mat[i][j];
            }
        }
        printmat(preSum);

        for(int i = 0; i < m; i++) { // O(N*M^2)
            for(int j = i; j < m; j++) {
                int[] arr = new int[n];
                for (int k = 0; k < n; k++) {
                    arr[k] = preSum[k][j+1] - preSum[k][i];
                    System.out.println("arr["+k+"] = pre["+k+"]["+j+"+1] - pre["+k+"]["+i+"]");
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

    public static void printmat(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for(int i = 0 ; i < n ; i++) { // O(N*M)
            for(int j = 0 ; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
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
