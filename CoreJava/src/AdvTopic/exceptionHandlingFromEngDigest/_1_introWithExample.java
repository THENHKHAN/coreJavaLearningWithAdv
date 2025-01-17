package kunalSeries.basics.concepts.exceptionHandlingFromEngDigest;

public class _1_introWithExample {

    public static void simpleTryCatchEx(){
        try {
            int s = 10/0;
        }catch (ArithmeticException e){
//            System.out.println("only Exception ref printing by e : " +e); // only Exception ref printing by e : java.lang.ArithmeticException: / by zero
            System.out.println("getMSG() : " +e.getMessage());
//            System.out.println("e.toString() : " +e.getMessage()); // will give same msg as getMsg
            System.out.println("Below is e.printStackTrace() .... \n");
            e.printStackTrace();
            // other way to print in sequence
//            e.printStackTrace(System.out); // Print stack trace explicitly to System.out
        }

        System.out.println("Handled Exceptions!!");
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
        }
        /*
        OUTPUT:
        getMSG() : / by zero
        Below is e.printStackTrace() ....

        Handled Exceptions!!
        0
        1
        2
        3
        java.lang.ArithmeticException: / by zero
            at kunalSeries.basics.concepts.exceptionHandlingFromEngDigest._3_ThrowsKeyword.main(_3_ThrowsKeyword.java:8)

         */
    }

    public static void main(String[] args) {
        try {
            int a = 10;
//            int b = 20;
            int b = 0;
            int divideByZero = a/b;
            System.out.println("Rest of code in try block will run if Exception not occurred.");
            System.out.println(a + " By " + b + " is : " + divideByZero);
        /*
        Now when an exception occurs, the rest of the code inside the try block is skipped.
        The catch block catches the exception and statements inside the catch block is executed.
        If none of the statements in the try block generates an exception, the catch block is skipped.
         */
        } catch (Exception e){

            System.out.println("Exception Occurred getMessage: " + e.getMessage() );// Exception Occurred getMessage: / by zero
//            System.out.println("Exception Occurred getStackTrace: " + e.getStackTrace() );// [Ljava.lang.StackTraceElement;@119d7047 // useless-
            System.out.println("Exception Occurred getLocalizedMessage: " + e.getLocalizedMessage() );// Exception Occurred getLocalizedMessage: / by zero
        } finally {
            System.out.println("This is the finally block");
            /*
            The finally block is always executed no matter whether there is an exception or not.
            The finally block is optional. And, for each try block, there can be only one finally block. But can be multiple Catch block.
             */
        }

        System.out.println("Final EXIT of MAIN function even after getting exception!!!");

        simpleTryCatchEx();
    }
}
