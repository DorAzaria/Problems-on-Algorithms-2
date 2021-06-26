# Maximum Submatrix 

### Simple Best (O^4)
```java
maxSubMatrixBest(mat[N][M]):
  sum ⇐ 0
  ii ⇐ 0
  jj ⇐ 0
  kk ⇐ 0
  ll ⇐ 0

  for i⇐ 0 to N do:
    for j⇐ i to N do:
      create arr[M]
      for k⇐ i to j do:
        for l⇐ 0 to M do:
          arr[l] ⇐ arr[l]+mat[k,l]
        end-for
      end-for

      create best[3] ⇐ bestLinear(arr)

      if best[0] > sum then:
        sum ⇐ best[0]
        ii ⇐ i
        jj ⇐ best[1]
        kk ⇐ j
        ll ⇐ best[2]
      end-if
    end-for
  end-for

return {sum, ii, jj, kk, ll}
```

### Super Best (O^3)

```java
superBest(mat[N,M]):
  create preSum[N,M+1]
  for i⇐ 0 to N do:
    for j⇐ 0 to M do:
      preSum[i,j+1] ⇐ preSum[i,j] + mat[i,j]
    end-for
  end-for

  sum ⇐ 0
  ii ⇐ 0
  jj ⇐ 0
  kk ⇐ 0
  ll ⇐ 0

  for i⇐ 0 to M do:
    for j⇐ i to M do:
      create arr[N]
      for k⇐ 0 to N do:
        arr[k] ⇐ preSum[k,j+1]-preSum[k,i] 
      end-for

      create best[3] ⇐ bestLinear(arr)
      if best[0] > sum then:
        sum ⇐ best[0]
        ii ⇐ best[1]
        jj ⇐ i
        kk ⇐ best[2]
        ll ⇐ j
      end-if
    end-for
  end-for 

return {sum, ii, jj, kk, ll}
```
