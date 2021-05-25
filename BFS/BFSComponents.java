package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSComponents {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 1000000;
    private int[][] matrix;
    private ArrayList<ArrayList<Integer>> components;
    private int number_of_components, number_of_nodes;
    private int[] color, parent, distances;
    private int[] component_id;

    public BFSComponents(int[][] matrix) {
        this.matrix = matrix;
        this.number_of_nodes = matrix.length;
        this.number_of_components = 0; // each component is represent by its ID
        this.color = new int[number_of_nodes];
        this.distances = new int[number_of_nodes];
        this.parent = new int[number_of_nodes];
        this.component_id = new int[number_of_nodes]; // each index is node-id and its value is the componentID the node belongs to.
        this.components = new ArrayList<ArrayList<Integer>>(); // Each component is represented in a 2D ArrayList that contains <ComponentID, Nodes list>

        for(int i = 0 ; i < number_of_nodes; i++) { // init the structures
            color[i] = WHITE;
            distances[i] = inf;
            parent[i] = -1;
        }

        componentManager();
    }

    /**
     * Use BFS for every unvisited component
     * Each component is represented in a 2D ArrayList that contains <ComponentID, Nodes list>
     */
    public void componentManager() {
        int nextComponent = getNextComponent(); // get the first component
        while(nextComponent != -1) { // while there is still more components to visit
            components.add(new ArrayList<>()); // make a new ArrayList for the next unvisited component
            BFS(nextComponent); // use BFS with the given node-id which is inside the unvisited component
            nextComponent = getNextComponent(); // get the next unvisited component
        }
    }

    /**
     * Time Complexity - O(N)
     * get the next unvisited component
     * @return the node-id that have found in an unvisited component
     */
    private int getNextComponent() {
        for(int i = 0 ; i < distances.length; i++) {
            if(distances[i] == inf) {
                return i;
            }
        }
        return -1; // if all the components are visited
    }

    /**
     * Just a simple BFS but with component data structure
     */
    public void BFS(int src) {
        Queue<Integer> queue = new LinkedList<>();

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
            ///
            components.get(number_of_components).add(current); // add the node to the componentID
            component_id[current] = number_of_components; // index: node-id ,  value: component-id
            ///
        }
        number_of_components++;
    }

    /**
     * Time Complexity - O(1)
     * if there is only one component - return true
     * else, there is more than one component so the graph isn't connected.
     */
    public boolean checkConnectivity() {
        return number_of_components == 1;
    }


    /**
     * Time Complexity - O(1)
     * @return the number of components in the graph
     */
    public int getNumberOfComponents() {
        return number_of_components;
    }

    /**
     * Time Complexity - O(1)
     * @param node_id a node
     * @return every node which is in the same component that node_id is in.
     */
    public ArrayList<Integer> getComponentByNode(int node_id) {
        return components.get(component_id[node_id]);
    }

    /**
     * Time Complexity - O(1)
     * @return a 2D ArrayList which represent the componentID and its nodes inside it.
     */
    public ArrayList<ArrayList<Integer>> getAllComponents() {
        return components;
    }

}
