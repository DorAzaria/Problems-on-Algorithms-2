# Prim Algorithm

### Algorithm

```java
Prim(G): // O(|E|log|V|)
    create PriorityQueue Q
    create Tree T ⇐ ∅
    create visit[|V(G)|]
    create prev[|V(G)|]
    create minEdge[|V(G)|]

    for each v∈V(G) do: // O(|V|)
        visit[v] ⇐ false
        prev[v] ⇐ NIL
        minEdge[v] ⇐ ∞
    end-for

    minEdge[0] ⇐ 0
    Q.add((0,0)) // (node ID, priority)

    while Q is not empty do: // O(|E|log|V|)
        u ⇐ Q.extractMin()

        if prev[u] ≠ NULL then:
            T.add( (u, prev[u]) )
        end-if

        for each v∈Adj(u) do:
            if not visit[v] then:
                if minEdge[v] > weight(u,v) then:
                    minEdge[v] ⇐ weight(u,v)
                    prev[v] ⇐ u

                    if Q.contains(v) then:
                        Q.decreaseKey(v, minEdge[v])
                    else:
                        Q.add( (v, minEdge[v]) )
                    end-if
                end-if
            end-if
        end-for

        visit[u] ⇐ true
    end-while
    return T
end-Prim

```
