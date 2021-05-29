package IsomorphicTrees;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeIsomorphism {

    static int WHITE = 0, GRAY = 1, BLACK = 2;

    public boolean isIsomorphic(ArrayList<ArrayList<Integer>> tree1,int root1, ArrayList<ArrayList<Integer>> tree2, int root2) {
        String code1 = generateCode(tree1, root1);
        String code2 = generateCode(tree2, root2);
        return code1.equals(code2);
    }

    public boolean isIsomorphicWithoutRoot(ArrayList<ArrayList<Integer>> tree1, ArrayList<ArrayList<Integer>> tree2) {
        int center_tree_1 = findCenterFire(tree1);
        int center_tree_2 = findCenterFire(tree2);
        return isIsomorphic(tree1,center_tree_1,tree2,center_tree_2);
    }

    private String generateCode(ArrayList<ArrayList<Integer>> tree, int root) {
        String[] traversalCode = new String[tree.size()];
        Arrays.fill(traversalCode, "0");
        int[] color = new int[tree.size()];
        getTraversalCode(root,tree,traversalCode,color);
        return sortNgetCode(traversalCode);
    }

    private void getTraversalCode(int current, ArrayList<ArrayList<Integer>> tree, String[] tc, int[] color) {
        if (tree.get(current).size() == 1) { // if its a leaf
            color[current] = BLACK;
            tc[current] = "01";
        } else {
            color[current] = BLACK;
            for(Integer neighbour : tree.get(current)) {
                if(color[neighbour] == WHITE) {
                    color[current] = GRAY;
                    getTraversalCode(neighbour, tree, tc, color);
                    tc[current] += tc[neighbour];
                }
            }
            tc[current]+=1;
        }
    }

    private String sortNgetCode(String[] traversalCode) {
        Arrays.sort(traversalCode); // O(NlogN)
        String sortedCode = "";
        int current = 1;
        while(current < traversalCode.length && traversalCode[current] != "01") {
            sortedCode += traversalCode[current];
            current++;
        }
        return sortedCode;
    }

    private int findCenterFire(ArrayList<ArrayList<Integer>> tree) {
        int number_of_nodes = tree.size();
        ArrayList<Integer> leaves = new ArrayList<>();
        int[] degree = new int[number_of_nodes];

        // init O(N)
        for(int i = 0; i < number_of_nodes; i++) {
            degree[i] = tree.get(i).size();
            if(degree[i] == 1) { // if its a leaf
                leaves.add(i);
            }
        }

        int nodes_to_burn = number_of_nodes;
        while(nodes_to_burn > 2) {
            int number_of_leaves = leaves.size();

            for(int i = 0; i < number_of_leaves; i++) {
                int current_leaf = leaves.remove(0);
                degree[current_leaf] = 0;
                nodes_to_burn--;
                for(Integer neighbour : tree.get(current_leaf)) {
                    degree[neighbour]--;
                    if(degree[neighbour] == 1){
                        leaves.add(neighbour);
                    }
                }
            }
        }
        int center1 = -1, center2 = -1;
        if(leaves.size()>1) {
            center1 = leaves.remove(0);
            center2 = leaves.remove(0);
        }
        else {
            center1 = leaves.remove(0);
        }
        return center1;
    }

    private void printCodes(String[] traversalCode) {
        for(int i = 0; i < traversalCode.length; i++) {
                System.out.print("node#"+i+"="+traversalCode[i]+", ");
        }
        System.out.println();
    }
}
