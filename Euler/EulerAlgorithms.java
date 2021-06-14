package Euler;

import java.util.ArrayList;
import java.util.Stack;

public class EulerAlgorithms {


    public Stack<Integer> EulerianCycle(ArrayList<ArrayList<Integer>> graph, int start_node) {
        if(hasEulerianCycle(graph)) // there is a cycle also need to check connectivity via BFS
            return EulerianAlgorithm(graph,start_node);
        return new Stack<>();
    }

    private boolean hasEulerianCycle(ArrayList<ArrayList<Integer>> graph) {
        for(ArrayList<Integer> list : graph) {
            if (list.size() % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    public Stack<Integer> EulerianPath(ArrayList<ArrayList<Integer>> graph) {
        int start_index = hasEulerPath(graph); // also need to check connectivity via BFS
        return EulerianAlgorithm(graph,start_index);
    }

    private int hasEulerPath(ArrayList<ArrayList<Integer>> graph) {
        int counter = 0;
        int odd_index = -1;

        for(int i = 0 ; i < graph.size(); i++) {
            if(graph.get(i).size() % 2 == 1){
                counter++;
                odd_index = i;
            }
        }
        if(counter == 2) { // then there is an euler path!
            // return the start index of the path!
            return odd_index;
        }
        return -1;
    }

    private Stack<Integer> EulerianAlgorithm(ArrayList<ArrayList<Integer>> graph, int start_node) {
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
