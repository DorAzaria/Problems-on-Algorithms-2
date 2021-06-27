# Fire Algorithm

### Algorithm
```java
Fire(T):
    create Queue Q ⇐ ∅
    diameter ⇐ 0
    radius ⇐ 0
    centers ⇐ 0

    for each v∈V[T] do:
        if deg(v)=1 then:
            Enqueue(Q,v)
        end-if
    end-for

    nodes ⇐ |V[T]|
    while nodes > 2 do:
        radius ⇐ radius + 1
        leaves ⇐ |Q|
        for i⇐ 0 to leaves do:
            u ⇐ Dequeue(Q)
            v ⇐ {v|v∈Adj(u)}
            Remove(T,u)
            nodes ⇐ nodes - 1
            if deg(v)=1 then:
                Enqueue(Q,v)
            end-if 
        end-for
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
