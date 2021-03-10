package DivideChocolateProblem;

public class DivideChocolateProblem {

    public static int divideChocolate(int n){
        if(n==2)
            return 1;
        if(n==1)
            return 0;

        int k = (int)(Math.random()*(n-1)) + 1;
        int a = divideChocolate(k); // left side
        int b = divideChocolate(n-k); // right side

        return k*(n-k) + a + b;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("For n="+n + " the cost is: "+divideChocolate(n));
    }
}

