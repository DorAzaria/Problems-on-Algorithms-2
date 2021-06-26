# Diameter of a Graph

### Algorithm
```java
Diameter(G):
    maxValue⇐ 0
    maxIndex⇐ 0
    create dist[|V(G)|]
    dist ⇐ BFS(G,0)

    for i⇐ 0 to |V(G)| do:
        if dist[i] > maxValue then:
            maxValue ⇐ dist[i]
            maxIndex ⇐ i
        end-if
    end-for

    dist ⇐ BFS(G,maxIndex)
    diameter ⇐ 0

    for i⇐ 0 to |V(G)| do:
        if dist[i] > diameter then:
            diameter ⇐ dist[i]
        end-if
    end-for

    return diameter

end-Diameter

```
