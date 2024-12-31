package kunalSeries.stringassignment.easy;

import java.util.Arrays;
// TODO: 709. To Lower Case
// https://leetcode.com/problems/to-lower-case/description/

public class _11_ToLowerCase {


    public String toLowerCase0(String s) {
        return s.toLowerCase();
    }

    // For each character, if it lies between 'A' and 'Z' (uppercase), we add 32 to convert it to the lowercase version.
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // If the character is uppercase (between 'A' and 'Z')
            if (c >= 'A' && c <= 'Z') {
                // Convert it to lowercase by adding 32 to the ASCII value
                result.append((char) (c + 32));
            } else {
                // If it's already lowercase or a non-alphabet character, keep it the same
                result.append(c);
            }
        }

        // Return the resulting string after conversion
        return result.toString();
        // The time complexity of this solution is O(n), where n is the length of the string, since we are iterating through each character once.
    }

    public String toLowerCase2(String s) {
        StringBuilder result = new StringBuilder();

        // Iterate over each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is an uppercase letter (between 'A' and 'Z')
            if (c >= 'A' && c <= 'Z') {
                // Convert it to lowercase by adding 32 to its ASCII value
                result.append((char)(c + 32));
            } else {
                // If it's already lowercase or a non-alphabet character, keep it the same
                result.append(c);
            }
        }

        // Return the resulting string after conversion
        return result.toString();
        /*
        The time complexity is O(n), where n is the length of the string because we iterate over each character once.
        The space complexity is O(n) because we use a StringBuilder to store the result, which grows with the length of the input string.

         */
    }

    public static void main(String[] args) {

        _11_ToLowerCase obj = new _11_ToLowerCase();
        System.out.println("-------------------TEST-1-------------------------------");
        String str = "Hello";
        System.out.println("Provide StringArr2 : " + str);
        System.out.println("Lower Case of above String : " + obj.toLowerCase(str));
        System.out.println("Other way : " + obj.toLowerCase(str));

    }
}

// TODO: Some observation :
/*
 In ASCII, the difference between the uppercase letters ('A' to 'Z') and their corresponding lowercase counterparts ('a' to 'z') is exactly 32. This means you can convert an uppercase letter to its lowercase equivalent by adding 32 to its ASCII value.
 Explanation:
    The ASCII value for 'A' is 65, and for 'a' it is 97. The difference is 32.
    If we take any uppercase letter and add 32 to its ASCII value, we get the corresponding lowercase letter.

 */