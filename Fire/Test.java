package Fire;

import java.util.ArrayList;

public class Test {
    static int inf = 1000000;

    public static void main(String[] args) {

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
        System.out.println("Radius: " + fireAlgorithm.radius);
        System.out.println("Center1: " + fireAlgorithm.center1);
        System.out.println("Center2: " + fireAlgorithm.center2);
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
