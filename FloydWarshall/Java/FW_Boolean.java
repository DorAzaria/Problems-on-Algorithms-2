package FloydWarshall.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/**
 * Floyd-Warshall Algorithm for unweighted undirected graphs
 */
public class FW_Boolean {
    static int testcounter = 1;
    boolean[][] matrix;

    public FW_Boolean(boolean[][] matrix) {
        this.matrix = matrix;
        testManager();
    }

    private void testManager() {
        System.out.println("\n***************** Test "+testcounter+" *******************************8");
        testcounter++;
        long start = System.currentTimeMillis();
        System.out.println("O(N^3) Generate matrix: ");
        FloydWarshall();
        System.out.println("\nO(N^2) Is the graph connected?: " + checkConnectivity());
        System.out.println("O(N) Is the graph connected?: " + checkConnectivityOpt());
        System.out.println("O(N^2) Number of components: "+ getNumberOfComponents());
        System.out.println("O(N^2) Show all components: ");
        HashMap<Integer,Vector<Integer>> components = getComponents();
        long end = System.currentTimeMillis();
        long time = end - start;
        int componentCounter = 1;
        for(Vector<Integer> vector : components.values()) {
            System.out.println("\tComponent #"+componentCounter);
            System.out.print("\t\t");
            for(Integer num : vector) {
                System.out.print("V"+num + " ");
            }
            System.out.println();
            componentCounter++;
        }

        System.out.println("## TOTAL TIME: "+time+"ms.");
    }
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
/********************************************************************************************/
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
/********************************************************************************************/
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
/********************************************************************************************/
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

/********************************************************************************************/
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
/********************************************************************************************/
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
/********************************************************************************************/
    private void printMatrix() {
        System.out.println(Arrays.deepToString(matrix)
                .replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "));
    }
/********************************************************************************************/
    public static void main(String[] args) {
        FW_Boolean fw1 = new FW_Boolean(FW_Tests.booleanT1());
        FW_Boolean fw2 = new FW_Boolean(FW_Tests.booleanT2());
        FW_Boolean fw3 = new FW_Boolean(FW_Tests.booleanT3());
        FW_Boolean fw4 = new FW_Boolean(FW_Tests.booleanT4());
        FW_Boolean fw5 = new FW_Boolean(FW_Tests.booleanT5());
        FW_Boolean fw6 = new FW_Boolean(FW_Tests.booleanT6());
        FW_Boolean fw7 = new FW_Boolean(FW_Tests.booleanT7());
        FW_Boolean fw8 = new FW_Boolean(FW_Tests.booleanT8());
    }
}
