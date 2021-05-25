package DiameterOfAGraph;

import java.util.ArrayList;

public class Test {
    static int inf = 1000000;

    public static void main(String[] args) {
        DiameterViaBFS diameterViaBFS = new DiameterViaBFS();

        int[][] matrix = {
                {0, 1, inf, inf, 4, inf, inf, inf},
                {0, 1, inf, inf, inf, 5, inf, inf},
                {inf, inf, 2, 3, inf, 5, 6, inf},
                {inf, inf, 2, 3, inf, inf, inf, 7},
                {0, inf, inf, inf, 4, inf, inf, inf},
                {inf, 1, 2, inf, inf, 5, 6, inf},
                {inf, inf, 2, inf, inf, 5, 6, 7},
                {inf, inf, inf, 3, inf, inf, 6, 7}};

        System.out.println("The diameter of the graph is: " + diameterViaBFS.getDiameter(matrix));
    }
}
