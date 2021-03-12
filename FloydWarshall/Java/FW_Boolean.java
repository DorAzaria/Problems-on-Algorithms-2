package FloydWarshall.Java;

import java.util.HashMap;
import java.util.Vector;

/**
 * Floyd-Warshall Algorithm for unweighted undirected graphs
 */
public class FW_Boolean {
    boolean[][] matrix;

    public FW_Boolean(boolean[][] matrix) {
        this.matrix = matrix;
    }
/******************************** 1. ALGORITHM ****************************************/

    /**
     * Floyd-Warshall Algorithm (Boolean)
     * Time Complexity - O(V^3)
     */
    public void FloydWarshall() {
        for(int k = 0 ; k < matrix.length; k++) {
            for(int i = 0 ; i < matrix.length; i++) {
                for(int j = 0 ; j < matrix.length; j++) {
                    matrix[i][j] = matrix[i][j] || (matrix[i][k] && matrix[k][j]);
                }
            }
        }
        printMatrix();
    }
/******************************** 2. CONNECTIVITY ****************************************/
    /**
     * 1st method - O(V^2)
     * @return true if the graph is connected
     */
    public boolean checkConnectivity() {
        for(int k = 0 ; k < matrix.length; k++) {
            for(int i = 0 ; i < matrix.length; i++) {
                if(!matrix[k][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 2nd method - O(V)
     * @return true if the graph is connected
     */
    public boolean checkConnectivityOpt() {
        for(int i = 0 ; i < matrix.length; i++) {
            if(!matrix[0][i]) {
                return false;
            }
        }
        return true;
    }

/*********************************** 3. COMPONENTS *************************************/
    /**
     * Time Complexity - O(V^2)
     * @return an array that represent the components
     */
    private int[] generateComponents() {
        int counter = 0;
        int[] check = new int[matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            if(check[i] == 0) {
                counter++;
                check[i] = counter;
            }
            for(int j = i+1; j < matrix.length; j++) {
                if(matrix[i][j] && check[j] == 0) {
                    check[j] = counter;
                }
            }
        }
        return check;
    }

    /**
     * Time Complexity - O(V^2)
     * @return the number of components
     */
    public int getNumberOfComponents(){
    int[] check = generateComponents();
    int max = 0;
    for(int i = 0; i < check.length; i++) {
        if(check[i] > max) {
            max = check[i];
        }
    }
    return max;
}
    /**
     * Time Complexity - O(V^2)
     * @return an HashMap that contains the components in Vectors.
     */
    public HashMap<Integer,Vector<Integer>> getComponents() {
    HashMap<Integer,Vector<Integer>> components = new HashMap<>();
    int[] check = generateComponents();
    for(int i = 0; i < check.length; i++) {
        if(!components.containsKey(check[i])) {
            components.put(check[i], new Vector<>());
        }
        components.get(check[i]).add(i);
    }
    return components;
}
/*********************************** 4. Path between V1 to V2 *************************************/
public boolean checkPath(int v1, int v2) {
    HashMap<Integer,Vector<Integer>> map = getComponents();
    int check = 0;

    for(Vector<Integer> vec : map.values()) {
        for(Integer num : vec) {
            if(v1 == num) {
                check++;
            }
            if(v2 == num) {
                check++;
            }
        }
        if(check == 2) {
            return true;
        }
        check = 0;
    }
    return false;
}

/*********************************** 5. ARRANGE MATRIX *************************************/

    public void ReArrangeMat() {
        ReArrangeCols();
        Transpose();
        ReArrangeCols();
        printMatrix();
    }

    private void ReArrangeCols() {
        int start = 0, end , row = 0;
        while (start<matrix.length-1) {
            row = start;
            end = matrix.length-1;
            while(start<end) {
                while(start < matrix.length && matrix[row][start])
                    start++;
                if (start == matrix.length) {
                    return;
                }
                while(!matrix[row][end])
                    end--;
                for (int i = 0; i < matrix.length; i++) {
                    SwapCols(i, start, end);

                }
                start++;
                end--;
            }
        }
    }

    private void SwapCols( int i, int start, int end) {
        boolean temp;
        temp = matrix[i][start];
        matrix[i][start] = matrix[i][end];
        matrix[i][end] = temp;
    }

    private void Transpose() {
        boolean temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

/********************************************************************************************/
    private void printMatrix() {
        System.out.println();
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix.length; j++) {
                if(matrix[i][j]) {
                    System.out.print("1  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }

    }
}
