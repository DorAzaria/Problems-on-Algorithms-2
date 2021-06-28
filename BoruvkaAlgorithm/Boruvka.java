package BoruvkaAlgorithm;

/**
 * Boruvka's algorithm for MST
 * Complexity: O(|E|log|V|) - using disjointsets
 */
public class Boruvka {
	private Edge[] graph, sTree;
	private DisjointSets vgroup;
	private int n, treeSize;
	
	public Boruvka(Edge[] graph, int numOfVertices) {
		this.graph = copy(graph);
		n = numOfVertices;
		vgroup = new DisjointSets(n);
		for (int i = 0; i < n; i++) {
			vgroup.makeSet(i);
		}
		sTree = new Edge[n-1];
		makeMST();
	}

	private void makeMST() {
		while(treeSize < n-1) {
			Edge[] closest = new Edge[n];
			for(Edge e : graph) {
				int v1 = e.v1 , v2 = e.v2;
				int v1_root = vgroup.find(v1);
				int v2_root = vgroup.find(v2);
				if(v1_root != v2_root) {
					if(closest[v1_root] == null || e.weight < closest[v1_root].weight) {
						closest[v1_root] = e;
					}
					if(closest[v2_root] == null || e.weight < closest[v2_root].weight) {
						closest[v2_root] = e;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if(closest[i] != null) {
					int v1 = closest[i].v1;
					int v2 = closest[i].v2;
					if(vgroup.find(v1) != vgroup.find(v2)) {
						sTree[treeSize++] = new Edge(v1, v2, closest[i].weight);
						vgroup.union(v1, v2);
					}
				}
			}
		}
	}
	
	public Edge[] getTree() {
		return sTree;
	}
	
	private Edge[] copy(Edge[] g) {
		Edge[] temp = new Edge[g.length];
		for (int i = 0; i < g.length; i++) {
			temp[i] = new Edge(g[i].v1, g[i].v2, g[i].weight);
		}
		return temp;
	}

	public static class Edge implements Comparable<Boruvka.Edge> {
		int v1, v2, weight;
		public Edge(int v, int u, int weight) {
			this.v1 = v;
			this.v2 = u;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "{" +
					"v1=" + v1 +
					", v2=" + v2 +
					", weight=" + weight +
					'}';
		}

		@Override
		public int compareTo(Boruvka.Edge o) {
			return Integer.compare(this.weight,o.weight);
		}
	}
}
