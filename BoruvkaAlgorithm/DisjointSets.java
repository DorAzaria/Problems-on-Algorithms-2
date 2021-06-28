package BoruvkaAlgorithm;
import java.util.Arrays;


public class DisjointSets {
private int[] parent, rank;
	
	public DisjointSets(int n) {
		parent = new int[n];
		rank = new int[n];
	}
	
	public void makeSet(int k) {
		parent[k] = k;
		rank[k] = 0;
	}
	
	public int find(int v) {
		int p = parent[v];
		if(v == p) {
			return v;
		}
		return parent[v] = find(parent[p]);
	}
	
	public boolean union(int v, int u) {
		int root_v = find(v);
		int root_u = find(u);
		if(root_v != root_u) {
			if(rank[root_v] > rank[root_u]) {
				parent[root_u] = root_v;
			}
			else if(rank[root_v] < rank[root_u]) {
				parent[root_v] = root_u;
			}
			else {
				parent[root_v] = root_u;
				rank[root_u]++;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(parent) + "\n" + Arrays.toString(rank);
	}
}
