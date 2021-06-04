package Fire;

import java.util.ArrayList;

public class Test {
    static int inf = 1000000;

    public static void main(String[] args) {
        /*
         * (0)---(1)---(2)---(3)---(4)
         *              |
         *       (6)---(5)---(7)
         */
        int[][] matrix = {
                {inf, 1, inf, inf, inf, inf, inf, inf},
                {0, inf, 2, inf, inf, inf, inf, inf},
                {inf, 1, inf, 3, inf, 5, inf, inf},
                {inf, inf, 2, inf, 4, inf, inf, inf},
                {inf, inf, inf, 3, inf, inf, inf, inf},
                {inf, inf, 2, inf, inf, inf, 6, 7},
                {inf, inf, inf, inf, inf, 5, inf, inf},
                {inf, inf, inf, inf, inf, 5, inf, inf}};

        FireAlgorithm fireAlgorithm = new FireAlgorithm(initGraph(matrix));
        System.out.print("Test 1 ----> ");
        System.out.print(" Radius: " + fireAlgorithm.radius);
        System.out.print(" Diameter: " + fireAlgorithm.diameter); // 4
        System.out.print(" Center1: " + fireAlgorithm.center1);
        System.out.print(" Center2: " + fireAlgorithm.center2);


        /////////////////////////////////////////////// TEST 2
        //radius = 3, diameter = 5, centers: 1, 4

        /*
         *  (0)---(1)---(2)---(3)
         *         |
         *        (4)---(5)---(6)
         */
        matrix = new int[][] {
                {inf,1,inf,inf,inf,inf,inf},
                {1,inf,1,inf,4,inf,inf},
                {inf,1,inf,1,inf,inf,inf},
                {inf,inf,1,inf,inf,inf,inf},
                {inf,1,inf,inf,inf,1,inf},
                {inf,inf,inf,inf,1,inf,1},
                {inf,inf,inf,inf,inf,1,inf}
        };
        fireAlgorithm = new FireAlgorithm(initGraph(matrix));
        System.out.print("\nTest 2 ----> ");
        System.out.print(" Radius: " + fireAlgorithm.radius);
        System.out.print(" Diameter: " + fireAlgorithm.diameter); // 5
        System.out.print(" Center1: " + fireAlgorithm.center1);
        System.out.print(" Center2: " + fireAlgorithm.center2);

        /////////////////////////////////////////////// TEST 3
        //radius = 2, diameter = 4, centers: 2

        /*
         *  (0)---(1)---(2)---(3)---(4)
         */
        matrix = new int[][] {
                {inf,1,inf,inf,inf},
                {1,inf,1,inf,inf},
                {inf,1,inf,1,inf},
                {inf,inf,1,inf,1},
                {inf,inf,inf,1,inf}
        };
        fireAlgorithm = new FireAlgorithm(initGraph(matrix));
        System.out.print("\nTest 3 ----> ");
        System.out.print(" Radius: " + fireAlgorithm.radius);
        System.out.print(" Diameter: " + fireAlgorithm.diameter); // 4
        System.out.print(" Center1: " + fireAlgorithm.center1);
        System.out.print(" Center2: " + fireAlgorithm.center2);

        /////////////////////////////////////////////// TEST 4
        //radius = 4, diameter = 7, centers: 3, 4
        /*
         *  (0)---(1)---(2)---(3)---(4)---(5)---(6)---(7)
         */
        matrix = new int[][] {
                {inf,1,inf,inf,inf,inf,inf, inf},
                {1,inf,1,inf,inf,inf,inf, inf},
                {inf,1,inf,1,inf,inf,inf, inf},
                {inf,inf,1,inf,1,inf,inf, inf},
                {inf,inf,inf,1,inf,1,inf, inf},
                {inf,inf,inf,inf,1,inf,1, inf},
                {inf,inf,inf,inf,inf,1,inf,1},
                {inf,inf,inf,inf,inf,inf,1,inf}
        };
        fireAlgorithm = new FireAlgorithm(initGraph(matrix));
        System.out.print("\nTest 4 ----> ");
        System.out.print(" Radius: " + fireAlgorithm.radius);
        System.out.print(" Diameter: " + fireAlgorithm.diameter); // 7
        System.out.print(" Center1: " + fireAlgorithm.center1);
        System.out.print(" Center2: " + fireAlgorithm.center2);

        /////////////////////////////////////////////// TEST 5
        //radius = 3, diameter = 5, centers: 2, 4

        /*
         *  (0)---(1)---(2)---(6)
         *               |
         *              (4)---(5)---(3)
         */
        matrix = new int[][] {
                {inf,1,inf,inf,inf,inf,inf},
                {1,inf,1,inf,inf,inf,inf},
                {inf,1,inf,inf,1,inf,1},
                {inf,inf,inf,inf,inf,1,inf},
                {inf,inf,1,inf,inf,1,inf},
                {inf,inf,inf,1,1,inf,inf},
                {inf,inf,1,inf,inf,inf,inf}
        };

        fireAlgorithm = new FireAlgorithm(initGraph(matrix));
        System.out.print("\nTest 5 ----> ");
        System.out.print(" Radius: " + fireAlgorithm.radius);
        System.out.print(" Diameter: " + fireAlgorithm.diameter); // 5
        System.out.print(" Center1: " + fireAlgorithm.center1);
        System.out.print(" Center2: " + fireAlgorithm.center2);


        /////////////////////////////////////////////// TEST 6
        //radius = 1, diameter = 2, centers: 0
        /*                  (6)
         *              (4) '
         *               | '
         *        (1)---(0)---(2)
         *             ` |
         *       (5) `  (3)
         */
        matrix = new int[][] {
                {inf,1,1,1,1,1,1},
                {1,inf,inf,inf,inf,inf,inf},
                {1,inf,inf,inf,inf,inf,inf},
                {1,inf,inf,inf,inf,inf,inf},
                {1,inf,inf,inf,inf,inf,inf},
                {1,inf,inf,inf,inf,inf,inf},
                {1,inf,inf,inf,inf,inf,inf}
        };

        fireAlgorithm = new FireAlgorithm(initGraph(matrix));
        System.out.print("\nTest 6 ----> ");
        System.out.print(" Radius: " + fireAlgorithm.radius);
        System.out.print(" Diameter: " + fireAlgorithm.diameter); // 2
        System.out.print(" Center1: " + fireAlgorithm.center1);
        System.out.print(" Center2: " + fireAlgorithm.center2);
    }

    public static ArrayList<ArrayList<Integer>> initGraph(int[][] matrix) {
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(j == 0) G.add(new ArrayList<>());
                if(matrix[i][j] != inf)  G.get(i).add(j);
            }
        }
        return G;
    }
}
