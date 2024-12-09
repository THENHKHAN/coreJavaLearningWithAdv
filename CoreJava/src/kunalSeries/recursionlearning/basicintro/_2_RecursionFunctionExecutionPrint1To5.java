package kunalSeries.recursionlearning.basicintro;
// TODO: (kunal)Intro - https://www.youtube.com/watch?v=M2uO2nMT0Bk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24
// TS : 00:14:00
public class _2_RecursionFunctionExecutionPrint1To5 {

    public static void print1(int n){ // 1
        System.out.println("Print1 : " + n + "   AND  Calling print2 to print 2");
        // Hey print2, please print 2 ***till then I am waiting*** (from next execution)
        print2(n+1);
    }

    public  static void print2(int n){ // 2
        System.out.println("Print2 : " + n + "   AND  Calling print3 to print 3");
        // Hey print3, please print 3 ***till then I am waiting*** (from next execution)
        print3(n+1);
    }

    public static void print3(int n){ // 3
        System.out.println("Print3 : " + n + "   AND  Calling print4 to print 4");
        // Hey print4, please print 4 ***till then I am waiting*** (from next execution)
        print4(n+1);
    }

    public static void print4(int n){ // 4
        System.out.println("Print4 : " + n + "   AND  Calling print5 to print 5");
        // Hey print5, please print 5 ***till then I am waiting*** (from next execution)
        print5(n+1);
    }

    public static void print5(int n){ // 5
        System.out.println("Print5 : " + n + "   AND  NO Further Calling ");
        // STOP after printing 5. - no further call
    }


   public static void print1To5Recursion(int n){
        // 1st we need to think about the termination(when to stop) condition.
       // base condition
       if (n==5){
           System.out.println("Print5 : " + n);
           return; // since after printing 5 we need to stop without returning anything
       }
       System.out.println("Print" +n + " : " + n); //format  print1 : 1
       // recursive call
       // if you are calling a function again and again, you can treat it as a separate call in the stack
       // this is called TAIL recursion -  this is the last function call
       print1To5Recursion(n+1); // recursive call
       // since there is no computation after the recursive call.

   }

    public static void main(String[] args) {
        // write a function that takes in a number and prints it
        // print first 5 numbers: 1 2 3 4 5
        int num = 1;
        System.out.println("Main function Start......");

        System.out.println(" Normal multiple function Call...........");
        print1(num);
        // DEBUG the Number example with normal function call You'll understand the flow of recursion(how its flow will be)
        System.out.println(" Recursion Call...........");
        print1To5Recursion(num); // the Body can be different but the Signature will always be same (num of Args and Typ of Args)

        System.out.println("Main function END......");

    }
}
// TODO: SOME IMPORTANT POINTS:
/*
1 --> While the function is not finished executing, it will remain in STACK.
2 --> When a function finished executing, It will removed FROM the STACK. And the control(flow) is moved
            FROM WHERE IT CALLED.
3 --> Base Condition in recursion: Condition where our recursion will STOP making new calls.
4 --> If No Base Condition : Function call will keep happening, STACK will be filled again and again
        Memory of computer will exceed the Limit - STACK Overflow ERROR.
5 --> Base Condition is mostly represented by the answer already we  have.
            EX: for Fibo - f(0) = 0 , f(1) = 1, factorial : f(1) and f(0) = 1;
 */