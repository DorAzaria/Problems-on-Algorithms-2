package DFS;

public class DFSCycles {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 1000000;
    int[][] matrix;
    int number_of_nodes, time, startCycle, endCycle;
    int[] color, previous, first, last;
    boolean hasCycle;

    public DFSCycles(int[][] mat) {
        this.matrix = mat;
        this.number_of_nodes = mat.length;
        this.color = new int[number_of_nodes];
        this.previous = new int[number_of_nodes];
        this.first = new int[number_of_nodes];
        this.last = new int[number_of_nodes];
    }

    public void DFS(int source) {
        for(int i = 0; i < number_of_nodes; i++) {
            color[i] = WHITE;
            previous[i] = -1;
            first[i] = 0;
            last[i] = 0;
        }
        this.time = 0;
        startCycle = -1;
        endCycle = -1;
        hasCycle = false;
        DFS_Visit(source);
    }

    private void DFS_Visit(int current) {
        color[current] = GRAY;
        first[current] = ++time;

        for(int i = 0 ; i < number_of_nodes; i++) {
            if(i != current && matrix[current][i] != inf) { // if it's a neighbour

                if(color[i] == GRAY && previous[current] != i && !hasCycle) {
                    hasCycle = true;
                    startCycle = current;
                    endCycle = i;
                }
                if(color[i] == WHITE) { // if it's not visited
                    color[i] = GRAY;
                    previous[i] = current;
                    DFS_Visit(i);
                }
            }
        }
        color[current] = BLACK;
        last[current] = ++time;
    }

    public String getPathCycle() {
        String path = "";
        boolean foundCycle = false;

        for(int i=0; !foundCycle && i<number_of_nodes; i++){
            for(int j = 0; j < number_of_nodes; j++) {
                if(matrix[i][j] != inf && i != j) {
                    int src = matrix[i][j];
                    DFS(src);

                    if(hasCycle) {
                        foundCycle = true;
                        DFS(startCycle);
                        path = getPath(startCycle, endCycle);
                        path = path + " -> " + (endCycle+1);
                    }
                    break;
                }
            }

        }
        return path;
    }

    public String getPath(int src, int dest) {
        String path = "";
        DFS(src);

        if(color[dest] != WHITE) { // if these nodes are on the same components
            int current = dest;
            path = ""+dest;
            while(current != src) {
                current = previous[current];
                path = current + " -> " + path;
            }
        }
        return path;
    }

}
