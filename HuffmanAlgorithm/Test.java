package HuffmanAlgorithm;

public class Test {

    public static void main(String[] args) {
        char[] letters1 = {'a', 'b', 'c', 'd'};
        int[] frequency1 = {10, 18, 24, 48};

        Huffman huffman = new Huffman(letters1, frequency1);
        System.out.println("Huffman Code - TEST #1: "+huffman.getCode());
        // a = 110,  b = 111,  c = 10,  d = 0,

        char[] letters2 = {'f','e','c','b','d','a'};
        int[] frequency2 = {5,9,12,13,16,45};
        huffman = new Huffman(letters2, frequency2);
        System.out.println("Huffman Code - TEST #2: "+huffman.getCode());
        // f = 1100,  e = 1101,  c = 100,  b = 101,  d = 111,  a = 0,

        char[] letters3 = {'d','a','c','e','b'};
        int[] frequency3 = {8,12,15,25,40};
        huffman = new Huffman(letters3, frequency3);
        System.out.println("Huffman Code - TEST #3: "+huffman.getCode());
        // d = 1110,  a = 1111,  c = 110,  e = 10,  b = 0,
    }
}
