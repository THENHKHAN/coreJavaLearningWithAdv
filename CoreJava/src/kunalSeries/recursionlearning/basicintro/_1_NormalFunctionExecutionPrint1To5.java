package kunalSeries.recursionlearning.basicintro;
// TODO: (kunal)Intro - https://www.youtube.com/watch?v=M2uO2nMT0Bk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24
public class _1_NormalFunctionExecutionPrint1To5 {

    public static void print1(int n){ // 1
        System.out.println("Print1 : " + n + "   AND  Calling print2 to print 2");
        print2(n+1);
    }

    public  static void print2(int n){ // 2
        System.out.println("Print2 : " + n + "   AND  Calling print3 to print 3");
        print3(n+1);
    }

    public static void print3(int n){ // 3
        System.out.println("Print3 : " + n + "   AND  Calling print4 to print 4");
        print4(n+1);
    }

    public static void print4(int n){ // 4
        System.out.println("Print4 : " + n + "   AND  Calling print5 to print 5");
        print5(n+1);
    }

    public static void print5(int n){ // 5
        System.out.println("Print5 : " + n + "   AND  NO Further Calling ");
        // STOP after printing 5. - no further call
    }


    public static void main(String[] args) {
        // write a function that takes in a number and prints it
        // print first 5 numbers: 1 2 3 4 5
        int num = 1;
        System.out.println("Main function Start......");
        print1(num);
        System.out.println("Main function END......");
        // DEBUG It, You'll understand the flow of recursion(how its flow will be)

    }
}
