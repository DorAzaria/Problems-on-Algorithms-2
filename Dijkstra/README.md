# Dijkstra

### Algorithm

```java
Dijkstra(G, src):
  create PriorityQueue Q ⇐ ∅
  create dist[|V[G]|]
  create prev[|V[G]|]
  create visited[|V[G]|]

  for each v∈V[G] do:
      dist[v] ⇐ 
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
