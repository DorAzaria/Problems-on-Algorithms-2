# Gas Station Problem

### Algorithm

```java
gasStationProblem(nodes[N], edges[N]):
  sum ⇐ 0
  create combine[N]

  for i⇐ 0 to N do:
    combine[i] ⇐ nodes[i]+edges[i]
    sum ⇐ sum + combine[i]
  end-for

  if sum < 0 then:
    return empty-array
  end-if

return bestCycle(combine)
```
