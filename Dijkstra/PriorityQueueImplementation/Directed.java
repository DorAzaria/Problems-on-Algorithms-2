package Dijkstra.PriorityQueueImplementation;

import java.util.*;

public class Directed {
    private final int node_size;
    ArrayList<ArrayList<Directed.Node> > neighbours;

    public Directed(int ns) {
        this.node_size = ns;
        this.neighbours = new ArrayList<>();
        for (int i = 0; i < node_size; i++)
            neighbours.add(new ArrayList<>());
    }

    public void addEdge(int node1, int node2, int value) {
        neighbours.get(node1).add(new Directed.Node(node2, value));
    }

    public void Dijkstra(int src) {
        PriorityQueue<Directed.Node> priorityQueue = new PriorityQueue<>(node_size, new Directed.Node());
        HashSet<Integer> visitors = new HashSet<>();
        int[] previous = new int[node_size];

        int[] distances = new int[node_size];
        for (int i = 0; i < node_size; i++) {
            distances[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }


        priorityQueue.add(new Directed.Node(src, 0));
        distances[src] = 0;

        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.remove().key;
            visitors.add(current);

            for (Directed.Node neighbour : neighbours.get(current)) {
                if (!visitors.contains(neighbour.key)) {
                    int currentDistance = neighbour.value;
                    int newDistance = currentDistance + distances[current];
                    if (newDistance < distances[neighbour.key]) {
                        distances[neighbour.key] = newDistance;
                        previous[neighbour.key] = current;
                        priorityQueue.add(new Directed.Node(neighbour.key, distances[neighbour.key]));
                    }

                }
            }
        }
        System.out.println(Arrays.toString(distances));
    }
    static class Node implements Comparator<Directed.Node> {
        public int key, value;

        public Node() { }

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public int compare(Directed.Node node1, Directed.Node node2) {
            return Integer.compare(node1.value, node2.value);
        }
    }

    public static void main(String[] args) {
        Directed dgraph = new Directed(6);
        dgraph.addEdge(0,2,3);
        dgraph.addEdge(1,0,1);
        dgraph.addEdge(1,2,2);
        dgraph.addEdge(1,3,4);
        dgraph.addEdge(2,4,2);
        dgraph.addEdge(2,3,5);
        dgraph.addEdge(3,5,4);
        dgraph.addEdge(4,5,4);
        dgraph.Dijkstra(0);
    }
}
