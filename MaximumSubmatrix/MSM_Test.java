package MaximumSubmatrix;

import java.util.Arrays;

public class MSM_Test {


    public static void main(String[] args) {

        int[][] matrix1 = {
                {2,1,-3,-4,5},
                {0,6,3,4,1},
                {2,-2,-1,4,-5},
                {-3,3,1,0,3}
        };

        System.out.println("matrix1 : maxSum=18, i=1, j=1, k=3, l=3");
        System.out.println("\tNaive O(N^6):      " + Arrays.toString(MSM_NaiveON6.maxSumMatrix(matrix1)));
        System.out.println("\tBest O(N^4):       " + Arrays.toString(MSM_BestON4.maxSumMatrix(matrix1)));
        System.out.println("\tDynamic O(N^4):    " + Arrays.toString(MSM_DynamicON4.maxSumMatrix(matrix1)));
        System.out.println("\tSuper Best O(N^3): " + Arrays.toString(MSM_SuperBestON3.maxSumMatrix(matrix1)) + " \n");

        int[][] matrix2 = {
                {-10,5,-4,3,4},
                {4,-100,10,-30,5},
                {3,2,8,1,6},
                {-5,2,-20,3,1}
        };

        System.out.println("matrix2 : maxSum=20, i=2, j=0, k=2, l=4");
        System.out.println("\tNaive O(N^6):      " + Arrays.toString(MSM_NaiveON6.maxSumMatrix(matrix2)));
        System.out.println("\tBest O(N^4):       " + Arrays.toString(MSM_BestON4.maxSumMatrix(matrix2)));
        System.out.println("\tDynamic O(N^4):    " + Arrays.toString(MSM_DynamicON4.maxSumMatrix(matrix2)));
        System.out.println("\tSuper Best O(N^3): " + Arrays.toString(MSM_SuperBestON3.maxSumMatrix(matrix2)) + " \n");

        int[][] matrix3 = {
                {1,2,3},
                {-3,4,5},
                {-1,-2,-4}
        };

        System.out.println("matrix3 : maxSum=14, i=0, j=1, k=1, l=2");
        System.out.println("\tNaive O(N^6):      " + Arrays.toString(MSM_NaiveON6.maxSumMatrix(matrix3)));
        System.out.println("\tBest O(N^4):       " + Arrays.toString(MSM_BestON4.maxSumMatrix(matrix3)));
        System.out.println("\tDynamic O(N^4):    " + Arrays.toString(MSM_DynamicON4.maxSumMatrix(matrix3)));
        System.out.println("\tSuper Best O(N^3): " + Arrays.toString(MSM_SuperBestON3.maxSumMatrix(matrix3)) + " \n");

        int[][] matrix4 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("matrix4 : maxSum=45, i=0, j=0, k=2, l=2");
        System.out.println("\tNaive O(N^6):      " + Arrays.toString(MSM_NaiveON6.maxSumMatrix(matrix4)));
        System.out.println("\tBest O(N^4):       " + Arrays.toString(MSM_BestON4.maxSumMatrix(matrix4)));
        System.out.println("\tDynamic O(N^4):    " + Arrays.toString(MSM_DynamicON4.maxSumMatrix(matrix4)));
        System.out.println("\tSuper Best O(N^3): " + Arrays.toString(MSM_SuperBestON3.maxSumMatrix(matrix4)) + " \n");

        int[][] matrix5 = {
                {-2,1},
                {1,3}
        };

        System.out.println("matrix5 : maxSum=4, i=0, j=1, k=1, l=1");
        System.out.println("\tNaive O(N^6):      " + Arrays.toString(MSM_NaiveON6.maxSumMatrix(matrix5)));
        System.out.println("\tBest O(N^4):       " + Arrays.toString(MSM_BestON4.maxSumMatrix(matrix5)));
        System.out.println("\tDynamic O(N^4):    " + Arrays.toString(MSM_DynamicON4.maxSumMatrix(matrix5)));
        System.out.println("\tSuper Best O(N^3): " + Arrays.toString(MSM_SuperBestON3.maxSumMatrix(matrix5)) + " \n");

        int[][] matrix6 = {
                {1,2},
                {4,-3}
        };

        System.out.println("matrix6 : maxSum=5, i=0, j=0, k=1, l=0");
        System.out.println("\tNaive O(N^6):      " + Arrays.toString(MSM_NaiveON6.maxSumMatrix(matrix6)));
        System.out.println("\tBest O(N^4):       " + Arrays.toString(MSM_BestON4.maxSumMatrix(matrix6)));
        System.out.println("\tDynamic O(N^4):    " + Arrays.toString(MSM_DynamicON4.maxSumMatrix(matrix6)));
        System.out.println("\tSuper Best O(N^3): " + Arrays.toString(MSM_SuperBestON3.maxSumMatrix(matrix6)) + " \n");

        int[][] matrix7 = {
                {2,10,8,3},
                {-8,14,-1,4},
                {-6,-1,8,-2},
                {1,8,7,3},
                {8,2,-10,-8}
        };

        System.out.println("matrix7 : maxSum=61, i=0, j=1, k=3, l=3");
        System.out.println("\tNaive O(N^6):      " + Arrays.toString(MSM_NaiveON6.maxSumMatrix(matrix7)));
        System.out.println("\tBest O(N^4):       " + Arrays.toString(MSM_BestON4.maxSumMatrix(matrix7)));
        System.out.println("\tDynamic O(N^4):    " + Arrays.toString(MSM_DynamicON4.maxSumMatrix(matrix7)));
        System.out.println("\tSuper Best O(N^3): " + Arrays.toString(MSM_SuperBestON3.maxSumMatrix(matrix7)) + " \n");

    }
}
