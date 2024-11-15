package kunalSeries.basics.maths;

// TOD: Write a program to return nth position of fibonacci series of 1st n sequence. OR find the nth fibo number
// [0, 1, 1, 2, 3, 5, 8, 13, 21, 34......................]
public class _1_ReturnNthFiboOfNthFiboTerms {

    public static int findNthFiboTerm(int n){
        if(n==0 || n==1){
            return n;
        }
        int n0 = 0;
        int n1 = 1;
        int n2 = n0+n1;
        int count = 2 ; // since 1st two excluded
        while(count<=n){
            n2 = n0+n1; // jab break hogi means hmari counting complete ho gyi
            n0 = n1 ;
            n1 = n2 ;
            count++;
        }
        return n2 ;
    }

    public static void main(String[] args) {
//        int n = 6; // 8
//        int n = 7; // 13
//        int n = 8; //  21
        int n = 3; //
        System.out.println(n + "th Fibonacci number is : " + findNthFiboTerm(n));

    }
}
/*
[0, 1, 1, 2, 3, 5, 8, 13, 21, 34......................]
what will be the nth fibo number. let nth  = 7
13 will be the answer (counting from 0 not one)

 */
