# Dijkstra

### Algorithm

```java
Dijkstra(G, src):
  create PriorityQueue Q ⇐ ∅
  create dist[|V[G]|]
  create prev[|V[G]|]
  create visited[|V[G]|]

  for each v∈V[G] do:
      dist[v] ⇐ ∞
      prev[v] ⇐ NIL
      visited[v] ⇐ false
  end-for

  dist[src] ⇐ 0
  Enqueue(Q, src)

  while Q is not empty do:
      u ⇐ Dequeue(Q)
      for each v∈Adj[u] do:
          if not visited[v] then:
              if dist[v] > dist[u] + weight(v,u) then:
                  dist[v] ⇐  dist[u] + weight(v,u)
                  prev[v] ⇐ u
                  Enqueue(Q, v)
              end-if
          end-if
      end-for
      visited[u] ⇐ true
  end-while
end-Dijkstra

```

### Bidirectional Dijkstra

```java
BidirectionalDijkstra(G,RG,src,dest):
    create PriorityQueue Q
    create PriorityQueue RQ
    create dist[|V(G)|]
    create rdist[|V(G)|]
    create prev[|V(G)|]
    create rprev[|V(G)|]
    create visited[|V(G)|]
    create rvisited[|V(G)|]

    for each v∈V[G] do:
    dist[v] ⇐ ∞
    rdist[v] ⇐ ∞
    prev[v] ⇐ NIL
    rprev[v] ⇐ NIL
    visited[v] ⇐ false
    rvisited[v] ⇐ false
    end-for

    dist[src] ⇐ 0
    rdist[dest] ⇐ 0
    Enqueue(Q,src)
    Enqueue(RQ,dest)

    while Q is not empty and RQ is not empty do:

          u ⇐ Dequeue(Q)
          for each v∈Adj[u] do:
              if not visited[v] then:
                    if dist[v] > dist[u] + weight(u,v) then:
                          dist[v] ⇐ dist[u] + weight(u,v)
                          prev[v] ⇐ u
                          Enqueue(Q,v)
                    end-if
              end-if
          end-for

          visited[u] ⇐ true

          ru ⇐ Dequeue(RQ)
          for each v∈Adj[ru] do:
              if not rvisited[v] then:
                  if rdist[v] > rdist[ru] + weight(ru,v) then:
                    rdist[v] ⇐ rdist[ru] + weight(ru,v)
                    rprev[v] ⇐ ru
                    Enqueue(RQ,v)
                  end-if
              end-if
          end-for

          rvisited[ru] ⇐ true

          if visited[ru] and rvisited[ru] then:
            break
          end-if

    end-while

    minDist ⇐ ∞
    for each v∈V[G] do:
          if (visited[v] or rvisited[v]) 
            and (dist[v] ≠ ∞ and rdist[v] ≠ ∞)
            and (minDist > dist[v]+rdist[v])
            then:
                minDist⇐ dist[v]+rdist[v]
        end-if
    end-for

    return minDist

end-BidirectionalDijkstra

```
