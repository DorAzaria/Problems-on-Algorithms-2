# Prim Algorithm

### Algorithm

```java

Prim(G,root):
	create Tree T ⇐ ∅
	create PriorityQueue Q // Min-PriorityQueue key by key[v]
	create key[|V(G)|]
	create visited[|V(G)|]
	create parent[|V(G)|]
	numEdges ⇐ 0

	for each v∈V(G) do: // O(|V|)
		key[v] ⇐ ∞
		visited[v] ⇐ FALSE 
		parent[v] ⇐ NIL
	end-for

	key[root] ⇐ 0
	
	Q ⇐ V(G) // fill (v,key[v])
	
	while (Q is not empty) and (numEdges < |V(G)| - 1) do:
		
		u ⇐ extractMin(Q)
		
		for each v∈Adj(u) do:
			
			if visited[v] = FALSE and key[v] > weight(v,u) then:
				key[v] ⇐ weight(v,u)
				parent[v] ⇐ u
				decreaseKey(Q, v, weight(v,u) )
			end-if 
		end-for
	
		visited[u] ⇐ TRUE
		x ⇐ getMin(Q)
		T.add(parent[x], x)
		numEdges ⇐ numEdges + 1

	end-while
	
	return T

end-Prim


```
