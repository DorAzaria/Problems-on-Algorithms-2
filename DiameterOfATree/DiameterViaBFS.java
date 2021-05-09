package DiameterOfATree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiameterViaBFS {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 100000;

    public int getDiameter(ArrayList<ArrayList<Integer>> graph) {
        int src = 0;
        int[] distances = BFS(graph,src);
        int maxValue = 0, maxIndex = 0;

        for(int i = 0; i < distances.length; i++) {
            if(distances[i] > maxValue) {
                maxValue = distances[i];
                maxIndex = i;
            }
        }

        distances = BFS(graph,maxIndex);

        int diameter = 0;
        for(int i = 0; i< distances.length; i++) {
            if(distances[i] > diameter) {
                diameter = distances[i];
            }
        }

        return diameter;
    }

    private int[] BFS(ArrayList<ArrayList<Integer>> graph, int src) {
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

        return distances;
    }
}
