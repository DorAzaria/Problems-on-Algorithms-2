package DiameterOfAGraph;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterViaBFS {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 1000000;

    public int getDiameter(int[][] matrix) {
        int src = 0;
        int[] distances = BFS(matrix,src);
        int maxValue = 0, maxIndex = 0;

        for(int i = 0; i < distances.length; i++) {
            if(distances[i] > maxValue) {
                maxValue = distances[i];
                maxIndex = i;
            }
        }

        distances = BFS(matrix,maxIndex);

        int diameter = 0;
        for(int i = 0; i< distances.length; i++) {
            if(distances[i] > diameter) {
                diameter = distances[i];
            }
        }

        return diameter;
    }

    private int[] BFS(int[][] matrix, int src) {
        int number_of_nodes = matrix.length;
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
            for(int i = 0; i < number_of_nodes; i++) {
                if(color[i] == WHITE && matrix[current][i] != inf) {
                    color[i] = GRAY;
                    distances[i] = distances[current] + 1;
                    parent[i] = current;
                    queue.add(i);
                }
            }
            color[current] = BLACK;
        }

        return distances;
    }
}
