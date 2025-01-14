package kunalSeries.basics.concepts.exceptionHandlingFromEngDigest;

public class _1_introWithExample {
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
    }
}
