package FloydWarshall.Java;
import java.util.HashMap;

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
     * @return HashMap<NodeID, ComponentID>
     */
    public HashMap<Integer, Integer> generateComponents() {
        int counter = 0;
        HashMap<Integer, Integer> nodes = new HashMap<>();

        for(int i = 0; i < matrix.length; i++) {
            if(!nodes.containsKey(i)) {
                nodes.put(i,++counter);
            }
            for(int j = i+1; j < matrix.length; j++) {
                if(matrix[i][j] && !nodes.containsKey(j)) {
                    nodes.put(j,counter);
                }
            }
        }
        return nodes;
    }

    /**
     * Time Complexity - O(V^2)
     * @return the number of components
     */
    public int getNumberOfComponents(){
    HashMap<Integer, Integer> nodes = generateComponents();
    int max = 0;
    for(Integer number : nodes.values()) {
        if(number > max) {
            max = number;
        }
    }
    return max;
}

/*********************************** 4. Path between V1 to V2 *************************************/
// Checks if the two nodes in the same component.
public boolean checkPath(int v1, int v2) {
    HashMap<Integer, Integer> nodes = generateComponents();
    return nodes.containsKey(v1) && nodes.containsKey(v2)
            && nodes.get(v1).equals(nodes.get(v2));
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
    public void printMatrix() {
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
