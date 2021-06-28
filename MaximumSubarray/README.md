# Best Algorithm

### Linear Best

```java
bestLinear(arr[N]):
  sum ⇐ -∞
  temp_sum ⇐ 0
  start_index ⇐ 0
  temp_start ⇐ 0
  end_index ⇐ 0

  for i⇐ 0 to N do:
      temp_sum ⇐ temp_sum + arr[i]
        if temp_sum > sum then:
          sum ⇐ temp_sum
          end_index ⇐ i
          start_index ⇐ temp_start
        end-if 

    if temp_sum < 0 then:
      temp_start ⇐ i + 1
      temp_sum ⇐ 0
    end-if 
  end-for 

  create solution[3]
  solution[0] ⇐ sum
  solution[1] ⇐ start_index
  solution[2] ⇐ end_index

return solution
```

### Cycle Best

```java
bestCycle(arr[N]):
  create neg_arr[N]
  sum ⇐ 0

  for i⇐ 0 to N do:
    sum ⇐ sum + arr[i]
    neg_arr[i] ⇐ arr[i]*(-1)
  end-for

  create negative[3] ⇐ bestLinear(neg_arr)
  create regular[3] ⇐ bestLinear(arr)
  cycle_sum ⇐ sum - (-negative[0])

  if regular[0]  cycle_sum then:
    return regular
  end-if 

  create solution[3]
  solution[0] ⇐ cycle_sum
  solution[1] ⇐ (negative[2]+1) modulo N
  solution[2] ⇐ negative[1] - 1
return solution
```
