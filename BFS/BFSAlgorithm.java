package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgorithm {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 100000;

    public void BFS(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        int number_of_nodes = graph.size();
        int[] color = new int[number_of_nodes];
        int[] distances = new int[number_of_nodes];
        int[] parent = new int[number_of_nodes];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < number_of_nodes; i++) {
            color[i] = WHITE;
            distances[i] = inf;
            parent[i] = -1;
        }
        queue.add(src);
        color[src] = GRAY;
        distances[src] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(Integer neighbour : graph.get(current)) {
                if(color[neighbour] == WHITE) {
                    color[neighbour] = GRAY;
                    distances[neighbour] = distances[current] + 1;
                    parent[neighbour] = current;
                    queue.add(neighbour);
                }
            }
            color[current] = BLACK;
        }

        String path = "";
        path = path + dest;
        int current = parent[dest];
        while(current != -1) {
            path = current + "->" + path;
            current = parent[current];
        }
        System.out.println("Distance of ("+src+")->("+dest+") : " + distances[dest]);
        System.out.println(path + "\n");
    }

}
