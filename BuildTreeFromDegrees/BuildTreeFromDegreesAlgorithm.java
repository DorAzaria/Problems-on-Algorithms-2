package BuildTreeFromDegrees;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildTreeFromDegreesAlgorithm {

    public ArrayList<Integer>[] initTreeFromDegrees(int[] degrees){

        int sum = 0;
        for(int i = 0; i < degrees.length; i++) { // CHECK if it is a tree
            sum += degrees[i];
        }

        if(sum % 2 != 0) {
            System.out.println("THIS GRAPH IS NOT A TREE!");
            return new ArrayList[degrees.length];
        }

        Arrays.sort(degrees); // O(N)
        reverseArray(degrees); // O(N)
        int n = degrees.length;
        ArrayList[] tree = new ArrayList[n];

        for (int i = 0; i < tree.length; i++) { // O(N)
            tree[i] = new ArrayList<Integer>();
        }

        int vertex = 1;
        for (int i = 0; i < tree.length; i++) { // O(N)
            for (int j=0; j<degrees[i]; j++) { // O(|Adj(i)|)
                tree[i].add(vertex);
                tree[vertex].add(i);
                degrees[vertex]--;
                vertex++;
            }
            degrees[i] = 0;
        }

        return tree;
    }
    private void reverseArray(int[] arr){
        for (int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
}
