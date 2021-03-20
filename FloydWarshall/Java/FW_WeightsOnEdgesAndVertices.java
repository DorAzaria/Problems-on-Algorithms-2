package FloydWarshall.Java;

public class FW_WeightsOnEdgesAndVertices {
    static final int INF = 9999999;

    public static void main(String[] args) {
        int[] values = {1, 7, 10, 5};
        int[][] matrix = {
                {0, 5, INF, 20},
                {5, 0, 10, INF},
                {INF, 10, 0, 15},
                {20, INF, 15, 0}
        };
        System.out.println("GIVEN ORIGINAL MATRIX: (* = infinity): ");
        print(matrix);
        int[][] solution = FloydWarshall(matrix,values);
    }
    public static int[][] FloydWarshall(int[][] matrix, int[] values) {
        int[][] temp = new int[matrix.length][matrix.length];


        System.out.println("SET AND COPY TO NEW MATRIX THE FOLLOWING FORMULA: ");
        System.out.println("( TEMP[I][J] = 2*MATRIX[I][J] + VALUES[I] + VALUES[J] ):");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(i==j) {
                    temp[i][j] = values[i];
                }
                else if(matrix[i][j] > 0 && matrix[i][j] != INF) {
                    temp[i][j] = 2*matrix[i][j] + values[i] + values[j];
                }
                if(matrix[i][j] == INF) {
                    temp[i][j] = INF;
                }
            }
        }
        print(temp);

        System.out.println("FOLLOWING FLOYD WARSHALL ALGO (WITH WRONG WEIGHTS): ");
        for(int k = 0 ; k < matrix.length; k++) {
            for(int i = 0 ; i < matrix.length; i++) {
                for(int j = 0 ; j < matrix.length; j++) {
                    if(i != j) {
                        temp[i][j] = Math.min(temp[i][j], temp[i][k] + temp[k][j]);
                    }
                }
            }
        }
        print(temp);

        System.out.println("FIXING WRONG WEIGHTS BY (V[SRC] + TEMP[SRC][DST] + V[DST])/2 ");
        int[][] solution = new int[matrix.length][matrix.length];
        for(int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(i != j) {
                    solution[i][j] = (values[i] + temp[i][j] + values[j])/2;
                } else {
                    solution[i][j] = values[i];
                }
            }
        }
        print(solution);
        return solution;
    } // END OF FloydWarshall() METHOD

    /************************************************************************************/
    public static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == INF) {
                    System.out.print("*  ");
                }
                else if(matrix[i][j] < 10) {
                    System.out.print(matrix[i][j] + "  ");
                }
                else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
