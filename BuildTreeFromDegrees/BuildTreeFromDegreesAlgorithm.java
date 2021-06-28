package BuildTreeFromDegrees;
import java.util.Arrays;

public class BuildTreeFromDegreesAlgorithm {

    public int[] getTree(int[] degrees) {
        int sum = 0;

        for(int degree : degrees) {
            sum += degree;
        }

        if(sum != 2*(degrees.length-1)) {
            System.out.println("This degree array can't generate a tree due to definition");
            return new int[] {};
        }

        int[] tree = new int[degrees.length];
        Arrays.sort(degrees);
        int j = 0;
        for(int i = 0; i < degrees.length; i++) {
            if(degrees[i] > 1){
                j = i;
                break;
            }
        }

        for(int i = 0; i < degrees.length-2; i++) {
            tree[i] = j;
            degrees[j]--;

            if(degrees[j] == 1) {
                j++;
            }
        }
        tree[degrees.length-1] = degrees.length;
        return tree;
    }
}
