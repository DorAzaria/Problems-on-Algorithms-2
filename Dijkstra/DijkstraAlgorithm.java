package Dijkstra;
import java.util.*;

public class DijkstraAlgorithm {
    private final int node_size;
    ArrayList<ArrayList<Node> > neighbours;

    public DijkstraAlgorithm(int ns) {
        this.node_size = ns;
        this.neighbours = new ArrayList<>();
        for (int i = 0; i < node_size; i++)
            neighbours.add(new ArrayList<>());
    }

    public void addEdge(int node1, int node2, int value) {
        neighbours.get(node1).add(new Node(node2, value));
        neighbours.get(node2).add(new Node(node1, value));
    }

    public int[] Dijkstra(int src) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(node_size, new Node());
        HashSet<Integer> visitors = new HashSet<>();

        int[] distances = new int[node_size];
        for (int i = 0; i < node_size; i++)
            distances[i] = Integer.MAX_VALUE;

        priorityQueue.add(new Node(src, 0));
        distances[src] = 0;

        while(!priorityQueue.isEmpty()) {
            int current = priorityQueue.remove().key;
            visitors.add(current);

            for(Node neighbour : neighbours.get(current)) {
                if(!visitors.contains(neighbour.key)) {
                    int currentDistance = neighbour.value;
                    int newDistance = currentDistance + distances[current] ;
                    if(newDistance < distances[neighbour.key])
                        distances[neighbour.key] = newDistance;

                    priorityQueue.add(new Node(neighbour.key, distances[neighbour.key]));
                }
            }
        }
        return distances;
    }

    static class Node implements Comparator<Node> {
        public int key, value;

        public Node() { }

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.value, node2.value);
        }
    }
}

