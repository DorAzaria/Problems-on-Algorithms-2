package FloydWarshall.Java;

public class FW_Tests {
    public static boolean[][] booleanT1() {
        boolean T = true, F = false;
        boolean[][] matrix =
                {
                        {T, F, T, F},
                        {T, T, T, F},
                        {F, F, T, T},
                        {F, T, F, T}
                };
        return matrix;
    }

    public static boolean[][] booleanT2(){
        boolean [][] mat = {{true,true,true,false},
                {true,true,false,true},
                {true,false,true,true},
                {false,true,true,true}};

        return mat;
    }

    public static boolean[][] booleanT3(){
        boolean [][] mat = {{true,false,false,false},
                {false,true,true,true},
                {false,true,true,true},
                {false,true,true,true}};
        return mat;
    }

    public static boolean[][] booleanT4(){
        boolean [][] mat = {{true,true,false,false},
                {true,true,false,false},
                {false,false,true,true},
                {false,false,true,true}};
        return mat;
    }

    public static boolean[][] booleanT5(){
        boolean [][] mat = {{true,true,false},
                {true,true,true},
                {false,true,true}};
        return mat;
    }

    public static boolean[][] booleanT6(){
        boolean [][] mat = {{true,true,false,false},
                {true,true,true,false},
                {false,true,true,true},
                {false,false,true,true}};
        return mat;
    }

    public static boolean[][] booleanT7(){
        boolean [][] mat = {{true,true,false,false,true},
                {true,true,true,false,false},
                {false,true,true,true,false},
                {false,false,true,true,true},
                {true,false,false,true,true}};
        return mat;
    }

    //        V4
    //        /\
    //       /  \
    //      /____\
    //     V0     V5
    //    V6------V3
    //      |     |
    //	    |_____|
    //     V1     V2
    //

    public static boolean[][] booleanT8() {
        boolean[][] mat= {{false,false,false,false,true,true,false},
                {false,false,true,false,false,false,true},
                {false,true,false,true,false,false,false},
                {false,false,true,false,false,false,true},
                {true,false,false,false,false,true,false},
                {true,false,false,false,true,false,false},
                {false,true,false,true,false,false,false}};
        return mat;
    }
}
