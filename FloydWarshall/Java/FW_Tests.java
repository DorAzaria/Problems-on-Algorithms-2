package FloydWarshall.Java;

import java.util.HashMap;
import java.util.Vector;

public class FW_Tests {
    static int testcounter = 1;

    public static void testManager(FW_Boolean fw_boolean) {
        System.out.println("\n***************** Test "+testcounter+" *******************************");
        testcounter++;
        long start = System.currentTimeMillis();
        System.out.println("O(N^3) Generate matrix: ");
        fw_boolean.FloydWarshall();
        System.out.println("\nO(N^2) Is the graph connected?: " + fw_boolean.checkConnectivity());
        System.out.println("O(N) Is the graph connected?: " + fw_boolean.checkConnectivityOpt());
        System.out.println("O(N^2) Number of components: "+ fw_boolean.getNumberOfComponents());
        System.out.println("O(N^2) Show all components: ");
        HashMap<Integer, Vector<Integer>> components = fw_boolean.getComponents();
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

    public static boolean[][] booleanT1() {
        boolean T = true, F = false;
        boolean[][] matrix =
                {
                        {T, F, T, F},
                        {T, T, T, F},
                        {F, F, T, T},
                        {F, T, F, T}
                };
        return matrix;
    }

    public static boolean[][] booleanT2(){
        boolean [][] mat = {{true,true,true,false},
                {true,true,false,true},
                {true,false,true,true},
                {false,true,true,true}};

        return mat;
    }

    public static boolean[][] booleanT3(){
        boolean [][] mat = {{true,false,false,false},
                {false,true,true,true},
                {false,true,true,true},
                {false,true,true,true}};
        return mat;
    }

    public static boolean[][] booleanT4(){
        boolean [][] mat = {{true,true,false,false},
                {true,true,false,false},
                {false,false,true,true},
                {false,false,true,true}};
        return mat;
    }

    public static boolean[][] booleanT5(){
        boolean [][] mat = {{true,true,false},
                {true,true,true},
                {false,true,true}};
        return mat;
    }

    public static boolean[][] booleanT6(){
        boolean [][] mat = {{true,true,false,false},
                {true,true,true,false},
                {false,true,true,true},
                {false,false,true,true}};
        return mat;
    }

    public static boolean[][] booleanT7(){
        boolean [][] mat = {{true,true,false,false,true},
                {true,true,true,false,false},
                {false,true,true,true,false},
                {false,false,true,true,true},
                {true,false,false,true,true}};
        return mat;
    }

    //        V4
    //        /\
    //       /  \
    //      /____\
    //     V0     V5
    //    V6------V3
    //      |     |
    //	    |_____|
    //     V1     V2
    //

    public static boolean[][] booleanT8() {
        boolean[][] mat= {{false,false,false,false,true,true,false},
                {false,false,true,false,false,false,true},
                {false,true,false,true,false,false,false},
                {false,false,true,false,false,false,true},
                {true,false,false,false,false,true,false},
                {true,false,false,false,true,false,false},
                {false,true,false,true,false,false,false}};
        return mat;
    }

    public static void main(String[] args) {
        testManager(new FW_Boolean(booleanT1()));
        testManager(new FW_Boolean(booleanT2()));
        testManager(new FW_Boolean(booleanT3()));
        testManager(new FW_Boolean(booleanT4()));
        testManager(new FW_Boolean(booleanT5()));
        testManager(new FW_Boolean(booleanT6()));
        testManager(new FW_Boolean(booleanT7()));
        testManager(new FW_Boolean(booleanT8()));

        FW_Boolean fw_boolean = new FW_Boolean(booleanT8());
        fw_boolean.FloydWarshall();
        System.out.println("Is path: " + fw_boolean.checkPath(6,4));

    }
}
