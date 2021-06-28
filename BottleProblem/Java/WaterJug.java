package BottleProblem.Java;

public class WaterJug {

    int x, y, max, num_nodes;
    int[][] matrix;

    public WaterJug(int b1, int b2) {
        this.x = b1;
        this.y = b2;
        this.num_nodes = (b1+1)*(b2+1);
        this.matrix = new int[num_nodes][num_nodes];
        generate();
    }

    private int getIndex(int i, int j) {
        return (this.y+1)*i + j;
    }

    private void generate() {
        // java init arrays filling with '0'.
        for(int i = 0; i <= this.x ; i++) {
            for(int j = 0 ; j <= this.y; j++) {
                /*
                This index represents the tuple (i,j) of a scenario (node).
                 */
                int index = getIndex(i,j);

                /*
                Each scenario (node) could have at most 6 out-degrees edges.
                 */

                // Empty the 1st bottle
                matrix[index][getIndex(0,j)] = 1;
                // Empty the 2nd bottle
                matrix[index][getIndex(i,0)] = 1;

                // Filling the 1st bottle
                matrix[index][getIndex(x,j)] = 1;
                // Filling the 2nd bottle
                matrix[index][getIndex(i,y)] = 1;

                // i+j means the amount of water of the 2 bottles together.
                // Pouring 1st to the 2nd
                matrix[index][getIndex((i+j)-Math.min(y,i+j), Math.min(y,i+j))] = 1;
                // Pouring 2nd to the 1st
                matrix[index][getIndex(Math.min(x,i+j), (i+j)-Math.min(x,i+j))] = 1;
            } // end inner for
        } // end main for

        /* To deny self-point of each node */
        for(int i = 0 ; i < this.num_nodes; i++) {
            this.matrix[i][i] = 0;
        }
    }

    public void printMatrix() {
        System.out.print("      ");
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
        }
        System.out.println();
        int k = 0, l = 0;
        for (int i = 0; i < this.num_nodes; i++) {
            System.out.print("(" + k + "," + l + ") ");
            for (int j = 0; j < this.num_nodes; j++) {
                System.out.print("  " + matrix[i][j] + "   ");
            }
            System.out.println();
            if(l == y) {
                k++;
                l = 0;
            }
            else {
                l++;
            }
        }

    }

    public static void main(String[] args) {
        int bottle1 = 6;
        int bottle2 = 2;

        WaterJug waterJug = new WaterJug(bottle1,bottle2);
        waterJug.printMatrix();
    }
}
