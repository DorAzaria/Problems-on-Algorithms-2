package FloydWarshall.Java;

import java.util.Arrays;

public class FW_NegativeCycles {
    final static int INF = 999999;
    int[][] graph;

    public FW_NegativeCycles(int[][] mGraph) {
        this.graph = mGraph;
    }

    public void FloydWarshall() {

        for(int k = 0 ; k < graph.length; k++) {
            for(int i = 0 ; i < graph.length; i++) {
                for(int j = 0 ; j < graph.length; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        printMatrix();
    }

    public boolean checkNegativeCycle() { // O(N)
        for(int i = 0 ; i < graph.length; i++) {
            if(graph[i][i] < 0)
                return true;
        }
        return false;
    }

    public void printMatrix() {
        System.out.println(Arrays.deepToString(graph)
                .replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "));
    }

    public boolean checkUndirectedNegativeCycle() { // O(N^2)
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph.length; j++) {
                if(graph[i][j] < 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // UNDIRECTED
        int[][] graph1 = {
                {INF,4  ,-20},
                {4  ,INF,8  },
                {-20,8  ,INF}
        };

        // DIRECTED
        int[][] graph2 = {
                {INF,4  ,-10},
                {INF  ,INF,2  },
                {INF,INF  ,INF}
        };

        // DIRECTED
        int[][] graph3 = {
                {INF,4  ,-10},
                {INF  ,INF,2  },
                {-10,INF  ,INF}
        };

        // DIRECTED
        int[][] graph4 = {
                {0  ,1  ,INF,INF},
                {INF,0  ,-5 ,INF},
                {2  ,INF,0  ,1  },
                {1  ,INF,1  ,0  }
        };

        System.out.println("UNDIRECTED");
        FW_NegativeCycles fw = new FW_NegativeCycles(graph1);
        fw.FloydWarshall();
        System.out.println("Check for a negative cycle: "+fw.checkUndirectedNegativeCycle());
        System.out.println("\nDIRECTED");
        fw = new FW_NegativeCycles(graph2);
        fw.FloydWarshall();
        System.out.println("Check for a negative cycle: "+fw.checkNegativeCycle());
        System.out.println("\nDIRECTED");
        fw = new FW_NegativeCycles(graph4);
        fw.FloydWarshall();
        System.out.println("Check for a negative cycle: "+fw.checkNegativeCycle());
    }
}
