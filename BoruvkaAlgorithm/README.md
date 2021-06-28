# Boruvka Algorithm

### Algorithm

```java
Boruvka(G)

    for each v∈V(G) do: // O(|V|)
        MakeSet(v)
    end-for

    create Tree T ⇐ ∅
    isFinished ⇐ false

    while is not isFinished do:
      create cheapest[|V(G)|] // init to null

      for i ⇐ 0 to |E| do:
          e ⇐ E[i]
          g1 ⇐ FindSet(e.v1)
          g2 ⇐ FindSet(e.v2)

          if g1 ≠ g2 then:
          
              if e.weight < cheapest[g1].weight then:
                  cheapest[g1] ⇐ e
              end-if

              if e.weight < cheapest[g2].weight then: 
                  cheapest[g2] ⇐ e
              end-if

          end-if
      end-for

      isFinished ⇐ true

      for i ⇐ 0 to |V| do:
          if cheapest[i] ≠ NULL then:
              T.add(cheapest[i])
              Union(cheapest[i].v1, cheapest[i].v2)
              isFinished  = false
          end-if
      end-for
    end-while
    return T
end-Boruvka

MakeSet(v): // O(1)
	v.parent ⇐ v
end-MakeSet

FindSet(v): // O(log|V|)
	if v = v.parent then:
		return v.parent
	else:
		return FindSet(v.parent)
	end-if
end-FindSet

Union(u,v): // O(log|V|)
	uRoot ⇐ FindSet(u)
	vRoot ⇐ FindSet(v)
	
	uRoot.parent ⇐ vRoot
end-Union

```
