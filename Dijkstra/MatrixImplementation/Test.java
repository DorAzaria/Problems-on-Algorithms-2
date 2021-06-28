package Dijkstra.MatrixImplementation;

public class Test {
    static int inf = 1000000;

    public static void main(String[] args) {
        DijkstraMatrix dijkstraMatrix = new DijkstraMatrix();

        int[][] matrix = {{0 ,1 ,2 , inf, inf, inf, inf, inf},
                        {1 ,0 ,4 , inf,5 , inf, inf, inf},
                        {2 ,4 ,0 ,7 , inf,3 , inf, inf},
                        {inf, inf,7 ,0 ,3 ,8 , inf, inf},
                        {inf,5 , inf,3 ,0 , inf,1 ,4 },
                        {inf, inf,3 ,8 , inf,0 ,2 , inf},
                        {inf, inf, inf, inf,1 ,2 ,0 ,5 },
                        {inf, inf, inf, inf,4 , inf,5 ,0 }};
        dijkstraMatrix.Dijkstra(matrix,0,7); // 10

        matrix = new int[][] {{0,2, inf, inf, inf, inf, inf},
                           {2, 0, 2, 5, inf, inf, inf},
                           {inf,2,0, inf, inf, inf, inf},
                           {inf, 5, inf, 0, 7, 5, inf},
                           {inf, inf, inf, 7, 0, inf,2},
                           {inf, inf, inf,5, inf,0, inf},
                           {inf, inf, inf, inf,2, inf,0}
                        };
        dijkstraMatrix.Dijkstra(matrix,0,6); // 16

    }
}
