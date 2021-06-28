# Bottle Problem

### Algorithm

```java
bottleProblem(b1, b2):
  size ← (b1+1)*(b2+1)
  create mat[size,size]
  max ← max(b1,b2)

  for i ← 0 to b1 do:
     for j ← 0 to b2 do:
        node ←  getNode(max,i,j)

        mat[node,getNode(max,i,0)] ← 1
        mat[node,getNode(max,0,j)] ← 1

        mat[node,getNode(max,b1,j)] ← 1
        mat[node,getNode(max,i,b2)] ← 1

        mat[node,getNode(max , i+j - min(i+j,b2) , min(i+j,b2))] ← 1
        mat[node,getNode(max , min(i+j,b1) , i+j - min(i+j,b1))] ← 1
      end-for
  end-for

  for i ← 0 to size do:
     mat[i,i] ← 0
     end-for 

end-bottleProblem()

getNode(max, i, j):
  return (max+1)*i + j
end-getNode()

```
