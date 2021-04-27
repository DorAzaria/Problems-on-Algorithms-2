package Dijkstra;

public class Test {

    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm(7);
        graph.addEdge(0,1,3);
        graph.addEdge(0,2,2);
        graph.addEdge(1,2,2);
        graph.addEdge(1,3,1);
        graph.addEdge(2,3,3);
        graph.addEdge(2,4,5);
        graph.addEdge(1,5,4);
        graph.addEdge(5,6,1);
        graph.addEdge(3,6,2);
        graph.addEdge(2,6,6);
        graph.addEdge(4,6,2);

        int source = 0;
        int[] dist = graph.Dijkstra(source);

        System.out.println("The shorted path from node :");
        for (int i = 0; i < dist.length; i++)
            System.out.println(source + " to " + i + " is " + dist[i]);
    }
}
