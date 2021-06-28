# Kruskal Algorithm

### Algorithm
```java
Kruskal(G): // O(|E|log|V|)
    create Tree T ⇐ ∅

    for each v∈V(G) do: // O(|V|)
        MakeSet(v)
    end-for

    // sort E in increasing order by edges weight
    Sort(E(G)) // O(|E|log|E|)

    for each e∈E(G) do: // O(|E|log|V|)
        if FindSet(e.u) ≠ FindSet(e.v) then:
            T.add(e)
            Union(e.u, e.v) 
        end-if
		if |T| = |V|-1 then:
			return T
		end-if
	end-for
	return T
end-Kruskal

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

![](https://3.bp.blogspot.com/-TRj5U6eEEPE/Uy3CnZlhUHI/AAAAAAAACPU/PDUEwR1ugJ4/s1600/Animation+of+Kruskal's+Algorithm.gif)
