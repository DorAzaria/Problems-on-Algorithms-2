# BFS

### Algorithm

```java
BFS(G,src):
    create Queue Q
    create dist[|V(G)|]
    create prev[|V(G)|]
    create color[|V(G)|]

    for each v∈V[G] do:
        dist[v] ⇐ ∞
        prev[v] ⇐ NIL
        color[v] ⇐ WHITE
    end-for

    dist[src] ⇐ 0
    color[src] ⇐ GRAY
    Enqueue(Q,src)

    while Q is not empty do:
        u ⇐ Dequeue(Q)
        for each v∈Adj[u] do:
            if color[v] = WHITE then:
                color[v] ⇐ GRAY
                dist[v] ⇐ dist[u] + 1
                prev[v] ⇐ u
                Enqueue(Q,v)
            end-if
        end-for
        color[u] ⇐ BLACK
    end-while 
    return (dist, prev)

end-BFS

```
