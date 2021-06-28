# Isomorphic Trees

This is my implementation, if there are any mistakes here it is **your responsibility**!

### Algorithm
Works only if we know the root of each tree
```java
isIsomorphic(T1, root1, T2, root2):
    code1 ⇐ generateCode(T1, root1)
    code2 ⇐ generateCode(T2, root2)

    if code1 = code2 then:
        return true
    else:
        return false
end-isIsomorphic

generateCode(T, root):
    create traversalCode[|V(T)|]
    create color[|V(T)|]
    for i⇐ 0 to |V(T)| do:
        traversalCode[i] ⇐ “0”
        color[i] ⇐ WHITE
    end-for
    getTraversalCode(T, root1, traversalCode, color)
    return sortCodes(traversalCode)
end-generateCode

getTraversalCode(T, current, tCode[|V(T)|], color[|V(T)|]):

    color[current] ⇐ BLACK

    if deg(current) = 1 then:
        tCode[current] ⇐ “01”
    else:
        for each v ∈ Adj(current) do:
            if color[v] = WHITE then:
                color[current] ⇐ GRAY
                getTraversalCode(T, v, tCode, color)
                tCode[current] ⇐ tCode[current] + tCode[v]
            end-if
        end-for

        tCode[current] ⇐ tCode[current] + 1
    end-if-else
end-getTraversalCode

sortCodes(tCode[|V(T)|]):
    Sort(tCode)
    sortedCode ⇐ “”
    current ⇐ 1
    while current < |V(T)| and tCode[current] ≠ “01” do:
        sortedCode ⇐ sortedCode + tCode[current]
        current ⇐ current + 1
    end-while

    return sortedCode
end-sortCodes

```

### Algorithm (with no given root) Using Fire Algorithm
```java
isIsomorphicWithoutRoot(T1, T2):
	
	centerT1 ⇐ Fire(T1)
	centerT2 ⇐ Fire(T2)
	
	return isIsomorphic(T1, centerT1, T2, centerT2) // (from the previous algorithm)

end-isIsomorphicWithoutRoot


Fire(T):
        create Queue Q ⇐ ∅
        create deg[|V(T)|]

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
                                if deg[v]=1 then:
                                        Enqueue(Q,v)
                                end-if 
                        end-for
                end-for 
        end-while 
	
	centerNode ⇐ Dequeue(Q)

        return centerNode

end-Fire

```
