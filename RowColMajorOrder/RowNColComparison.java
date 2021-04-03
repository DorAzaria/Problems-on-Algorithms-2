package RowColMajorOrder;

public class RowNColComparison {
    final static int SIZE = 10000;

    public static void main(String[] args) {
        int[][] matrix = new int[SIZE][SIZE];
        int counter = 0;
        long start = System.currentTimeMillis();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[i][j] = counter++;
            }
        }
        long end = System.currentTimeMillis();
        long timeRow = end - start;
        System.out.println("## TOTAL TIME FOR ROW ORDER: "+timeRow+"ms.");

        counter = 0;
        start = System.currentTimeMillis();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[j][i] = counter++;
            }
        }
        end = System.currentTimeMillis();
        long timeCol = end - start;
        System.out.println("## TOTAL TIME FOR COLUMN ORDER: "+timeCol+"ms.");
        System.out.println("## TOTAL COLUMN ORDER: "+timeCol+"ms ## TOTAL ROW ORDER: "+timeRow+"ms.");
    }
}
