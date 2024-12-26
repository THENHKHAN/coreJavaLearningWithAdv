package kunalSeries.stringassignment.easy;

import java.util.ArrayList;
import java.util.Arrays;

// TODO:  1662. Check If Two String Arrays are Equivalent
// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/solutions/6143632/0-ms-beats-100-java-solution/
// For ref : https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/solutions/6178200/o-n-solution/
// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/solutions/6146838/stringbuilder-easy/
public class _10_CheckTwoStrArrEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Suppose word1 has a total of n1 characters and word2 has n2 characters.
        String str1 = String.join("", word1); // O(n1)
        System.out.println("Str1 : " + str1);
        String str2 = String.join("", word2); // O(n2)
        System.out.println("Str2 : " + str2);

        return str1.equals(str2);
        // Then, str1.equals(str2) compares the two resulting strings, which also takes O(max(n1, n2)).
        /*
 the total time complexity is O(n1 + n2), where n1 is the total number of characters in word1 and n2 is the total number of characters in word2.
 SPACE:
 You are creating two new strings str1 and str2, which require O(n1) and O(n2) space, respectively, to hold the concatenated strings.
 Therefore, the space complexity is O(n1 + n2) due to the extra space required for the two concatenated strings.


         */
    }


    // Instead of creating two new strings, you can compare the arrays directly without concatenating them into strings. This way, we avoid the overhead of creating additional string objects.
    // We can iterate over both arrays (word1 and word2) and compare the characters directly, without needing to create full concatenated strings.
    public boolean arrayStringsAreEqualOptimized(String[] word1, String[] word2) {

        int word1pointer = 0, word2pointer = 0;
        int word1Strpointer = 0, word2Strpointer = 0;

        // Loop until both word1 and word2 are exhausted
       while (word1pointer<word1.length && word2pointer<word2.length){

           // Compare current characters in word1 and word2
           if (word1[word1pointer].charAt(word1Strpointer) != word2[word2pointer].charAt(word2Strpointer)){
               return false;
           }

           // for word1
           if (word1Strpointer+1<word1[word1pointer].length()) { // // Move to the next character in word1
               word1Strpointer++; // next character of string
           } else {
               word1pointer++; // Move to the next string in word1
               word1Strpointer = 0 ;// Reset character position for the new string. oth index of the next string
           }


           // for word2
           if (word2Strpointer+1<word2[word2pointer].length()){
               word2Strpointer++; // next character of string
           } else{
               word2pointer++;  // Move to the next string in word2
               word2Strpointer = 0;  // Reset character position for the new string
           }

       }

// Both arrays should be fully traversed
        return word1pointer == word1.length && word2pointer == word2.length;

        /*
Time Complexity:
        We are iterating over the characters of both arrays once.
        Therefore, the time complexity is still O(n1 + n2) where n1 and n2 are the total number of characters in word1 and word2.

Space Complexity:
        The space complexity is optimized to O(1) because no new strings are being created. We are only using a few extra variables (i, j, m, n), which take constant space.

       Old  Original solution: Time complexity is O(n1 + n2), but space complexity is O(n1 + n2) due to the concatenated strings.
       This Optimized solution: Time complexity is O(n1 + n2), and space complexity is O(1) because it doesn't create any new strings. This is the more space-efficient approach.
         */
    }

    public static void main(String[] args) {
        _10_CheckTwoStrArrEquivalent obj = new _10_CheckTwoStrArrEquivalent();
        System.out.println("-------------------TEST-1-------------------------------");
        String[] strArr1 = {"ab", "c"};
        String[] strArr2 = {"a", "bc"};
        System.out.println("Provide StringArr1 : " + Arrays.toString(strArr1));
        System.out.println("Provide StringArr2 : " + Arrays.toString(strArr1));
        System.out.println("Check If Two String Arrays are Equivalent : " + obj.arrayStringsAreEqual(strArr1, strArr2));
        System.out.println("Check If Two String Arrays are Equivalent OPTIMIZED : " + obj.arrayStringsAreEqualOptimized(strArr1, strArr2));

        System.out.println("\n-------------------TEST-1-------------------------------");
        String[] strArr11 = {"a", "cb"};
        String[] strArr22 = {"ab", "c"};
        System.out.println("Provide strArr11 : " + Arrays.toString(strArr11));
        System.out.println("Provide strArr22 : " + Arrays.toString(strArr22));
        System.out.println("Check If Two String Arrays are Equivalent : " + obj.arrayStringsAreEqual(strArr11, strArr22));
        System.out.println("Check If Two String Arrays are Equivalent OPTIMIZED : " + obj.arrayStringsAreEqualOptimized(strArr11, strArr22));

        System.out.println("\n-------------------TEST-1-------------------------------");
        String[] strArr13 = {"abc", "d", "defg"};
        String[] strArr24 = {"abcddefg"};
        System.out.println("Provide strArr13 : " + Arrays.toString(strArr13));
        System.out.println("Provide strArr24 : " + Arrays.toString(strArr24));
        System.out.println("Check If Two String Arrays are Equivalent : " + obj.arrayStringsAreEqual(strArr13, strArr24));
        System.out.println("Check If Two String Arrays are Equivalent OPTIMIZED : " + obj.arrayStringsAreEqualOptimized(strArr13, strArr24));

    }
}
// TODO- Space and Time Complexity Analysis

/*
Time Complexity :
   the total time complexity is O(n1 + n2), where n1 is the total number of characters in word1 and n2 is the total number of characters in word2.

 */


/*

Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.


Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

Example 2:
Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Example 3:
Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true


 */
