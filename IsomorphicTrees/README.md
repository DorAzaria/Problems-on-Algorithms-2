# Isomorphic Trees (AHU Algorithm)

This is my implementation, if there are any mistakes here it is **your responsibility**!

### Algorithm for rooted Tree
Works only if we know the root of each tree
```java
isIsomorphic(T1, r1, T2, r2):

	if |V1(T1)| ≠ |V2(T2)| then:
		return false
	end-if
	
	generateCodes(T1, r1)
	generateCodes(T2, r2)
	
	if r1.code = r2.code then:
		return true
	else:
		return false
	end-if

end-isIsomorphic

	
generateCodes(T, v):
	
	v.color ⇐ BLACK
	Queue childCodes ⇐ ∅

	if deg(v) = 1 then: // if v is leaf
		v.code ⇐ “10”
	else:
		for each u ∈ Adj(v) do:
			if u.color = WHITE then:
				generateCodes(T,u)
				Enqueue(childCodes, u.code)
			End-if
		end-for
	end-if
	
	Sort( childCodes ) // sort the children codes of v by codes

	temp ⇐ “”
	while childCodes is not empty do:
		temp ⇐ temp + Dequeue(childCodes)
	end-while

	v.code ⇐ “1” + temp + “0”

end-generateCodes

```

### Algorithm for un-rooted Tree Using Fire Algorithm
```java
isIsomorphicWithoutRoot(T1, T2):
     create Queue roots1
     create Queue roots2

     roots1 ⇐ Fire(T1)
     roots2 ⇐ Fire(T2)
     
     if roots1.size() ≠ roots2.size() then:
          return false
     end-if
     
     r1 ⇐ Dequeue(roots1)

     code1 ⇐ generateCode(T1, r1) // continue like the rooted-tree algorithm

     while roots2 is not empty do:
     
          r2 ⇐ Dequeue(roots2)
          code2 ⇐ generateCode(T2, r2) // continue like the rooted-tree algorithm
	  
	  if code1 = code2 then:
	     return true
	  end-if
	  
     end-while

     return false

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
				deg[v] ⇐ deg[v] - 1
				if deg[v]=1 then:
					Enqueue(Q,v)
				end-if 
			end-for
		end-for 
	end-while 

	return Q

end-Fire


```
