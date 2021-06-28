package Fire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FireAlgorithm {

    int center1, center2, radius, diameter;
    ArrayList<ArrayList<Integer>> tree;

    public FireAlgorithm(ArrayList<ArrayList<Integer>> t) {
        this.tree = t;
        this.center1 = -1;
        this.center2 = -1;
        this.radius = 0;
        this.diameter = 0;
        Fire();
    }

    public void Fire() {
        int number_of_nodes = tree.size();
        Queue<Integer> leaves = new LinkedList<>();
        int[] degree = new int[number_of_nodes];

        for(int i = 0; i < number_of_nodes; i++) { // O(|V|)
            degree[i] = tree.get(i).size();
            if(degree[i] == 1)
                leaves.add(i);
        }

        int nodes_to_burn = number_of_nodes;
        while(nodes_to_burn > 2) {
            int number_of_leaves = leaves.size();

            for(int i = 0 ; i < number_of_leaves; i++) {
                int current_leaf = leaves.remove(); // remove the first
                degree[current_leaf] = 0;
                nodes_to_burn--;
                for(int j = 0; j < tree.get(current_leaf).size(); j++) { // notify its neighbours
                    int neighbour = tree.get(current_leaf).get(j);
                    degree[neighbour]--;  // decrease degree of neighbours
                    if (degree[neighbour] == 1)
                        leaves.add(neighbour);
                }
            }
            radius++;
        }


        if(leaves.size()>1) {
            center1 = leaves.remove();
            center2 = leaves.remove();
            diameter = radius*2 + 1;
            radius++;
        }
        else {
            center1 = leaves.remove();
            center2 = center1;
            diameter = radius*2;
        }

    }
}
