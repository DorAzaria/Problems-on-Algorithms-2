package Dijkstra.BidirectionalDijkstra;

import java.util.ArrayList;
import java.util.HashSet;

public class BiDijkstra {
    static int inf = 1000000;

    public BiDijkstra() {}

    public void Dijkstra(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> rgraph, int src, int dest, int[][] mat ) {

        int number_of_nodes = graph.size();
        int[] src_distance = new int[number_of_nodes];
        int[] dest_distance = new int[number_of_nodes];
        int[] src_previous = new int[number_of_nodes];
        int[] dest_previous = new int[number_of_nodes];
        HashSet<Integer> src_visitors = new HashSet<>(number_of_nodes);
        HashSet<Integer> dest_visitors = new HashSet<>(number_of_nodes);

        for(int i = 0; i < number_of_nodes; i++) {
            src_distance[i] = inf;
            dest_distance[i] = inf;
            src_previous[i] = -1;
            dest_previous[i] = -1;
        }

        src_distance[src] = 0;
        dest_distance[dest] = 0;

        int src_current = getPriority(src_distance, src_visitors);
        int dest_current = getPriority(dest_distance, dest_visitors);

        while(src_current != -1 && dest_current != -1) {

            //// FOR G ///////////////
            for(Integer neighbour : graph.get(src_current)) {
                int new_distance = src_distance[src_current] + mat[src_current][neighbour];
                if(!src_visitors.contains(neighbour) && src_distance[neighbour] > new_distance) {
                    src_distance[neighbour] = new_distance;
                    src_previous[neighbour] = src_current;
                }
            }
            src_visitors.add(src_current);
            if(src_visitors.contains(src_current) && dest_visitors.contains(src_current)) break;
            src_current = getPriority(src_distance, src_visitors);

            //// FOR G reverse////////////////
            for(Integer neighbour : rgraph.get(dest_current)) {
                int new_distance = dest_distance[dest_current] + mat[dest_current][neighbour];
                if(!dest_visitors.contains(neighbour) && dest_distance[neighbour] > new_distance) {
                    dest_distance[neighbour] = new_distance;
                    dest_previous[neighbour] = dest_current;
                }
            }
            dest_visitors.add(dest_current);
            if(src_visitors.contains(dest_current) && dest_visitors.contains(dest_current)) break;
            dest_current = getPriority(dest_distance, dest_visitors);

        } // end while

        int minDistance = inf, minIndex = -1;
        for(int i = 0; i < number_of_nodes; i++) {
            if( (src_visitors.contains(i) || dest_visitors.contains(i))
            &&  (src_distance[i] != inf && dest_distance[i] != inf)
            &&  (minDistance > src_distance[i] + dest_distance[i])) {
                minDistance = src_distance[i] + dest_distance[i];
                minIndex = i;
            }
        }

        System.out.println("Distance from ("+src+")->("+dest+") is: " +minDistance);

        // Generate path from source to connector node 'v'
        int current = minIndex;
        String path = "";
        while(src_previous[current] != -1) {
            path = " -> " + current + path;
            current = src_previous[current];
        }
        path = current + path;

        // Generate path from dest to connector node 'v'
        current = dest_previous[minIndex];
        String rpath = "";
        while(dest_previous[current] != -1) {
            rpath += " -> " + current;
            current = dest_previous[current];
        }
        rpath += " -> " + current;

        String total_path = path + rpath;
        System.out.println("Total path is: " + total_path + "\n");

    }

    public int getPriority(int[] distances, HashSet<Integer> visitors) {
        int minValue = inf, minIndex = inf;

        for(int i = 0; i < distances.length; i++) {
            if(!visitors.contains(i) && minValue > distances[i]) {
                minIndex = i;
                minValue = distances[i];
            }
        }

        return minIndex;
    }
}
