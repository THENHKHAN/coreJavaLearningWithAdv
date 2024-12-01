package kunalSeries.basics.concepts.stringstufflearning;

//   TODO: Kunal :https://www.youtube.com/watch?v=zL1DPZ0Ovlo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=21   TS- 01:12:00
// // read me if want to explore more

import java.util.Arrays;

public class _3_SomeUsefulMethods {
    public static void main(String[] args) {
        // String to char array
        String name = "Noorul Huda";
        char[] charArr = name.toCharArray();
        System.out.println("String : " + name);
        System.out.println("String to CharArray : " + Arrays.toString(charArr));//[N, o, o, r, u, l,  , H, u, d, a]

        // String to StringBuilder - then change N to n in the name
        StringBuilder strB = new StringBuilder(name);
        strB.setCharAt(0, 'n');
        System.out.println("String : " + name); //Noorul Huda   actual string not changed since immutable
        System.out.println("StringBuilder : " + strB); // noorul Huda
        // lets add Khan in the stringBuilder
        strB.append(" Khan");
        System.out.println("StringBuilder Modified  : " + strB); // noorul Huda Khan




    }
}

// for more
/*
Summary:
        String: Immutable, better for unchanging text or light modifications.
        StringBuilder: Mutable, ideal for heavy or frequent modifications.
        Use StringBuilder for efficiency in scenarios involving repetitive operations or large-scale modifications.


 Some Basic Operation & functions:

  // Initialize a StringBuilder with some text
   StringBuilder sb = new StringBuilder("Hello");

        // Display the original content
        System.out.println("Original StringBuilder: " + sb);
        // Output: Hello

        // 1. Append text to the StringBuilder
        sb.append(" World");
        System.out.println("After append: " + sb);
        // Output: Hello World

        // 2. Insert text at a specific index
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb);
        // Output: Hello Beautiful World
        // The string "Beautiful " is inserted at index 6.


        // 3. Replace a portion of the string
        sb.replace(6, 15, "Amazing");
        System.out.println("After replace: " + sb);
        // Output: Hello Amazing World
        // The text from index 6 to 15 ("Beautiful") is replaced with "Amazing".


        // 4. Delete a portion of the string
        sb.delete(6, 13);
        System.out.println("After delete: " + sb);
        // Output: Hello World
        // The text from index 6 to 13 ("Amazing") is deleted.

        // 5. Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb);
        // Output: dlroW olleH

        // 6. Get a character at a specific index
        char ch = sb.charAt(4);
        System.out.println("Character at index 4: " + ch);
        // Output: o

        // 7. Get a substring from the StringBuilder
        String sub = sb.substring(3, 8);
        System.out.println("Substring (index 3 to 8): " + sub);
        // Output: roW o
        // Extracts characters from index 3 (inclusive) to 8 (exclusive).

        // 8. Get the current length
        int length = sb.length();
        System.out.println("Length of StringBuilder: " + length);
        // Output: 11

        // 9. Get the current capacity
        int capacity = sb.capacity();
        System.out.println("Capacity of StringBuilder: " + capacity);
        // Output: Default 16 + original string length (varies based on initial string)
        // Default capacity is 16 plus the length of the initial string, but it grows dynamically when needed.
        // length : it the total number of character present.

 */
