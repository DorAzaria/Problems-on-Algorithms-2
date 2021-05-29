package BuildTreeFromDegrees;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        //////////////////////////////////////// TEST 1
        int[] degree = {1,1,1,1,2,2,3,3};
        BuildTreeFromDegreesAlgorithm algo = new BuildTreeFromDegreesAlgorithm();
        System.out.println("/////////// TEST 1");
        System.out.println(Arrays.toString(algo.getTree(degree)));

        //////////////////////////////////////// TEST 2
        degree = new int[] {4,3,2,1,1,1,1,1};
        algo = new BuildTreeFromDegreesAlgorithm();
        System.out.println("/////////// TEST 2");
        System.out.println(Arrays.toString(algo.getTree(degree)));

        //////////////////////////////////////// TEST 3
        degree = new int[] {1,1,3,3,1,4,1,1,1};
        algo = new BuildTreeFromDegreesAlgorithm();
        System.out.println("/////////// TEST 3");
        System.out.println(Arrays.toString(algo.getTree(degree)));

        //////////////////////////////////////// TEST 4
        /*                  (6)
         *              (4) '
         *               | '
         *        (1)---(0)---(2)
         *             ` |
         *       (5) `  (3)
         */
        degree = new int[] {6,0,0,0,0,0,0,0};
        algo = new BuildTreeFromDegreesAlgorithm();
        System.out.println("/////////// TEST 4");
        System.out.println(Arrays.toString(algo.getTree(degree)));

    }
}
