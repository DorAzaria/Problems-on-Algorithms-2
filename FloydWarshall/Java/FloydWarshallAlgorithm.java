package FloydWarshall.Java;

import java.util.Arrays;

public class FloydWarshallAlgorithm {
    final static int INF = 999999;

    public static void FloydWarshall(int[][] matrix) {
        for(int k = 0 ; k < matrix.length; k++) {
            for(int i = 0 ; i < matrix.length; i++) {
                for(int j = 0 ; j < matrix.length; j++) {
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix)
                .replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "));
    }
    public static void main(String[] args) {
        int[][] matrix =
                {
                {0,  INF, -2,INF},
                {4,    0,  3,INF},
                {INF,INF,  0,  2},
                {INF, -1,INF,  0}
                };
        /*
         *   0	|  -1	|  -2	|  0
         *   4	|  0	|  2	|  4
         *   5	|  1	|  0	|  2
         *   3	|  -1	|  1	|  0
         */

        FloydWarshall(matrix);
    }
}
