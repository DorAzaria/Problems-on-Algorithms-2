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

### Check Connectivity

```java
checkConnectivity(G):
    create color[|V(G)|]
    color ⇐ BFS(G,0)

    for i⇐ 0 in |V(G)| do:
        if color[v] is not BLACK then:
            return false
        end-if
    end-for

    return true
end-checkConnectivity
```

### Get number of components
```java
NumberOfComponents(G):
    nextSource ⇐ 0
    counter ⇐ 0
    create HashSet S

    while S size ≠ |V(G)| do:
        counter ⇐ counter + 1
        create dist[|V(G)|] ⇐ BFS(G, nextSource)

        for i⇐ 0 to |V(G)| do:
            if dist[i] ≠ ∞ then:
                Add(S, i)
            else:
                nextSource⇐ i
            end-if-else
        end-for
    end-while

    return counter
end-NumberOfComponents
```

### Bipartite Graphs using BFS
```java
BFS_BIPARTITE(G,s):
    bipartite ⇐ true
    create color[|V(G)|]
    create dist[|V(G)|]
    create prev[|V(G)|]
    create partition[|V(G)|]
    create Queue Q ⇐ empty

    for each v∈V[G] do:
        dist[v] ⇐ ∞
        prev[v] ⇐ NIL
        color[v] ⇐ WHITE
        partition[v] ⇐ 0
    end-for

    color[s] ⇐ GRAY
    dist[s] ⇐ 0
    partition[s] ⇐ 1
    Enqueue(Q,s)

    while (Q is not empty) and (bipartite) do:
        u ⇐ Dequeue(Q)
        for each v∈Adj[u] and bipartite do:
            if partition[u] = partition[v] then:
                bipartite ⇐ false
            else if color[v] = WHITE then:
                color[v] ⇐ GRAY
                dist[v] ⇐ dist[u] + 1
                prev[v] ⇐ u
                Enqueue(Q,v)
                partition[v] ⇐ 3 - partition[u]
            end-if
        end-for
        color[u] ⇐ BLACK
    end-while

    return bipartite

end-BFS_BIPARTITE

```
