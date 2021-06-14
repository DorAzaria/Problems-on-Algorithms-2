package Euler;

import java.util.ArrayList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {

        int[][] mat = {
                {0,1,1,0,0,0,0,1,1},
                {1,0,1,0,0,0,0,0,0},
                {1,1,0,1,0,0,0,1,0},
                {0,0,1,0,1,1,0,1,0},
                {0,0,0,1,0,1,0,0,0},
                {0,0,0,1,1,0,1,1,0},
                {0,0,0,0,0,1,0,1,0},
                {1,0,1,1,0,1,1,0,1},
                {1,0,0,0,0,0,0,1,0}
        };

        ArrayList<ArrayList<Integer>> graph = generateGraph(mat);
        EulerAlgorithms euler = new EulerAlgorithms();
        Stack<Integer> cycle = euler.EulerianCycle(graph,8);

        while(!cycle.isEmpty()) {
            System.out.print(cycle.pop()+ "->");
        }

        mat = new int[][] {
                {0,1,0,0,1},
                {1,0,1,1,0},
                {0,1,0,1,0},
                {0,1,1,0,1},
                {1,0,0,1,0}
        };

        Stack<Integer> path = euler.EulerianPath(generateGraph(mat));
        System.out.println();
        while(!path.isEmpty()) {
            System.out.print(path.pop()+ "->");
        }

    }

    public static ArrayList<ArrayList<Integer>> generateGraph(int[][] mat) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < mat.length; i++) {
            for(int j = 0 ; j < mat.length; j++) {
                if(j == 0) {
                    graph.add(new ArrayList<>());
                }
                if(mat[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        return graph;
    }
}
