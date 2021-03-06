package DFS;

public class DFSAlgorithm {

    final static int WHITE = -1, GRAY = 0, BLACK = 1;
    final static int inf = 1000000;
    int[][] matrix;
    int number_of_nodes, time;
    int[] color, previous, first, last;

    public DFSAlgorithm(int[][] mat) {
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
        DFS_Visit(source);
    }

    private void DFS_Visit(int current) {
        color[current] = GRAY;
        first[current] = ++time;

        for(int i = 0 ; i < number_of_nodes; i++) {
            if(i != current && matrix[current][i] != inf) { // if it's a neighbour

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
