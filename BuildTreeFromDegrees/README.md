# Build Tree From Degrees

### Algorithm
```java
GenerateTreeByDegrees(deg[N]):

    sum ⇐ 0

    for i ⇐ 0 to N do:
        sum ⇐ sum + deg[i]
    end-for

    if sum ≠ 2*(N - 1) then:
        print “not a tree”
        return empty-array
    end-if 

    Sort(deg) // O(N*logN)
    j ⇐ 0

    for i ⇐ 0 to N do:
        if deg[i] > 1 then:
            j ⇐ i
            break
        end-if
    end-for

    create tree[N]
    for i ⇐ 0 to N-2 do:
        tree[i] ⇐ j
        deg[j] ⇐ deg[j] - 1

        if deg[j] = 1 then:
            j ⇐ j + 1
        end-if 
    end-for

    tree[N-1] ⇐ N
    return tree

end-GenerateTreeByDegrees

```
