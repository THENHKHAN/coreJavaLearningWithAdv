package javaGeneric.GenericMethod;


//TODO: Generic functions
/*
We can also write generic functions that can be called with different types of arguments based
on the type of arguments passed to the generic method. The compiler handles each method.
 */

public class learnGenFunc {

    // A Generic method example
    static <T> void genericDisplay( T element){
        System.out.println(element.getClass().getName() + " = " + element);
    }

    public static void main(String[] args) {

        // Calling generic method with Integer argument
        genericDisplay(11); // java.lang.Integer = 11

        // Calling generic method with String argument
        genericDisplay("Noorul"); // java.lang.String = Noorul

        // Calling generic method with double argument
        genericDisplay(34.77); // java.lang.Double = 34.77

    }
}
