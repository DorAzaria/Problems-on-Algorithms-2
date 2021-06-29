# Reversed Kruskal

### Algorithm

```java
ReverseKruskal(G): // O(|E|*(|V|+|E|))

    // sort E in descending order by edges weight (high to low).
    Sort(E(G)) // O(|E|log|E|)

    create Queue Q ⇐ ∅
    create Tree T ⇐ ∅

    for each edge∈E(G) do: // O(|V|)
        Enqueue(Q,edge)
        T.add(edge)
    end-for

    size ⇐ |E(T)|

    while size > |V(T)| - 1 do:
        edge ⇐ Dequeue(Q)

        if isBridge(T,edge) = false then:
            Remove(T,edge)
            size ⇐ size - 1
        end-if
    end-while

    return T
end-ReverseKruskal

isBridge(T,edge): // O(|V|+|E|)
    T’ ⇐ T-{edge}

    if NumberOfConnectedComponents(T’) = 2 then:
        return true
    else:
        return false
end-isBridge

NumberOfConnectedComponents(T’): // O(|V|+|E|)
    counter ⇐ 0
    create color[|V(T’)|]

    for each v∈V(T’) do: // O(|V|)
        color[v] ⇐ WHITE
    end-for

    for each v∈V(T’) do: // O(|V|)
        if color[v] = WHITE then:
            counter ⇐ counter + 1
            DFS_REC(T’,v,color)
        end-if
    end-for
    return counter

end-NumberOfConnectedComponents

DFS_REC(T’,v, color[|V(T’)|): // O(|E| of this component)
    color[v] ⇐ GRAY 

    for each u∈Adj(v) do:
        if color[u] = WHITE then:
            DFS_REC(T’,u,color)
        end-if
    end-for

    color[v] ⇐ BLACK

end-DFS_REC

```
