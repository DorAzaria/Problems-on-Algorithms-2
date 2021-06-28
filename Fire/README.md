# Fire Algorithm

### Algorithm
```java
Fire(T):
        create Queue Q ⇐ ∅
        create deg[|V(T)|]
        diameter ⇐ 0
        radius ⇐ 0
        centers ⇐ 0

        for each v∈V(T) do:
                deg[v] ⇐ |Adj(v)|
                if deg[v]=1 then:
                        Enqueue(Q,v)
                end-if
        end-for

        nodes ⇐ |V[T]|
        while nodes > 2 do:
                leaves ⇐ |Q|
                for i⇐ 0 to leaves do:
                        u ⇐ Dequeue(Q)
                        nodes ⇐ nodes - 1
                        for each v∈Adj(u) do:
                                if deg(v)=1 then:
                                        Enqueue(Q,v)
                                end-if 
                        end-for
                end-for 
                radius ⇐ radius + 1
        end-while 

        centers ⇐ nodes
        if nodes = 2 then:
                diameter ⇐ radius * 2 + 1
                radius ⇐ radius + 1
        else:
                diameter ⇐ radius * 2
        end-if 

        return diameter,radius,centers

end-Fire
```
