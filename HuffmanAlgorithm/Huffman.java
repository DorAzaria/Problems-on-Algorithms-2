package HuffmanAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Huffman {

    private char[] letters;
    private int[] frequency;
    private String[] huffman_code;
    private int[][] tree;
    private int number_of_letters, number_of_nodes;
    private Queue<Integer> queue1, queue2;
    static int weight = 0, left = 1, right = 2, parent = 3;

    // USING 2 QUEUES, O(N)
    public Huffman(char[] l, int[] f) {
        letters = l;
        frequency = f;
        number_of_letters = l.length;
        number_of_nodes = 2*number_of_letters -1;
        tree = new int[number_of_nodes][4];
        huffman_code = new String[number_of_letters];
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

        for(int i = 0; i < number_of_letters; i++) {
            tree[i][weight] = frequency[i];
            queue1.add(i);
        }
        generateTree();
        generateCode("",number_of_nodes-1);
    }

    private void generateTree() { // O(N)
        int current_parent = number_of_letters;

        while(queue1.size() + queue2.size() > 1) {
            /* getting left and right child by priority */
            int current_left = getMinimum();
            int current_right = getMinimum();
            /* add the same parent index to both child */
            tree[current_left][parent] = current_parent;
            tree[current_right][parent] = current_parent;
            /* add the weight to the parent by summing the weights
             *  of left child and right child */
            tree[current_parent][weight] = tree[current_left][weight] + tree[current_right][weight];
            /* adding the left and right child to the parent */
            tree[current_parent][left] = current_left;
            tree[current_parent][right] = current_right;
            /* adding the current parent to the second queue */
            queue2.add(current_parent);
            current_parent++;
        }
    }

    private int getMinimum() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return -1;
        }
        if(queue1.isEmpty()) {
            return queue2.poll();
        }
        if(queue2.isEmpty()) {
            return queue1.poll();
        }
        if(tree[queue1.peek()][weight] > tree[queue2.peek()][weight]) {
            return queue2.poll();
        }
        return queue1.poll();
    }

    private void generateCode(String code, int current_node) { // O(N)
        if(current_node < number_of_letters) {
            huffman_code[current_node] = code;
            return;
        }
        generateCode(code + "0", tree[current_node][left]);
        generateCode(code + "1", tree[current_node][right]);
    }

    public String getCode() {
        String code = "";

        for(int i = 0; i < number_of_letters; i++) {
            code += letters[i] + " = " + huffman_code[i] +",  ";
        }

        return code;
    }
}
