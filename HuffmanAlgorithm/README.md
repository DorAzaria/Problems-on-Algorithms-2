# Huffman Algorithm

### Huffman Algorithm O(NlogN) - (Only if the frequencies are not sorted)

```java
C is a set of n characters, c є C and f(c) is frequency of c
|C| - set of leaves
Q – Priority Queue where key is f(c) (priority by the frequency (min first) )

Huffman(C): // O(NlogN)
    n ⇐ |C|
    create PriorityQueue Q ⇐ C // O(N)

    for i⇐1 to n-1 do:
        create Node z
        x ⇐ Q.extractMin() // O(logN)
        y ⇐ Q.extractMin() // O(logN)

        z.left ⇐ x
        z.right ⇐ y
        z.freq ⇐ x.freq + y.freq

        x.parent ⇐ z
        y.parent ⇐ z

        Insert(Q, z) // O(logN)
    end-for

    root ⇐ Q.extractMin() // O(logN)
    return root
end-Huffman

```
