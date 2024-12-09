package kunalSeries.recursionlearning.basicintro;
// TODO: https://www.youtube.com/watch?v=M2uO2nMT0Bk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24
// TS: 00:59:00 kunal
// Find the nth fibonacci number using Recursion
public class _3_FibonacciNthFiboNumber {

    public static int fibo(int n){
        // base condition - since interval is not given hence we go from 0
        // In this case we know 0th = 0 and 1th will be 1
        if(n==0 || n==1){ // if n<2 return n
            return n;
        }

        // recursive call
        return  fibo(n-1)+fibo(n-2); // since we need to return something na(the nth fibo number) that's y written with return statement.
        // 1st fibo(n-1) will finish then fibo(n-2) will start executing.
        // Non-Tail Recursion: Since f1 + f1 executing and then + (addition of two previous number. this is extra computation)
    }
// Time complexity is proportional to the size of this tree, which is O(2^n) (approximately). And space O(n)

    public static void main(String[] args) {
//        int n = 7; // 13   -> 0,1,1,2,3,5,8,13,21,34,55   counted from 0 so 7th will be 13
        int n = 4;

        int res = fibo(n);
        System.out.println(n + "th Fibonacci number is : " + res);
    }
}
