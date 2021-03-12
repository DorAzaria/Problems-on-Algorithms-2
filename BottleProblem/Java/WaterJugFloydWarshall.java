package BottleProblem.Java;


import java.util.Arrays;

public class WaterJugFloydWarshall {
    private int b1, b2,size;
    private int[][] h;
    private String[][] paths;
    final static int INF = 9999999;

    public WaterJugFloydWarshall(int n, int m) {
        this.b1 = n;
        this.b2 = m;
        size = (n+1)*(m+1);
        h = new int[size][size];
        paths = new String[size][size];
        for (int i = 0; i < h.length; i++) {
            Arrays.fill(h[i],INF);
            Arrays.fill(paths[i],"");
        }
        generate();
        FW_Bottle();
    }

    private void generate() {
        for (int i = 0; i < b1 +1; i++) {
            for (int j = 0; j < b2 +1; j++) {
                int index = index(i,j);
                h[index][index(i,0)] = 1;
                h[index][index(0,j)] = 1;
                h[index][index(b1,j)] = 1;
                h[index][index(i, b2)] = 1;
                h[index][index(Math.max(0,i+j- b2),Math.min(b2,i+j))] = 1;
                h[index][index(Math.min(i+j, b1),Math.max(0,i+j- b1))] = 1;

                paths[index][index(i,0)] = "("+i+","+j+")->("+i+","+0+")";
                paths[index][index(0,j)] = "("+i+","+j+")->("+0+","+j+")";
                paths[index][index(b1,j)] = "("+i+","+j+")->("+ b1 +","+j+")";
                paths[index][index(i, b2)] = "("+i+","+j+")->("+i+","+ b2 +")";
                paths[index][index(Math.max(0,i+j- b2),Math.min(b2,i+j))] = "("+i+","+j+")->("+Math.max(0,i+j- b2)+","+Math.min(b2,i+j)+")";
                paths[index][index(Math.min(i+j, b1),Math.max(0,i+j- b1))] = "("+i+","+j+")->("+Math.min(i+j, b1)+","+Math.max(0,i+j- b1)+")";
            }
        }
    }

    private void FW_Bottle() {
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(h[i][j] > h[i][k] + h[k][j]){
                        paths[i][j] = paths[i][k] + "->" + paths[k][j];
                    }
                    h[i][j] = Math.min(h[i][j], h[i][k] + h[k][j]);
                }
            }
        }
    }

    private int index(int i, int j) {
        return (b2 +1)*i+j;
    }

    public String getPath(int i,int j) {
        return paths[0][index(i,j)];
    }

    public void printMatrix() {
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < h.length; j++) {
                System.out.print((h[i][j] == INF ? "∞" : (int)h[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WaterJugFloydWarshall warshall = new WaterJugFloydWarshall(2, 2);
        warshall.printMatrix();
        System.out.println(warshall.getPath(2,2));
    }
}