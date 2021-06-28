# Reversed Kruskal

### Algorithm

```java
ReverseKruskal(G): // O(|E|*(|V|+|E|))

  // sort E in descending order by edges weight (high to low).
    Sort(E(G)) // O(|E|log|E|)

    create Queue Q ⇐ ∅

  for each edge∈E(G) do: // O(|V|)
      Enqueue(edge)
  end-for

    size ⇐ |E(G)|

  while size > |V| - 1 do:
      edge ⇐ Dequeue(Q)

      if isBridge(G,edge) = false then:
            Remove(G,edge)
            size ⇐ size - 1
      end-if
  end-while

    return G
end-ReverseKruskal

isBridge(G,edge): // O(|V|+|E|)
    G’ ⇐ G-{edge}

    if NumberOfConnectedComponents(G’) = 2 then:
        return true
    else:
        return false
end-isBridge

NumberOfConnectedComponents(G’): // O(|V|+|E|)
    counter ⇐ 0
    create color[|V(G’)|]


  for each v∈V(G’) do: // O(|V|)
      color[v] ⇐ WHITE
  end-for

  for each v∈V(G’) do: // O(|V|)
      if color[v] = WHITE then:
          counter ⇐ counter + 1
          DFS_REC(G,v,color)
      end-if
  end-for

  return counter

end-NumberOfConnectedComponents

DFS_REC(G’,v, color[|V(G’)|): // O(|E| of this component)
    color[v] ⇐ GRAY 

    for each u∈Adj(v) do:
        if color[u] = WHITE then:
            DFS_REC(G’,u,color)
        end-if
    end-for

    color[v] ⇐ BLACK

end-DFS_REC

```
