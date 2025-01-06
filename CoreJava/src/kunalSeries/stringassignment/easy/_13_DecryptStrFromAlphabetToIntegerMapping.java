package kunalSeries.stringassignment.easy;

// TODO: 1309. Decrypt String from Alphabet to Integer Mapping
// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/description/
// REF: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/solutions/3663734/simple-java-runtime-100-memory-98-43/
// REF2 - https://algo.monster/liteproblems/1309
// https://www.reddit.com/r/leetcode/comments/1162p7c/1309_decrypt_string_from_alphabet_to_integer/
// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/solutions/6156082/effortless-decoding-map-strings-to-alphabets-in-linear-time/
// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/solutions/500231/hashmap-solution-java/

import java.util.HashMap;
public class _13_DecryptStrFromAlphabetToIntegerMapping {

    public String freqAlphabetsBrute(String s) {
        StringBuilder result = new StringBuilder(); // This will hold the decoded string
        int i = 0; // Index to traverse through the string

        // Iterate through the entire string
        while (i < s.length()) {
            // Case 1: Check if the next two characters are followed by '#'
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                // Extract the two digits number
                int num = Integer.parseInt(s.substring(i, i + 2));
                // Map the number to corresponding character (e.g., 10 -> 'j', 26 -> 'z')
                result.append((char) (num + 'a' - 1)); // 'a' in Java is a character with an ASCII value of 97. 'a' - 1 gives 96
               // When you add num to 'a' - 1, you are essentially converting the number to the correct ASCII value for the corresponding letter:
                // If num = 1, the result is 97 (which is 'a' in ASCII). ex-2 - If num = 26, the result is 122 (which is 'z' in ASCII).
                // (char): The (char) cast converts the resulting ASCII value back into a character.
                i += 3; // Skip past the two digits and '#'
            } else {
                // Case 2: It's a single digit, map it to 'a' to 'i'
                int num = s.charAt(i) - '0'; // Convert character to integer
                // s.charAt(i) gets the character at the current position i in the string.
                // '0' is the character representing the number zero, with an ASCII value of 48.
                // When you subtract '0' from the character at s.charAt(i), you're essentially converting a numeric character (e.g., '1', '2', etc.) to its corresponding integer value:
                // EX-1 : If s.charAt(i) is '3', then '3' - '0' gives 3. EX-2 : If s.charAt(i) is '5', then '5' - '0' gives 5.
                // This line essentially converts a character representing a number to an actual integer.
                result.append((char) (num + 'a' - 1)); // Map the number to corresponding character
                i += 1; // Move to the next character
            }
        }

        // Convert the StringBuilder result to a String and return it
        return result.toString();
        // the time complexity of this algorithm is O(n), where n is the length of the input string.
        /*
        The space complexity of the solution is dominated by the storage used to build the result string.

The result is stored in a StringBuilder, which grows as the decoded characters are appended. In the worst case, the result string's length will be proportional to the input string's length (if every character or group of characters in the input corresponds to one letter).
Therefore, the space complexity is O(n), where n is the length of the input string.
         */
    }

    public String freqAlphabetsOptizedLittle(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = s.length()-1; i >= 0; i--) {
            int number;
            if(s.charAt(i) == '#') { // If it is a two-digit number
                number = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
                i-=2;
            } else { // If it is a single-digit number
                number = s.charAt(i) - '0';
            }
            // Convert the numeric value to its alphabetic representation
            sb.append((char) (number + 96));
        }

        return sb.reverse().toString();
    }

    public String freqAlphabetsTwoPointer(String s) {
        char[] result = new char[s.length()];
        int index = 0;
        int i = 0;

        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                result[index++] = (char) (num + 'a' - 1);
                i += 3; // Skip the two digits and '#'
            } else {
                int num = s.charAt(i) - '0';
                result[index++] = (char) (num + 'a' - 1);
                i++; // Move to the next character
            }
        }

        return new String(result, 0, index); // Convert char[] back to string
    }

    /*
    Two-Pointer Approach:

Time Complexity: O(n)
Space Complexity: O(n)
Pros: Uses direct array manipulation, potentially more memory efficient.
Cons: Slightly more complex code structure.
     */


    public String freqAlphabetsHashMap(String s) {
        HashMap<String, Character> map = new HashMap<>();
        // Fill the map for single digits and two-digit numbers
        for (int i = 1; i <= 9; i++) {
            map.put(String.valueOf(i), (char) (i + 'a' - 1));
        }
        for (int i = 10; i <= 26; i++) {
            map.put(i + "#", (char) (i + 'a' - 1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                result.append(map.get(s.substring(i, i + 3)));
                i += 3;
            } else {
                result.append(map.get(String.valueOf(s.charAt(i))));
                i++;
            }
        }
        return result.toString();
    }
    /*
    Hash Map Approach:
Time Complexity: O(n)
Space Complexity: O(1)
Pros: Simplifies mapping and decoding logic.
Cons: Unnecessary overhead for small inputs (since you only need to map 26 characters).
     */

    public static void main(String[] args) {

        _13_DecryptStrFromAlphabetToIntegerMapping obj = new _13_DecryptStrFromAlphabetToIntegerMapping();
        System.out.println("-------------------TEST-1-------------------------------");
        String str = "10#11#12";
        System.out.println("Provide StringArr1 : " + str);
        System.out.println("Decrypt String  : " + obj.freqAlphabetsBrute(str));// "jkab"
        System.out.println("Decrypt String Little optimized: " + obj.freqAlphabetsOptizedLittle(str));


        System.out.println("-------------------TEST-2-------------------------------");
        String str2 = "1326#";
        System.out.println("Provide String2 : " + str2);
        System.out.println("Decrypt String  : " + obj.freqAlphabetsBrute(str2)); // "acz"
        System.out.println("Decrypt String Little optimized: " + obj.freqAlphabetsOptizedLittle(str2));
    }
}

// Explain : (char) (num + 'a' - 1) . lets case: num = 10, so the formula becomes (char) (10 + 'a' - 1), which is equivalent to (char) (10 + 96) (since 'a' has an ASCII value of 97).
//This results in the character 'j'. The index i is incremented by 3 (i += 3), skipping past "10#".
/*
Example 1:
Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

Example 2:
Input: s = "1326#"
Output: "acz"
 */