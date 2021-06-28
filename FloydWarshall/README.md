
# Floyd Warshall

### Algorithm

```java
FloydWarshall(mat[N,N]):

	for k ⇐ 0 to N do:
	  for i ⇐ 0 to N do:
	    for j ⇐ 0 to N do:
	      if mat[i,j] > mat[i,k]+mat[k,j] then:
		mat[i,j] ⇐ mat[i,k] + mat[k,j]
	      end-if
	    end-for
	  end-for
	end-for
end-FloydWarshall
```

### Check if graph is connected

```java
IsGraphConnected(mat[N,N]):

	for k ⇐ 0 to N do:
	  for i ⇐ 0 to N do:
	    for j ⇐ 0 to N do:
	      if mat[i,j] > mat[i,k]+mat[k,j] then:
		mat[i,j] ⇐ mat[i,k] + mat[k,j]
	      end-if

	for i ⇐ 0 to N do:
	  if mat[0,i] = ∞ then:
	    return False
	  end-if

	return True
end-IsGraphConnected
```

### Number of components using Floyd Warshall
```java
getNumberOfComponents(mat[N,N]):


	for k ⇐ 0 to N do:
	  for i ⇐ 0 to N do:
	    for j ⇐ 0 to N do:
	      if mat[i,j] > mat[i,k]+mat[k,j] then:
		  mat[i,j] ⇐ mat[i,k] + mat[k,j]
	      end-if
	    end-for
	  end-for
	end-for

	create comp[N]
	counter ⇐ 0

	for i ⇐ 0 to N do:
	  	comp[i] ⇐ 0
	end-for


	for i ⇐ 0 to N do:
	  if comp[i] = 0 then: 
	    counter ⇐ counter + 1
	    comp[i] ⇐ counter
	    for j ⇐ 0 to N do:
	      if mat[i,j] != ∞ then:
		comp[j] ⇐ counter
	      end-if
	    end-for
	  end-if
	end-for

	return counter
end-getNumberOfComponents
```

### Check if 2 nodes are on the same path
```java
onSamePath(mat[N,N], src, dest):

	create comp[N] ⇐ getComponents(mat)

	if comp[src] = comp[dest] then:
	  	return True

	return False

end-onSamePath

getComponents(mat[N,N]):

	for k ⇐ 0 to N do:
	  for i ⇐ 0 to N do:
	    for j ⇐ 0 to N do:
	      if mat[i,j] > mat[i,k]+mat[k,j] then:
		mat[i,j] ⇐ mat[i,k] + mat[k,j]
	      end-if
	    end-for
	  end-for
	end-for

	create comp[N]
	counter ⇐ 0

	for i ⇐ 0 to N do:
	  	comp[i] ⇐ 0
	end-for


	for i ⇐ 0 to N do:
	  if comp[i] = 0 then: 
	    counter ⇐ counter + 1
	    comp[i] ⇐ counter
	    for j ⇐ 0 to N do:
	      if mat[i,j] != ∞ then:
		comp[j] ⇐ counter
	      end-if
	    end-for
	  end-if
	end-for

	return comp[]
end-getComponents
```

### Weights on the Vertices
```java
FWNodesWeights(mat[N,N], nodes[N]):
for i ⇐ 0 to N do:
  for j ⇐ 0 to N do:
    if i=j then:
      mat[i,j] ⇐ nodes[i] 
    else if mat[i,j] then:
      mat[i,j] ⇐  nodes[i]+nodes[j]
    end-if
  end-for
end-for

for k ⇐ 0 to N do:
	for i ⇐ 0 to N do:
		for j ⇐ 0 to N do then:
			mat[i,j] ⇐ min(mat[i,j] , mat[i,k]+mat[k,j])
		end-for
	end-for
end-for

for i ⇐ 0 to N do:
	for j ⇐ 0 to N do:
		if i≠j then:
			mat[i,j] ⇐ (nodes[i]+mat[i,j]+nodes[j])/2
		end-if 
	end-for
end-for

```

### Weights on the vertices and edges
```java
FWNodesEdgesWeights(mat[N,N], nodes[N]):
for i⇐0 to N do:
	for j⇐0 to N do:
      if i=j then:
        mat[i,j] ⇐ nodes[i]
      else-if mat[i,j] then:
        mat[i,j] ⇐ nodes[i] + 2*mat[i,j] + nodes[j]
      end-if
  end-for
end-for

for k⇐ 0 to N do:
    for i⇐ 0 to N do:
      for j⇐ 0 to N do:
	        mat[i,j] ⇐ min(mat[i,j], mat[i,k]+mat[k,j]
      end-for 
    end-for
end-for

for i⇐ 0 to N do:
	for j⇐ 0 to N do:
		if i≠j then:
			mat[i,j] ⇐ (nodes[i]+mat[i,j]+nodes[j])/2
		end-if
	end-for
end-for
```

### Check if there is a negative cycle on undirected graph
```java
FWCheckNegativeCycle(mat[N,N]):
for i⇐ 0 to N do:
	for j⇐ 0 to N do:
		if mat[i,j] < 0 then:
			return True
		end-if
return False
```

### Check if there is a negative cycle on directed graph
```java
FWCheckNegativeCycleDirected(mat[N,N]):

for k⇐ 0 to N do:
  for i⇐ 0 to N do:
    for j⇐ 0 to N do:
	    mat[i,j] ⇐ min(mat[i,j], mat[i,k]+mat[k,j])
    end-for 
  end-for
end-for

for i⇐ 0 to N do:
	if mat[i,i] < 0 then:
		return True
	end-if
end-for

return False
```
