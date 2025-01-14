package kunalSeries.basics.concepts.exceptionHandlingFromEngDigest;

// TODO: The throw statement allows you to create a custom error.
// REF: https://www.geeksforgeeks.org/throw-throws-java/?ref=lbp
/*
The throw statement is used together with an exception type. There are many exception types available in Java:
    ArithmeticException, FileNotFoundException, ArrayIndexOutOfBoundsException, SecurityException, etc
-> This will stop the program at this point and throw a meaningful customize msg to track the error and type easily.
 */



public class _2_ThrowAndThrowsKeyword {
// Throw an exception if age is below 18 (print "Access denied"). If age is 18 or older, print "Access granted":
public static void checkAgeAndThrowKeyword(int age){
        if (age<18){

            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        }else{
        System.out.println("Access granted - You are old enough!");
    }
}

public static void numberFormatException(String str){
    try {
        int i=Integer.parseInt(str);//NumberFormatException
        System.out.println("No exception , String in number : " + i);
    } catch (NumberFormatException e){
        System.out.println("Alphabet string can't be parsed into Int. Exception msg: " + e.getMessage());
        System.out.println("Error: Unable to parse the string as an integer.");
    }
}

public static void fun() {
        try {
            throw new NullPointerException("demo"); // since this is in try block hence won't stop the execution since handled in the Catch block
        }
        catch (NullPointerException e) {
            System.out.println("Caught inside fun().");
            throw e;     // rethrowing the exception. This means we are throwing the exception from here to main() catch block.
        }
    }
    public static void main(String[] args) {
            int age = 10;
//            checkAgeAndThrowKeyword(age);
            String s="abc"; // Initializing a String with non-numeric characters
//            numberFormatException(s);

    // 3rd throw keyword example:
        /*
        The flow of execution of the program stops immediately after the throw statement is executed and the nearest enclosing try block is checked to see
        if it has a catch statement that matches the type of exception. If it finds a match, controlled is transferred
        to that statement otherwise next enclosing try block is checked, and so on. If no matching catch is found then
        the default exception handler will halt the program.
         */
        try {
            fun();
        }
        catch (NullPointerException e) {
            System.out.println("Caught in main.");
        }
    }
}
/*
if age < 18

Exception in thread "main" java.lang.ArithmeticException: Access denied - You must be at least 18 years old.
	at kunalSeries.basics.concepts.exceptionHandlingFromEngDigest._2_ThrowAndThrowsKeyword.checkAgeAndThrowKeyword(_2_ThrowAndThrowsKeyword.java:15)
	at kunalSeries.basics.concepts.exceptionHandlingFromEngDigest._2_ThrowAndThrowsKeyword.main(_2_ThrowAndThrowsKeyword.java:23)
 */