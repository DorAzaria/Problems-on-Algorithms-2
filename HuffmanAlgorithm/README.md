# Huffman Algorithm


### Huffman Algorithm O(N) - (Only if it's sorted)
```java
Huffman(A):
        N ⇐ |A|
        create Queue Q1
        create Queue Q2

        for i⇐ 0 to N do:
                create Node node
                node.freq ⇐ A[i].freq
                node.char ⇐ A[i].char
                Enqueue(Q1, node)
        end-for

        while |Q1| + |Q2| > 1 do:
                x ⇐ getMin(Q1, Q2)
                y ⇐ getMin(Q1, Q2)

                create Node z
                z.left ⇐ x
                z.right ⇐ y
                z.freq ⇐ x.freq + y.freq

                x.parent ⇐ z
                y.parent ⇐ z

                Enqueue(Q2, z)
        end-while 

        if Q1 is empty then:
                root ⇐ Dequeue(Q2)
                return root
        else:
                root ⇐ Dequeue(Q1)
                return root
end-Huffman

getMin(Q1, Q2):
        create Node x

        if Q1 is empty then:
                x ⇐ Dequeue(Q2)
        else if Q2 is empty then:
                x ⇐ Dequeue(Q1)
        else:

            if Q1.head().freq > Q2.head().freq then:
                    x ⇐ Dequeue(Q2)
            else:
                    x ⇐ Dequeue(Q1)
            end-if
        end-if 
        return x
end-getMin

```

### Huffman Algorithm O(NlogN) - (Only if the frequencies are not sorted)
```java
HuffmanUnsorted(A): // O(NlogN)
	Sort(A) // sort by A.freq
	root ⇐ Huffman(A) // Use the algorithm from above
	return root
end-HuffmanUnsorted
```
