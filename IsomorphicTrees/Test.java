package IsomorphicTrees;
import java.util.ArrayList;

public class Test {
    static int inf = 1000000;
    public static void main(String[] args) {
        TreeIsomorphism treeIsomorphism = new TreeIsomorphism();
        boolean actualRoot, actualNoRoot;
        ArrayList<ArrayList<Integer>> tree1 = tree1();
        ArrayList<ArrayList<Integer>> tree2 = tree2();
        ArrayList<ArrayList<Integer>> tree3 = tree3();
        ArrayList<ArrayList<Integer>> tree4 = tree4();

        //********************* TEST 1 **********************///
        actualRoot = treeIsomorphism.isIsomorphic(tree1,0,tree2,0);
        actualNoRoot = treeIsomorphism.isIsomorphicWithoutRoot(tree1,tree2);
        System.out.println("Test 1 ---> Are the trees isomorphic?");
        System.out.println("\t\t\tWith given root --> {actual="+actualRoot+"}  --> {expected=true}");
        System.out.println("\t\t\tWithout given root --> {actual="+actualNoRoot+"}  --> {expected=true}");


        //********************* TEST 2 **********************///
        actualRoot = treeIsomorphism.isIsomorphic(tree2,0,tree3,0);
        actualNoRoot = treeIsomorphism.isIsomorphicWithoutRoot(tree2,tree3);
        System.out.println("Test 2 ---> Are the trees isomorphic?");
        System.out.println("\t\t\tWith given root --> {actual="+actualRoot+"}  --> {expected=false}");
        System.out.println("\t\t\tWithout given root --> {actual="+actualNoRoot+"}  --> {expected=true???}");

        //********************* TEST 3 **********************///
        actualRoot = treeIsomorphism.isIsomorphic(tree3,0,tree4,0);
        actualNoRoot = treeIsomorphism.isIsomorphicWithoutRoot(tree3,tree4);
        System.out.println("Test 3 ---> Are the trees isomorphic?");
        System.out.println("\t\t\tWith given root --> {actual="+actualRoot+"}  --> {expected=false}");
        System.out.println("\t\t\tWithout given root --> {actual="+actualNoRoot+"}  --> {expected=false}");

    }

    public static ArrayList<ArrayList<Integer>> tree1() {
        /*TREE-1
         *      (1)   (4)
         *       |     |
         *      (0)---(2)
         *       |     |
         *      (3)   (5)---(6)
         */
        int[][] tree1 = {
                {inf,1,2,3,inf,inf,inf},
                {0,inf,inf,inf,inf,inf,inf},
                {0,inf,inf,inf,4,5,inf},
                {0,inf,inf,inf,inf,inf,inf},
                {inf,inf,2,inf,inf,inf,inf},
                {inf,inf,2,inf,inf,inf,6},
                {inf,inf,inf,inf,inf,5,inf}
        };
        return generateTree(tree1);
    }

    public static ArrayList<ArrayList<Integer>> tree2() {
        /*TREE-2
         *      (2)   (4)
         *       |     |
         *      (0)---(1)
         *       |     |
         *      (3)   (5)---(6)
         */
        int[][] tree2 = {
                {inf,1,2,3,inf,inf,inf},
                {0,inf,inf,inf,4,5,inf},
                {0,inf,inf,inf,inf,inf,inf},
                {0,inf,inf,inf,inf,inf,inf},
                {inf,1,inf,inf,inf,inf,inf},
                {inf,1,inf,inf,inf,inf,6},
                {inf,inf,inf,inf,inf,5,inf}
        };
        return generateTree(tree2);
    }

    public static ArrayList<ArrayList<Integer>> tree3() {
        /*TREE-3
         *      (2)---(4)
         *       |
         *      (0)---(3)---(6)
         *       |     |
         *      (1)   (5)
         */
        int[][] tree = {
                {inf,1,2,3,inf,inf,inf},
                {0,inf,inf,inf,inf,inf,inf},
                {0,inf,inf,inf,4,inf,inf},
                {0,inf,inf,inf,inf,5,6},
                {inf,inf,2,inf,inf,inf,inf},
                {inf,inf,inf,3,inf,inf,inf},
                {inf,inf,inf,3,inf,inf,inf}
        };
        return generateTree(tree);
    }
    public static ArrayList<ArrayList<Integer>> tree4() {
        ArrayList<ArrayList<Integer>> tree4 = new ArrayList<>();
        tree4.add(new ArrayList<>());
        tree4.get(0).add(3);
        return tree4;
    }

    public static ArrayList<ArrayList<Integer>> generateTree(int[][] tree) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < tree.length; i++) {
            for(int j = 0; j < tree.length; j++) {
                if(j == 0) {
                    graph.add(new ArrayList<>());
                }
                if(tree[i][j] != inf) {
                    graph.get(i).add(j);
                }
            }
        }
        return graph;
    }
}
