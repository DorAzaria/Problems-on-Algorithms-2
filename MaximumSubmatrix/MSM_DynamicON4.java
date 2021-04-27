package MaximumSubmatrix;

public class MSM_DynamicON4 {

    public static int[] maxSumMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;
        int[][] sumMat = new int[n][m];
        sumMat[0][0] = mat[0][0];

        for(int i = 1 ; i < n ; i++)
            sumMat[i][0] = sumMat[i-1][0] + mat[i][0];


        for(int j = 1 ; j < m ; j++)
            sumMat[0][j] = sumMat[0][j-1] + mat[0][j];

        for(int i = 1 ; i < n ; i++) { // O(N*M)
            for(int j = 1 ; j < m; j++) {
                sumMat[i][j] = mat[i][j] + sumMat[i][j-1] + sumMat[i-1][j] - sumMat[i-1][j-1];
            }
        }

        int maxSum = 0, sum = 0;
        int ii = 0, jj = 0, kk = 0, ll = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                for(int k = i ; k < n ; k++) {
                    for(int l = j ; l < m ; l++) {

                        if(i==0 && j==0) sum = sumMat[k][l];
                        if(i==0 && j>0) sum = sumMat[k][l] - sumMat[k][j-1];
                        if(i>0 && j==0) sum = sumMat[k][l] - sumMat[i-1][l];
                        if(i>0 && j>0)
                            sum = sumMat[k][l] - sumMat[k][j-1] - sumMat[i-1][l] + sumMat[i-1][j-1];

                        if(sum > maxSum) {
                            maxSum = sum;
                            ii = i;
                            jj = j;
                            kk = k;
                            ll = l;
                        }
                    }
                }
            }
        }

        return new int[] {maxSum, ii, jj, kk, ll};
    }




}
