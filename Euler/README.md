# Eulerian Graphs and Path

### Algorithm O(|V|+|E|)
  works for both cases (paths or cycles) and return a List contain the the path/cycle by order.
  
  ```java
getEuler(G):
    count ⇐  0
    pathNode ⇐  1
    cycleNode ⇐ 0

    for each v∈V(G) do:
        if deg(v) modulo 2 = 1 then:
            count ⇐ count + 1
            pathNode ⇐ v
        else:
            cycleNode ⇐ v
        end-if
    end-for

    if count > 2 then:
        print(“No path and no cycle”)
        return NULL
    end-if

    if isConnected(G,0) = TRUE then:
        if count = 2 then: // Eulerian Path
            return generateEuler(G,pathNode)
        end-if

        if count = 0 then:
            return generateEuler(G,cycleNode)
        end-if
    end-if

    return NULL
end-getEuler	

isConnected(G, src):
    create Queue Q ⇐ ∅
    create color[|V(G)|]

    for each v∈V(G) do:
        color[v] ⇐ WHITE
    end-for

    color[src] ⇐ GRAY
    Enqueue(Q,src)

    while Q is not empty do:
        u ⇐ Dequeue(Q)

        for each v∈Adj(u) do:

            if color[v] = WHITE then:
                color[v] ⇐ GRAY
                Enqueue(Q,v)
            end-if
        end-for

        color[u] ⇐ BLACK
    end-while


    for each v∈V(G) do:
        if color[i] ≠ BLACK then:
            return FALSE
        end-if
    end-for

    return TRUE
end-isConnected

generateEuler(G,src):
    create Stack stack ⇐ ∅
    create List path ⇐ ∅

    stack.push(src)

    while stack is not empty do:
        u ⇐ stack.top()
        if deg(u) = 0 then:
            stack.pop()
            path.add(u)
        else:
            v ⇐ {v|v∈Adj(u)} // get a neighbour
            stack.push(v)
            E(G) ⇐ E(G) - {u,v}
        end-if
    end-while

    return path

end-generateEuler

  ```
