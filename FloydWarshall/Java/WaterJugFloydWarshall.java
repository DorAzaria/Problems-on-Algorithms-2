package FloydWarshall.Java;

public class WaterJugFloydWarshall {
    static int infinity = Integer.MAX_VALUE;
    //the index calculation
    private static int index(int i, int j, int n){
        return (n+1)*i + j;
    }
    // with weights
    // the matrix initialization
    private static int[][] initMatrBottleWeight(int m, int n){
        int dim = (m+1)*(n+1); // matrix dimension
        int [][]mat = new int[dim][dim];
        for (int i=0; i<dim; i++){
            for (int j=0; j<dim; j++){
                mat[i][j]= infinity;
            }
        }
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                int ind = index(i,j,n);
                mat[ind][index(0,j,n)]=1;
                mat[ind][index(i,0,n)]=1;
                mat[ind][index(i,n,n)]=1;
                mat[ind][index(m,j,n)]=1;
                int i1=index(Math.max(0,i+j-n),Math.min(n,i+j) ,n);
                mat[ind][i1]=1;
                i1 = index(Math.min(m,i+j),Math.max(0,j+i-m) ,n);
                mat[ind][i1]=1;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            mat[i][i] = infinity;
        }
        return mat;
    }

    public static String[][] FWWeightForBottle(int [][] mat, int n){
        int len = mat.length;
        // path matrix initialization
        String [][]pathMat = new String[len][len];
        for (int i=0;i<len;i++){
            int ai = i/(n+1),  bi = i%(n+1);
            for (int j=0;j<len;j++){
                int aj = j/(n+1),  bj = j%(n+1);
                if (mat[i][j] != infinity)
                    pathMat[i][j] = "" + ai + bi + "->" + aj + bj + " ";
                else
                    pathMat[i][j] = "";
            }
        }

        // matrix building
        for (int k = 0; k<len; k++){
            for (int i = 0; i<len; i++){
                for (int j = 0; j<len; j++){
                    if (mat[i][k]!=infinity && mat[k][j]!=infinity){
                        if (mat[i][j] > mat[i][k]+mat[k][j]){
                            mat[i][j] = mat[i][k]+mat[k][j];
                            pathMat[i][j] = pathMat[i][k]+pathMat[k][j];
                        }
                    }
                }
            }
        }
        return pathMat;
    }
    public static void printMatrix(int [][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if (mat[i][j] < infinity)
                    System.out.print(mat[i][j]+", ");
                else System.out.print("*  ");
            }
            System.out.println();
        }
    }
    public static void printIntPath(String [][]pathMat, int[][] mat){
        System.out.println();
        for(int i=0; i<pathMat.length; i++){
            for(int j=0; j<pathMat[0].length; j++){
                if (mat[i][j] < infinity)  System.out.print("["+pathMat[i][j]+"];\t");
            }
            System.out.println();
        }
    }

    public static void checkBottleWeight(int m, int n){
        System.out.println("-----------------------------");
        int mat[][] = initMatrBottleWeight(m,n);
        printMatrix(mat);
        System.out.println();
        String[][] paths = FWWeightForBottle(mat, n);
        printMatrix(mat);
        System.out.println();
        printIntPath(paths, mat);
    }
    public static void main(String[] args) {
        int m=3, n=2;//m-the first bottle, n-the second bottle
        System.out.println("m = "+ m + ",  n = "+n+"\n");
        checkBottleWeight(m, n);

    }
}