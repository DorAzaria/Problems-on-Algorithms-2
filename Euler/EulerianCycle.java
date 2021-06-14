package Euler;

import java.util.ArrayList;
import java.util.Stack;

public class EulerianCycle {

    public Stack<Integer> CycleAlgorithm(ArrayList<ArrayList<Integer>> graph, int start_node) {
        if(start_node >= graph.size() || start_node < 0) {
            return new Stack<>();
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> path = new Stack<>();
        stack.push(start_node);

        while(!stack.isEmpty()) {
            int current = stack.peek();

            if(graph.get(current).size() == 0) {
                stack.pop();
                path.push(current);
            }
            else {
                int neighbour = graph.get(current).remove(0);
                stack.push(neighbour);
                graph.get(neighbour).removeIf(x->x==current);
            }
        }

        return path;
    }
}
