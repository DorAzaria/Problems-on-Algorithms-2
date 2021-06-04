package KruskalAlgorithm;

import java.util.Arrays;

public class Kruskal {

    private Edge[] graph, tree;
    private DisjointSets group;
    private int node_size, tree_size;

    public Kruskal(Edge[] g) {
        this.graph = new Edge[g.length];

        for(int i = 0; i < g.length; i++) {
            graph[i] = new Edge(g[i].v, g[i].u, g[i].weight);
        }

        node_size = 0;
        tree_size = 0;

        for(Edge edge : graph) {
            if(edge.v > node_size) node_size = edge.v;
            if(edge.u > node_size) node_size = edge.u;
        }
        node_size++;

        group = new DisjointSets(node_size);
        tree = new Edge[node_size-1];

        for (int i = 0; i < node_size; i++) {
            group.make_set(i);
        }

        findMTS();
    }

    private void findMTS() {
        Arrays.sort(graph); // O(|E|log|E|)
        for(Edge edge : graph) {
            if(tree_size < node_size-1) {
                if(group.union(edge.v, edge.u)) {
                    tree[tree_size++] = edge;
                }
            }
            else {
                break;
            }
        }
    }

    public Edge[] getTree() {
        return this.tree;
    }

    /***************************************************
     * DisjointSets CLASS! *************************************
     */
    public static class DisjointSets {
        private int[] parent, rank; //rank[k]>=height of tree number k

        public DisjointSets(int length) {
            parent = new int[length];
            rank = new int[length];
        }

        public void make_set(int k) {
            parent[k] = k;
            rank[k] = 0;
        }

        public boolean union(int v, int u) {
            int root_v = find(v);
            int root_u = find(u);

            if(root_v == root_u) {  // if its equals = there is a circle.
                return false;
            }
            else {
                if (rank[root_u] > rank[root_v]) {
                    parent[root_v] = root_u;
                } else if (rank[root_v] > rank[root_u]) {
                    parent[root_u] = root_v;
                } else {
                    parent[root_v] = root_u;
                    rank[root_u]++;
                }
                return true;
            }
        }

        public int find(int v) {
            if(parent[v] != v) {
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }
    }

    /***************************************************
     * EDGE CLASS! *************************************
     */
    public static class Edge implements Comparable<Edge> {
        int v, u, weight;
        public Edge(int v, int u, int weight) {
            this.v = v;
            this.u = u;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" +
                    "v=" + v +
                    ", u=" + u +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
}
