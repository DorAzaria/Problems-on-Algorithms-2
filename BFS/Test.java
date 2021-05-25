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
        bfsAlgorithm.BFS(matrix,0,7); // 3

        matrix = new int[][] {
                {0,1,inf,inf,4,inf,inf},
                {0, 1, 2, 3, inf,inf,inf},
                {inf,1,2,inf,inf,inf,inf},
                {inf, 1,inf, 3, 4, 5,inf},
                {inf,inf,inf, 3, 4,inf,6},
                {inf,inf,inf,3,inf,5,inf},
                {inf,inf,inf,inf,4,inf,6}
        };
        bfsAlgorithm.BFS(matrix,0,6); // 2

////////////////// component exercises
        matrix = new int[][] {
                {0,1,2,inf,inf,inf,inf},
                {0, 1, 2, inf, inf,inf,inf},
                {0,1,2,inf,inf,inf,inf},
                {inf, inf,inf, 3, 4, inf,inf},
                {inf,inf,inf, 3, 4,inf,inf},
                {inf,inf,inf,inf,inf,5,6},
                {inf,inf,inf,inf,inf,6,6}
        };
        BFSComponents bfsComponents = new BFSComponents(matrix);
        System.out.println("Is graph is connected?: " + bfsComponents.checkConnectivity()); // false
        System.out.println("Number of components: " + bfsComponents.getNumberOfComponents()); // 3

        ArrayList<ArrayList<Integer>> allComponents = bfsComponents.getAllComponents();
        int componentID = 1;
        for(ArrayList<Integer> component : allComponents) {
            System.out.print("Component #"+componentID+": ");
            for(Integer node : component) {
                System.out.print(node +", ");
            }
            System.out.println();
            componentID++;
        }

        ArrayList<Integer> getComponent = bfsComponents.getComponentByNode(5);
        System.out.print("The nodes that found in the same component that 5 is in are: "); // 5,6,
        for(Integer node : getComponent) {
            System.out.print(node + ", ");
        }

////////////////// Bipartite exercise
        // test 1
        matrix = new int[][] {
                {1,inf,3,4},
                {inf,2,3,4},
                {1,2,3,inf},
                {1,2,inf,4}
        };
        BipartiteGraph bipartiteGraph = new BipartiteGraph();

        System.out.println("\n");
        System.out.println("Is graph bipartite? : " + bipartiteGraph.Bipartite(matrix,0)); // true

        // test 2
        matrix = new int[][] {
                {1,2,3,4},
                {inf,2,3,4},
                {1,2,3,inf},
                {1,2,inf,4}
        };

        System.out.println("Is graph bipartite? : " + bipartiteGraph.Bipartite(matrix,0)); // false

    }
}
