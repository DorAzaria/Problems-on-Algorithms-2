# Bottle Problem

### Algorithm

```java
bottleProblem(b1, b2):
  size ← (b1+1)*(b2+1)
  create mat[size,size]
  
  for i ← 0 to b1 do:
     for j ← 0 to b2 do:
        node ←  getNode(b2,i,j)

        mat[node,getNode(b2,i,0)] ← 1
        mat[node,getNode(b2,0,j)] ← 1

        mat[node,getNode(b2,b1,j)] ← 1
        mat[node,getNode(b2,i,b2)] ← 1

        mat[node,getNode(b2 , i+j - min(i+j,b2) , min(i+j,b2))] ← 1
        mat[node,getNode(b2 , min(i+j,b1) , i+j - min(i+j,b1))] ← 1
      end-for
  end-for

  for i ← 0 to size do:
     mat[i,i] ← 0
     end-for 

end-bottleProblem()

getNode(b2, i, j):
  return (b2+1)*i + j
end-getNode()

```
