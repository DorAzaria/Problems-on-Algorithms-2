# Kruskal Algorithm

### Algorithm
```java
Kruskal(G): // O(|E|log|V|)
    create Tree T ⇐ ∅

    for each v∈V(G) do: // O(|V|)
        MakeSet(v)
    end-for

    // sort E in increasing order by edges weight
    Sort(E(G)) // O(|E|log|V|)

    for each e∈E(G) do: // O(|E|)
        if FindSet(e.u) ≠ FindSet(e.v) then:
            T.add(e)
            Union(e.u, e.v) 
        end-if
        if |E(T)| = |V(T)|-1 then:
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

### Return the sum of weights of all the MST
```java
SumOfMST(G):
    sum ⇐ 0
    T ⇐ Kruskal(G)

    for each e∈E(T) do: 
        sum ⇐ sum + e.weight
    end-for

    return sum
end-SumOfMST

```

### Maximum Spanning Tree
```java
MaximumSpanningTreeSum(G)

    for each e∈E(G) do:
        e.weight ⇐ (-1)*(e.weight)
    end-for

    T ⇐ Kruskal(G)
    sum ⇐ 0

    for each e∈E(T) do:
        e.weight ⇐ (-1)*(e.weight)
        sum ⇐ sum + e.weight
    end-for

    return sum
end-MaximumSpanningTreeSum

```

![](https://3.bp.blogspot.com/-TRj5U6eEEPE/Uy3CnZlhUHI/AAAAAAAACPU/PDUEwR1ugJ4/s1600/Animation+of+Kruskal's+Algorithm.gif)
