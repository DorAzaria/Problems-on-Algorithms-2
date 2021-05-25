package DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    static int inf = 1000000;

    public static void main(String[] args) {
        int src = -1;
        int dest = -1;

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

        DFSAlgorithm dfs = new DFSAlgorithm(matrix);
        dfs.DFS(0);
        src = 0;
        dest = 7;
        System.out.print("Test 1 ----> ");
        System.out.print(" Previous: " + Arrays.toString(dfs.previous));
        System.out.print("\n\t\t\t  Path between ("+src+") to ("+dest+") : "+dfs.getPath(src,dest));


        /////////////////////////////////////////////// TEST 2
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

        dfs = new DFSAlgorithm(matrix);
        dfs.DFS(0);
        src = 3;
        dest = 6;
        System.out.print("\nTest 2 ----> ");
        System.out.print(" previous: " + Arrays.toString(dfs.previous));
        System.out.print("\n\t\t\t  Path between ("+src+") to ("+dest+") : "+dfs.getPath(src,dest));

        /////////////////////////////////////////////// TEST 3
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
        dfs = new DFSAlgorithm(matrix);
        dfs.DFS(0);
        src = 4;
        dest = 4;
        System.out.print("\nTest 3 ----> ");
        System.out.print(" previous: " + Arrays.toString(dfs.previous));
        System.out.print("\n\t\t\t  Path between ("+src+") to ("+dest+") : "+dfs.getPath(src,dest));

        /////////////////////////////////////////////// TEST 4
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
        dfs = new DFSAlgorithm(matrix);
        dfs.DFS(0);
        src = 0;
        dest = 7;
        System.out.print("\nTest 4 ----> ");
        System.out.print(" previous: " + Arrays.toString(dfs.previous));
        System.out.print("\n\t\t\t  Path between ("+src+") to ("+dest+") : "+dfs.getPath(src,dest));

        /////////////////////////////////////////////// TEST 5
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

        dfs = new DFSAlgorithm(matrix);
        dfs.DFS(0);
        src = 0;
        dest = 3;
        System.out.print("\nTest 5 ----> ");
        System.out.print(" previous: " + Arrays.toString(dfs.previous));
        System.out.print("\n\t\t\t  Path between ("+src+") to ("+dest+") : "+dfs.getPath(src,dest));

        /////////////////////////////////////////////// TEST 6
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

        dfs = new DFSAlgorithm(matrix);
        dfs.DFS(0);
        src = 6;
        dest = 5;
        System.out.print("\nTest 6 ----> ");
        System.out.print(" previous: " + Arrays.toString(dfs.previous));
        System.out.print("\n\t\t\t  Path between ("+src+") to ("+dest+") : "+dfs.getPath(src,dest));

        /////////////////////////////////////////////// TEST 7
        ///////////////// CHECK CYCLE DFS
        /*
         * (0)---(1)---(2)
         *        |     |
         *       (3)---(4)
         */
        matrix = new int[][] {
                {inf,1,inf,inf,inf},
                {1,inf,1,1,inf},
                {inf,1,inf,inf,1},
                {inf,1,inf,inf,1},
                {inf,1,inf,1,inf}
        };
        DFSCycles dfsCycles = new DFSCycles(matrix);
        dfs.DFS(0);
        System.out.print("\nTest 7 ----> ");
        System.out.print("Find cycle path: "+dfsCycles.getPathCycle());

    }

}
