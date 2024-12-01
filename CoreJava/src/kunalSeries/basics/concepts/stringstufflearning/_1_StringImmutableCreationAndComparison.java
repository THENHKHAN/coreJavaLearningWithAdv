package kunalSeries.basics.concepts.stringstufflearning;

//   TODO: Kunal :https://www.youtube.com/watch?v=zL1DPZ0Ovlo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=21
// read me if want to explore more

public class _1_StringImmutableCreationAndComparison {
    public static void main(String[] args) {
        String str1 = "Noorul Huda Khan"; // immutable string. It resides in the string pool are in the Heap. For more read Readme.md in it parent package.
        String str2 = "Noorul Huda Khan"; // Since value is same hence str2 will also point to the same object as str1.
        String myStr3 = "Noorul huda Khan"; // with small h
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("myStr3: " + myStr3);

        // for checking whether they are pointing to the same object or not
        // we use == operator and not s1.equals(s2). Since == compares the value as well as references but equals only values.
        if (str1==str2) // true
            System.out.println("str1 and str2 are pointing to the same object!! ");
        else
            System.out.println("str1 and str2 are NOT pointing to the same object!!");

        // comparing case sensitivity
        System.out.println("\n Comparing case sensitivity with == operator .....");
        if (str1==myStr3) // false - since it compare case sensitivity as well
            System.out.println("str1 and myStr3 are pointing to the same object!! ");
        else
            System.out.println("str1 and myStr3 are NOT pointing to the same object!!");


        // case -2 with new keyword
        System.out.println("\n\n .............. with new keyword.............");

        String str3 = new String("Noorul Huda"); // immutable string. It resides OUTSIDE the String pool But withing the HEAP. For more read Readme.md in it parent package.
        String str4 = new String("Noorul Huda"); // new keyword always create new objects
        String str5 = new String("Hello Noor");
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);
        System.out.println("str5: " + str5);

        System.out.println("\n .............. with new keyword  & comparing with equals() method.............");

        if (str3.equals(str4)) // true - since value is same: It only compares with values(i.e. object)
            System.out.println("str1 and myStr3 are pointing to the same object!! ");
        else
            System.out.println("str1 and myStr3 are NOT pointing to the same object!!");


        System.out.println("\n .............. with new keyword  & comparing with == Operator.............");

        if (str3==str4) // false - since value is same But Reference is different: It only compares with values as well references of object.
            System.out.println("str1 and myStr3 are pointing to the same object!! ");
        else
            System.out.println("str1 and myStr3 are NOT pointing to the same object!!");


        // .compareTo(): Compares lexicographically : Compares strings based on Unicode values of characters.
        System.out.println("\n.compareTo() Comparison:");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // 0: str1 is equal to str2
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // 0: str1 is lexicographically equal to str3
        System.out.println("str1.compareTo(str4): " + str1.compareTo(str4)); // negative: "Hello" comes before "World"
        System.out.println("str4.compareTo(str1): " + str4.compareTo(str1)); // positive: "World" comes after "Hello"
      /*
      Use .compareTo() when you need to compare objects or strings for sorting or ordering (e.g., sorting names,
      numbers, or custom objects).
       */



    }
}
// for more
/*


  // Using string literals
        String str1 = "Hello";
        String str2 = "Hello";

        // Using new String() - forces creation of new objects in heap
        String str3 = new String("Hello");
        String str4 = new String("World");

        // == comparison: Checks memory address (reference)
        System.out.println("== Comparison:");
        System.out.println("str1 == str2: " + (str1 == str2)); // true: both refer to the same literal in the String Pool
        System.out.println("str1 == str3: " + (str1 == str3)); // false: str3 is a new object in the heap
        System.out.println("str3 == str4: " + (str3 == str4)); // false: different objects in the heap

        // .equals(): Checks for content equality
        System.out.println("\n.equals() Comparison:");
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true: same content
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true: same content
        System.out.println("str3.equals(str4): " + str3.equals(str4)); // false: different content

        // .compareTo(): Compares lexicographically
        System.out.println("\n.compareTo() Comparison:");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // 0: str1 is equal to str2
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // 0: str1 is lexicographically equal to str3
        System.out.println("str1.compareTo(str4): " + str1.compareTo(str4)); // negative: "Hello" comes before "World"
        System.out.println("str4.compareTo(str1): " + str4.compareTo(str1)); // positive: "World" comes after "Hello"

 */