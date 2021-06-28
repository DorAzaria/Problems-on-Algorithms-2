package Dijkstra.PriorityQueueImplementation;

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

        graph.Dijkstra(0, 6);
        
        System.out.println("==================================");
        graph = new DijkstraAlgorithm(7);
        graph.addEdge(0,1,2);
        graph.addEdge(1,2,2);
        graph.addEdge(1,3,5);
        graph.addEdge(3,5,5);
        graph.addEdge(3,4,7);
        graph.addEdge(4,6,2);

        graph.Dijkstra(0, 6);

        Directed dgraph = new Directed(6);
        dgraph.addEdge(0,2,3);
        dgraph.addEdge(1,0,1);
        dgraph.addEdge(1,2,2);
        dgraph.addEdge(1,3,4);
        dgraph.addEdge(2,4,2);
        dgraph.addEdge(2,3,5);
        dgraph.addEdge(3,5,4);
        dgraph.addEdge(4,5,4);
        dgraph.Dijkstra(0);
    }
}
