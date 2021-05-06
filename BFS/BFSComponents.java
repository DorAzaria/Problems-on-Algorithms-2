package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSComponents {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 100000;
    private ArrayList<ArrayList<Integer>> graph, components;
    private int number_of_components, number_of_nodes;
    private int[] color, parent, distances;

    public BFSComponents(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
        this.number_of_nodes = graph.size();
        this.number_of_components = 0; // each component is represent by its ID
        this.color = new int[number_of_nodes];
        this.distances = new int[number_of_nodes];
        this.parent = new int[number_of_nodes];
        this.components = new ArrayList<>();
        // about components[]:
        // each index is a node and the value is the component-id the node belong to.
        componentManager();
    }

    /**
     * Init the structures.
     * Use BFS for every unvisited component
     * Each component is represented in a 2D ArrayList that contains <ComponentID, Nodes list>
     */
    public void componentManager() {
        for(int i = 0 ; i < number_of_nodes; i++) { // init the structures
            color[i] = WHITE;
            distances[i] = inf;
            parent[i] = -1;
        }

        int nextComponent = getNextComponent(); // get the first component
        while(nextComponent != -1) { // while there is still more components to visit
            BFS(nextComponent); // use BFS with the given node-id which is inside the unvisited component
            nextComponent = getNextComponent(); // get the next unvisited component
        }

    }

    /**
     * get the next unvisited component
     * @return the node-id that have found in an unvisited component
     */
    private int getNextComponent() { // returns a node-id from another component
        for(int i = 0 ; i < distances.length; i++) {
            if(distances[i] == inf) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Just a simple BFS but with component data structure
     */
    public void BFS(int src) {
        components.add(new ArrayList<>());
        Queue<Integer> queue = new LinkedList<>();

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
            components.get(number_of_components).add(current);
        }
        this.number_of_components++;
    }

    /**
     * if there is only one component - return true
     * else, there is more than one component so the graph isn't connected.
     */
    public boolean checkConnectivity() {
        return this.number_of_components == 1;
    }


    /**
     * @return the number of components in the graph
     */
    public int getNumberOfComponents() {
        return this.number_of_components;
    }

    /**
     * @param node_id a node
     * @return every node which is in the same component that node_id is in.
     */
    public ArrayList<Integer> getComponentByNode(int node_id) {
        for(int i = 0 ; i < number_of_components; i++) {
            if(components.get(i).contains(node_id)) {
                return components.get(i);
            }
        }
        return null;
    }

    /**
     * @return a 2D ArrayList which represent the componentID and its nodes inside it.
     */
    public ArrayList<ArrayList<Integer>> getAllComponents() { // O(N)
        return this.components;
    }

}
