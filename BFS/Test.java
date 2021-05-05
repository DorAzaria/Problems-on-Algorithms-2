package BFS;

import java.util.ArrayList;

public class Test {
    static int inf = 1000000;

    public static void main(String[] args) {
        BFSAlgorithm bfsAlgorithm = new BFSAlgorithm();

        int[][] matrix = {
                {0 ,1 ,2 ,inf ,inf ,inf ,inf ,inf },
                {0 ,1 ,2 ,inf ,4 ,inf ,inf ,inf },
                {0 ,1 ,2 ,3 ,inf ,5 ,inf ,inf },
                {inf ,inf ,2 ,3 ,4 ,5 ,inf ,inf },
                {inf ,1 ,inf ,3 ,4 ,inf ,6 ,7 },
                {inf ,inf ,2 ,3 ,inf ,5 ,6 ,inf },
                {inf ,inf ,inf ,inf ,4 ,5 ,6 ,7 },
                {inf ,inf ,inf ,inf ,4 ,inf ,6 ,7 }};
        bfsAlgorithm.BFS(initGraph(matrix),0,7);

        matrix = new int[][] {
                {0,1,inf,inf,4,inf,inf},
                {0, 1, 2, 3, inf,inf,inf},
                {inf,1,2,inf,inf,inf,inf},
                {inf, 1,inf, 3, 4, 5,inf},
                {inf,inf,inf, 3, 4,inf,6},
                {inf,inf,inf,3,inf,5,inf},
                {inf,inf,inf,inf,4,inf,6}
        };
        bfsAlgorithm.BFS(initGraph(matrix),0,6);
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