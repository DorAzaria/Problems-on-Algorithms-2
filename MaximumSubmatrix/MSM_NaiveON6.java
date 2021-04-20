package MaximumSubmatrix;

public class MSM_NaiveON6 {


    public static int[] maxSumMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;
        int maxSum = 0;
        int ii = 0, jj = 0, kk = 0, ll = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m; j++) {
                for(int k = i ; k < n; k++) {
                    for(int l = j ; l < m; l++) {
                        int sum = 0;
                        for(int x = i ; x <= k  ; x++) {
                            for(int y = j ; y <= l ; y++) {
                                sum += mat[x][y];
                            }
                            if(sum> maxSum) {
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
        }

        return new int[] {maxSum, ii, jj, kk, ll};
    }

}
