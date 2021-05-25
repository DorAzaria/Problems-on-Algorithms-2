package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 1000000;

    public boolean Bipartite(int[][] matrix, int source ) {
        boolean bi_check = true;
        int number_of_nodes = matrix.length;
        int[] color = new int[number_of_nodes];
        int[] partition = new int[number_of_nodes];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < number_of_nodes; i++) {
            color[i] = WHITE;
        }

        color[source] = GRAY;
        partition[source] = 1;
        queue.add(source);

        while(!queue.isEmpty() && bi_check) {
            int current = queue.poll();

            for(int i = 0; i < matrix.length; i++) {
                if(bi_check && i!=current && matrix[current][i] != inf) {

                    if(partition[current] == partition[i]) {
                        bi_check = false;
                    }
                    else if(color[i] == WHITE) {
                        color[i] = GRAY;
                        partition[i] = 3 - partition[current];
                        queue.add(i);
                    }
                }
            }
            color[current] = BLACK;
        }
        return bi_check;
    }
}
