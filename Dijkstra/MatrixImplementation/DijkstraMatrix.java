package Dijkstra.MatrixImplementation;

import java.util.Arrays;
import java.util.HashSet;

public class DijkstraMatrix {
    public DijkstraMatrix() {}
    static int inf = 1000000;

    public void Dijkstra(int[][] matrix, int src, int dest) {
        int number_of_nodes = matrix.length;
        int[] distances = new int[number_of_nodes]; // represent the distances from src to any visited node
        HashSet<Integer> visited = new HashSet<>(); // a visited node will be added to this set.
        int[] previous = new int[number_of_nodes]; // the previous valid neighbour node

        // init the data structures.
        for(int i = 0; i < number_of_nodes; i++) {
            distances[i] = inf; previous[i] = -1;
        }

        distances[src] = 0;
        int current_node = getPriority(distances, visited);
        while(current_node != -1) {

            for(int i = 0 ; i < matrix.length ; i++) {
                if(matrix[current_node][i] != inf) {
                    int neighbour = i;
                    int new_distance = distances[current_node] + matrix[current_node][neighbour];
                    if (!visited.contains(neighbour) && distances[neighbour] > new_distance) {
                        distances[neighbour] = new_distance;
                        previous[neighbour] = current_node;
                    }
                }
            }
            visited.add(current_node);

            if(current_node == dest) break; // if we reached to the destination
            // else, keep iterating using the following priority method:
            current_node = getPriority(distances, visited);
        }

        System.out.println("Distance from ("+src+")->("+dest+") is: " +distances[dest]);

        current_node = dest;
        String path = "";
        while(previous[current_node] != -1) { // (ONLY THE SOURCE IS -1 IN THIS CASE)
            path = " -> " + current_node + path;
            current_node = previous[current_node]; // Go back.
        }
        path = current_node + path;
        System.out.println("Path is: "+ path + "\n");
        System.out.println(Arrays.toString(distances));
    }

    private static int getPriority(int[] distances, HashSet<Integer> visited) {
        int minIndex = inf, minValue =inf;
        for(int i = 0; i < distances.length; i++) {
            if(!visited.contains(i) && distances[i] < minValue) {
                minIndex = i;
                minValue = distances[i];
            }
        }
        return minIndex;
    }

}
