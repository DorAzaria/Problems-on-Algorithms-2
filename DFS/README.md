# DFS Algorithm

### Algorithm

```java
DFS(G):
    time ⇐ 0

    for each v∈V(G) do:
        color[v] ⇐ WHITE
        prev[v] ⇐ NIL
        dist[v] ⇐ ∞
    end-for

    for each v∈V(G) do:
        if color[v] = WHITE then:
            DFS_REC(G,v)
        end-if
    end-for 
end-DFS

DFS_REC(G,v):
    color[v] ⇐ GRAY
    time ⇐ time + 1
    dist[v] ⇐ time 
    for each u∈Adj(v) do:
        if color[u] = WHITE then:
            prev[u] ⇐ v
            DFS_REC(G,u)
        end-if 
    end-for 
    color[v] ⇐ BLACK
end-DFS_REC
```

### Check if there's a circle in the graph (for directional and undirectional graphs)
(not mine, not learned).
```java
HasCircle(G)
    ans ⇐  false
    for each u ∈ V[G] do:
        color[u] ⇐  WHITE
        prev[u] ⇐  NIL
    end-for 

    for each u ∈ V[G] and ans=false do:
        if color[u] = WHITE then:
            ans ⇐ DFSVisit(G,u)
        end-if
    end-for 

    return ans;
end- HasCircle
 
DFSVisit(G,u)
    ans ⇐ false
    color[u] ⇐ GRAY
    for each v ∈ Adj(u) and ans=false do:
        if color[v] = GRAY and prev[u]≠v then:
            ans ⇐ true
            getCycle(G, u, v)
        else if color[v] = WHITE then:
            prev[v] ⇐ u
            ans ⇐ DFSVisit(G,v)
        end-if
    end-for 
    color[u] ⇐ BLACK
    return ans
end-DFSVisit
 
GetCycle(G, u, v)
    create Stack cycle
    x ⇐ u
    while x ≠ v do:
        Push(cycle, x)
        x ⇐ prev[x]
    end-while
    Push(cycle , v)
    Push(cycle, u)
    Reverse(cycle)
end-GetCycle
```
