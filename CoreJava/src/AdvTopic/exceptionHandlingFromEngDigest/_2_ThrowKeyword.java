package kunalSeries.basics.concepts.exceptionHandlingFromEngDigest;

// TODO: The throw statement allows you to create a custom error.
// REF: https://www.geeksforgeeks.org/throw-throws-java/?ref=lbp
// https://www.javatpoint.com/throw-keyword

/*
VERY IMP:
* **THROW:** Stops the current flow of execution immediately.
* **THROWS:** It forces the caller to handle the declared exceptions.
* **throw** keyword mostly used for `custom/user-defined exception` because you won't see any difference if you will use with predefined exception classes.[ watch for more-00:20:00 hrs](https://www.youtube.com/watch?v=vldtYXFmZSc&list=PLlhM4lkb2sEjaU-JAASDG4Tdwpf-JFARN&index=10)

 */

/*
The throw statement is used together with an exception type. There are many exception types available in Java:
    ArithmeticException, FileNotFoundException, ArrayIndexOutOfBoundsException, SecurityException, etc
-> This will stop the program at this point and throw a meaningful customize msg to track the error and type easily.
 */


// Throwing User-defined Exception
// this class represents user-defined exception
class UserDefinedException extends Exception {
            // Extending Exception - so that we can use super(msg) and will print meaningful msg.
                // It's better to use RuntimeException for unchecked and for Check use Exception.
                // ultimately RuntimeException extends Exception.
    // constructor
    public  UserDefinedException (String str){
        // Calling constructor of parent Exception
        super(str);
    }
}


public class _2_ThrowKeyword {
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
            checkAgeAndThrowKeyword(age);
            /* OUTPUT: if age < 18
            Exception in thread "main" java.lang.ArithmeticException: Access denied - You must be at least 18 years old.
                at kunalSeries.basics.concepts.exceptionHandlingFromEngDigest._2_ThrowKeyword.checkAgeAndThrowKeyword(_2_ThrowKeyword.java:17)
                at kunalSeries.basics.concepts.exceptionHandlingFromEngDigest._2_ThrowKeyword.main(_2_ThrowKeyword.java:44)

        IT WILL STOP THE FLOW - SO to handle it, try to keep checkAgeAndThrowKeyword in try-catch (used in Enterprise application) like we did in fun() function.

             */
            String s="abc"; // Initializing a String with non-numeric characters
            numberFormatException(s);
                                        /*Alphabet string can't be parsed into Int. Exception msg: For input string: "abc"
                                            Error: Unable to parse the string as an integer.*/

    // 3rd throw keyword example:
        /*
        The flow of execution of the program stops immediately after the throw statement is executed and the nearest enclosing try block is checked to see
        if it has a catch statement that matches the type of exception. If it finds a match, controlled is transferred
        to that statement otherwise next enclosing try block is checked, and so on. If no matching catch is found then
        the default exception handler will halt the program.
         */
        try {
            fun();
            System.out.println("Code after fun() function call..");
        }
        catch (NullPointerException e) {
            System.out.println("Caught in main.");
        }
        /*
        OUTPUT:
        Caught inside fun().
        Caught in main.
         */


        // Throwing User-defined Exception
        try{
           // throw an object of user defined exception
            throw  new UserDefinedException("This is user defined exception msg from throw keyword!! ");
        } catch (UserDefinedException ude){
            System.out.println("Caught the exception in catch block UserDefinedException .");
            // Print the message from MyException object
            System.out.println("Msg from user defined exception using e.getMsg() ->    "  +ude.getMessage());
            /*
            OUTPUT:
            Caught the exception in catch block UserDefinedException .
            Msg from user defined exception using e.getMsg() ->    This is user defined exception msg from throw keyword!!
            THROWS CUSTOM user defined Exception and handled as well. It won't break the whole flow since handled.
             */

        }
    }
}