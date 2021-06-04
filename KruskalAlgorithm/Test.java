package KruskalAlgorithm;
import KruskalAlgorithm.Kruskal.Edge;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        /* TEST 1 ============================= */
        Kruskal kruskal = new Kruskal(test1());
        System.out.println(Arrays.toString(kruskal.getTree()));
        // [{7, 8, 1}, {6, 7, 2}, {3, 9, 2}, {1, 2, 4}, {3, 6, 4}, {3, 4, 7}, {2, 3, 8}, {4, 5, 9}, null]

        /* TEST 2 ============================= */
        kruskal = new Kruskal(test2());
        System.out.println(Arrays.toString(kruskal.getTree()));
        // [{1, 4, 4}, {2, 3, 5}, {1, 2, 7}, {4, 5, 10}, {5, 6, 11}, null]

        /* TEST 3 ============================= */
        kruskal = new Kruskal(test3());
        System.out.println(Arrays.toString(kruskal.getTree()));
        // [{5, 7, 2}, {1, 2, 6}, {7, 8, 8}, {3, 4, 9}, {7, 1, 11}, {4, 5, 14}, {5, 6, 21}, null]

    }

    public static Edge[] test1(){
        int numOfEdges = 14;
        Edge[] graph  = new Edge[numOfEdges];
        graph[0] = new Edge(1,2,4);	// 1-st edge
        graph[1] = new Edge(2,3,8);	// 2-st edge
        graph[2] = new Edge(3,4,7);	// 3-st edge
        graph[3] = new Edge(4,5,9);	// 4-st edge
        graph[4] = new Edge(5,6,10);// 5-st edge
        graph[5] = new Edge(6,7,2);// 6-st edge
        graph[6] = new Edge(7,8,1);// 7-st edge
        graph[7] = new Edge(8,1,8);// 8-st edge
        graph[8] = new Edge(2,8,11);// 9-st edge
        graph[9] = new Edge(3,9,2);// 10-st edge
        graph[10] = new Edge(3,6,4);// 11-st edge
        graph[11] = new Edge(4,6,14);// 12-st edge
        graph[12] = new Edge(7,9,6);// 13-st edge
        graph[13] = new Edge(8,9,7);// 14-st edge
        return graph;
    }

    public static Edge[] test2(){
        int numOfEdges = 8;
        Edge[] graph  = new Edge[numOfEdges];
        graph[0] = new Edge(1,2,7);	// 1-st edge
        graph[1] = new Edge(2,3,5);	// 2-st edge
        graph[2] = new Edge(3,4,7);	// 3-st edge
        graph[3] = new Edge(4,5,10);	// 4-st edge
        graph[4] = new Edge(5,6,11);// 5-st edge
        graph[5] = new Edge(2,4,9);// 6-st edge
        graph[6] = new Edge(1,4,4);// 7-st edge
        graph[7] = new Edge(3,5,13);// 8-st edge
        return graph;
    }
    public static Edge[] test3(){
        int numOfEdges = 10;
        Edge[] graph  = new Edge[numOfEdges];
        graph[0] = new Edge(1,2,6);	// 1-st edge
        graph[1] = new Edge(2,3,19);	// 2-st edge
        graph[2] = new Edge(3,4,9);	// 3-st edge
        graph[3] = new Edge(4,5,14);	// 4-st edge
        graph[4] = new Edge(5,6,21);// 5-st edge
        graph[5] = new Edge(5,7,2);// 6-st edge
        graph[6] = new Edge(7,8,8);// 7-st edge
        graph[7] = new Edge(8,1,17);// 8-st edge
        graph[8] = new Edge(7,1,11);// 9-st edge
        graph[9] = new Edge(7,2,25);// 10-st edge
        return graph;
    }

}
