# Boruvka Algorithm

### Algorithm

```java
Boruvka(G)

	for each v∈V(G) do: // O(|V|)
		MakeSet(v)
	end-for

	create Tree T ⇐ ∅
	treeSize ⇐ 0

	while treeSize < |V(G)|-1 do:
		create Edge[|V(G)|] cheapest // init NULL

		for each edge∈E(G) do:
			root1 ⇐ FindSet(edge.v1)
			root2 ⇐ FindSet(edge.v2)

			if root1 ≠ root2 then:

				if cheapest[root1] = NULL OR 
				OR edge.weight < cheapest[root1].weight then:

						cheapest[root1] ⇐ edge
				end-if

				if cheapest[root2] = NULL OR 
				OR edge.weight < cheapest[root2].weight then:

					cheapest[root2] ⇐ edge
				end-if
			end-if
		end-for

		for each v∈V(G) do:
			if cheapest[v] ≠ NULL then:
				v1 ⇐ cheapest[v].v1()
				v2 ⇐ cheapest[v].v2()

				if FindSet(v1) ≠ FindSet(v2) then:
					treeSize ⇐ treeSize + 1
					edge ⇐ new Edge(v1, v2, cheapest[v].weight)
					T.add(edge)
					Union(v1,v2)
				end-if
			end-if
		end-for
	end-while

	return T
end-Boruvka

MakeSet(v): // O(1)
	v.parent ⇐ v
end-MakeSet

FindSet(v): // O(log|V|)
	if v = v.parent then:
		return v.parent
	else:
		return FindSet(v.parent)
	end-if
end-FindSet

Union(u,v): // O(log|V|)
	uRoot ⇐ FindSet(u)
	vRoot ⇐ FindSet(v)

	uRoot.parent ⇐ vRoot
end-Union

```
