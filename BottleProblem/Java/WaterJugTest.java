package BottleProblem.Java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterJugTest {
    @Test
    public void test1() {
        int m=1, n=1;
        WaterJug waterJug = new WaterJug(m,n);
        int[][]actual = waterJug.matrix;
        int[][] expected = {{0,1,1,0},
                            {1,0,1,1},
                            {1,1,0,1},
                            {0,1,1,0}};
        assertTrue(checkMatrices(actual,expected));
    }
    @Test
    public void test2() {
        int m=2, n=1;
        WaterJug waterJug = new WaterJug(m,n);
        int[][]actual = waterJug.matrix;
        int[][] expected = {{0,	1,	0,	0,	1,	0},
                {1,	0,	1,	0,	0,	1},
                {1,	1,	0,	1,	1,	0},
                {0,	1,	1,	0,	1,	1},
                {1,	0,	0,	1,	0,	1},
                {0,	1,	0,	0,	1,	0}};
        assertTrue(checkMatrices(actual,expected));
    }
    @Test
    public void test3() {
        int m=2, n=2;
        WaterJug waterJug = new WaterJug(m,n);
        int[][]actual = waterJug.matrix;
        int[][] expected =
                {{0,	0,	1,	0,	0,	0,	1,	0,	0},
                        {1,	0,	1,	1,	0,	0,	0,	1,	0},
                        {1,	0,	0,	0,	0,	0,	1,	0,	1},
                        {1,	1,	0,	0,	0,	1,	1,	0,	0},
                        {0,	1,	1,	1,	0,	1,	1,	1,	0},
                        {0,	0,	1,	1,	0,	0,	0,	1,	1},
                        {1,	0,	1,	0,	0,	0,	0,	0,	1},
                        {0,	1,	0,	0,	0,	1,	1,	0,	1},
                        {0,	0,	1,	0,	0,	0,	1,	0,	0}};
        assertTrue(checkMatrices(actual,expected));
    }
    private boolean checkMatrices(int[][]a, int[][]b){
        for(int i=0; i<a.length; i++){
            for (int j = 0; j<a[0].length; j++) {
                if(a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }
}