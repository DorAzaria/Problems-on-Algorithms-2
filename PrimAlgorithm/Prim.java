package PrimAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {
    private ArrayList<Node>[] graph;
    private Edge[] tree;
    private int[] color, parent, weight_arr;
    private Node[] nodes;
    private PriorityQueue<Node> queue;
    private static final int white = 0, grey = 1, black = 2;
    private static final int infinity = Integer.MAX_VALUE;
    private int s;

    public Prim(ArrayList<Node>[] graph, int s) {
        this.graph = graph;
        this.s = s;
        int n = graph.length;
        color = new int[n];
        parent = new int[n];
        weight_arr = new int[n];
        queue = new PriorityQueue<Node>();
        Arrays.fill(parent, -1);
        Arrays.fill(weight_arr, infinity);
        nodes = new Node[n];
        for (int i = 0; i < graph.length; i++) {
            nodes[i] = new Node(i, infinity);
        }
        tree = new Edge[n-1];
    }

    public void CreateMST() {
        color[s] = grey;
        weight_arr[s] = 0;
        nodes[s].weight = 0;
        queue.add(nodes[s]);
        int edges = 0;
        while(edges < graph.length - 1) {
            Node v = queue.poll();
            if(parent[v.id] != -1) {
                tree[edges++] = new Edge(v.id, parent[v.id], weight_arr[v.id]);
            }
            for(Node n : graph[v.id]) {
                int nid = n.id;
                if(color[nid] == white) {
                    color[nid] = grey;
                    weight_arr[nid] = n.weight;
                    parent[nid] = v.id;
                    nodes[nid].weight = n.weight;
                    queue.add(nodes[nid]);
                }
                else if(color[nid] == grey){
                    if(weight_arr[nid] > n.weight) {
                        weight_arr[nid] = n.weight;
                        nodes[nid].weight = n.weight;
                        queue.remove(nodes[nid]);
                        queue.add(nodes[nid]);
                    }
                }
            }
            color[v.id] = black;
        }

    }

    public Edge[] getTree() {
         return tree;
    }

    public int getSum() {
        int sumWeight = 0;
        for (int i = 0; i < weight_arr.length; i++) {
            sumWeight = sumWeight +weight_arr[i];
        }
        return sumWeight;
    }
}

class Edge {
    int v, u, weight;

    public Edge(int v1, int v2, int w) {
        this.v = v1;
        this.u = v2;
        this.weight = w;
    }

    @Override
    public String toString() {
        return "(" + u + "," + v + ",w:" + weight + ')';
    }
}

class Node implements Comparable<Node>{
    int id, weight;

    public Node(int id, int weigth) {
        this.id = id;
        this.weight = weigth;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }

}