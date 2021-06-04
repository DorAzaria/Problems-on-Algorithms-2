package PrimAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Prim prim = new Prim(test1(), 0);
        prim.CreateMST();
        System.out.println("TEST 1 =================================");
        System.out.println(Arrays.toString(prim.getTree()));
        // [(0,1,w:4), (0,7,w:8), (7,6,w:1), (6,5,w:2), (1,2,w:4), (7,8,w:2), (5,3,w:7), (5,4,w:9)]
        System.out.println("Sum="+prim.getSum()); // 37

        prim = new Prim(test2(), 0);
        prim.CreateMST();
        System.out.println("TEST 2 =================================");
        System.out.println(Arrays.toString(prim.getTree()));
        // [(0,1,w:3), (0,2,w:4)]
        System.out.println("Sum="+prim.getSum()); // 7

        prim = new Prim(test3(), 0);
        prim.CreateMST();
        System.out.println("TEST 3 =================================");
        System.out.println(Arrays.toString(prim.getTree()));
        // [(0,3,w:2), (0,1,w:1), (0,2,w:4)]
        System.out.println("Sum="+prim.getSum()); // 7
    }

    public static ArrayList<Node>[] test1(){
        int numOfVertexes = 9;
        ArrayList<Node>[] graph = new ArrayList[numOfVertexes];
        for (int i=0; i<numOfVertexes; i++) {
            graph[i] = new ArrayList<Node>();
        }
        // vertex: (adjacency vertex, key)
        // a - first vertex:
        graph[0].add(new Node(1,4)); graph[0].add(new Node(7,8));
        // b - second vertex:
        graph[1].add(new Node(0,4)); graph[1].add(new Node(2,8)); graph[1].add(new Node(7,11));
        // c - third vertex:
        graph[2].add(new Node(1,8)); graph[2].add(new Node(3,7)); graph[2].add(new Node(5,4)); graph[2].add(new Node(8,2));
        // d - 4-th vertex:
        graph[3].add(new Node(2,7)); graph[3].add(new Node(4,9)); graph[3].add(new Node(5,14));
        // e - 5-th vertex:
        graph[4].add(new Node(3,9)); graph[4].add(new Node(5,10));
        // f - 6-th vertex:
        graph[5].add(new Node(2,4)); graph[5].add(new Node(3,14)); graph[5].add(new Node(4,10)); graph[5].add(new Node(6,2));
        // f - 7-th vertex:
        graph[6].add(new Node(5,2)); graph[6].add(new Node(7,1)); graph[6].add(new Node(8,6));
        // f - 8-th vertex:
        graph[7].add(new Node(0,8)); graph[7].add(new Node(1,11)); graph[7].add(new Node(6,1)); graph[7].add(new Node(8,7));
        // f - 9-th vertex:
        graph[8].add(new Node(2,2)); graph[8].add(new Node(6,6)); graph[8].add(new Node(7,7));
        return graph;
    }

    public static ArrayList<Node>[] test2(){
        int numOfVertexes = 3;
        ArrayList<Node>[]graph = new ArrayList[numOfVertexes];
        for (int i=0; i<numOfVertexes; i++) {
            graph[i] = new ArrayList<Node>();
        }
        // vertex: (adjacency vertex, key)
        // a - first vertex:
        graph[0].add(new Node(1,3)); graph[0].add(new Node(2,4));
        // b - second vertex:
        graph[1].add(new Node(0,3)); graph[1].add(new Node(2,4));
        // c - third vertex:
        graph[2].add(new Node(0,4)); graph[2].add(new Node(1,4));
        return graph;
    }

    public static ArrayList<Node>[] test3(){
        int numOfVertexes = 4;
        ArrayList<Node>[] graph = new ArrayList[numOfVertexes];
        for (int i=0; i<numOfVertexes; i++) {
            graph[i] = new ArrayList<Node>();
        }
        graph[0].add(new Node(1,5)); graph[0].add(new Node(2,4)); graph[0].add(new Node(3,2));
        graph[1].add(new Node(0,5)); graph[1].add(new Node(3,1));
        graph[2].add(new Node(0,4));
        graph[3].add(new Node(0,2));  graph[3].add(new Node(1,1));
        // vertex: (adjacency vertex, key)
        return graph;
    }
}