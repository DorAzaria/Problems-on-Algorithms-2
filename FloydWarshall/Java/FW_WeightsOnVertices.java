package FloydWarshall.Java;

public class FW_WeightsOnVertices {
    public static final int inf = 99999999;
    private int[][] graph;
    private int[][] fwMat;
    private String[][] paths;
    private int n;
    private int[] weight;

    public FW_WeightsOnVertices(int[][] graph, int[] weight) {
        this.weight = weight;
        n = graph.length;
        this.graph = new int[n][n];
        this.fwMat = new int[n][n];
        this.paths = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.graph[i][j] = graph[i][j];
                if(graph[i][j] != inf && i != j) {
                    this.fwMat[i][j] = (weight[i] + weight[j]);
                }
                if(this.fwMat[i][j] != inf) {
                    paths[i][j] = "->" + j;
                }
                if(i == j) {
                    this.fwMat[i][j] = 0;
                }
            }
        }
        floydWarshall();
        fixMatrix();
    }

    private void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(fwMat[i][j] > fwMat[i][k] + fwMat[k][j]) {
                        fwMat[i][j] = fwMat[i][k] + fwMat[k][j];
                        paths[i][j] = paths[i][k] + paths[k][j];
                    }
                }
            }
        }
    }

    public void fixMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j)
                fwMat[i][j] = (fwMat[i][j] + weight[i] + weight[j])/2;
            }
        }
    }

    public double getPathWeight(int source, int dest) {
        return fwMat[source][dest];
    }

    public String getPath(int source, int dest) {
        return source + paths[source][dest];
    }

    public void printMatrix(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(fwMat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] L = {4,3,2,5};
        int[][] mat = {
                {0,1,inf,1},
                {1,0,1,inf},
                {inf,1,0,1},
                {1,inf,1,0}
            };
        FW_WeightsOnVertices fw = new FW_WeightsOnVertices(mat,L);
        fw.printMatrix();

        System.out.println(fw.getPathWeight(0,2));
    }
}
