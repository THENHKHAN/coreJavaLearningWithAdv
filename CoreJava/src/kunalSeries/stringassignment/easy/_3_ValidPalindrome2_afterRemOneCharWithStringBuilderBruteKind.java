package kunalSeries.stringassignment.easy;

// TODO : 680. Valid Palindrome II  -
// https://leetcode.com/problems/valid-palindrome-ii/description/
// it just as 2ns but here space and time more. So Just like Brute
public class _3_ValidPalindrome2_afterRemOneCharWithStringBuilderBruteKind {

    public static boolean isPalindromeHelper(String str, int l, int r){
        while (l<=r){
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }


    public static  boolean isPalindromeBruteStringBuilder(String str){

        // checking null or empty string
        if (str==null || str.isBlank() || str.length()==1)
            return true; //  // String is either null or contains only whitespace

        // Check if the original string is already a palindrome
        if (isPalindromeHelper(str, 0, str.length()-1)) {
            return true;
        }

        // Try removing one character at a time and check if the resulting string is a palindrome
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(i);  // Remove the character at index i
            String subStr = sb.toString();
            if (isPalindromeHelper(subStr, 0, subStr.length()-1)) {
                return true; // If the new string is a palindrome, return true
            }
        }

        // If no palindrome is found after removing one character, return false
        return false;
    }

    public static void main(String[] args) {
        String str = "nitin"; // true :
//        String str = "aba"; // true :
//        String str = "abca"; // true : You could delete the character 'c' or 'b'
//        String str = "deeee"; // true : You could delete the character 'd'
//        String str = "abc"; // false
//        String str = "p"; // true
//        String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"; // true
//        String str = " "; // true : string is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.

        System.out.println("\n My String: " + str);
        System.out.println("\n ***********  ***********");
        boolean mineBruteStringBuilder = isPalindromeBruteStringBuilder(str);
        if (mineBruteStringBuilder){
            System.out.println("YES, Palindrome string ");
        } else {
            System.out.println("NO, not a Palindrome string ");
        }

    }
}

// Statement:
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 */
// TODO improved my logic with helper function :
/*
Helper Function (isPalindrome):
    This function checks if a given string is a palindrome by comparing characters from both ends, moving inward.
Main Function (validPalindrome):
    First, it checks if the original string is already a palindrome.
    Then, it generates all possible substrings by removing one character at a time (using deleteCharAt(i) from StringBuilder).
    For each of these substrings, it checks if it's a palindrome using the isPalindrome function.
    If any of the substrings is a palindrome, it returns true; otherwise, it returns false.

Time Complexity:
Generating Substrings:
    For each character in the string, you are generating a new substring by removing that character.
    This results in n substrings, where n is the length of the string.

Checking Palindromes:
    For each substring, you need to check if it is a palindrome. Checking if a string of length m is a palindrome
    takes O(m), where m is the length of the substring.
    In the worst case, the length of each substring is n−1, so checking each substring for palindrome takes O(n).
 Total Time Complexity:
    For n substrings, each palindrome check takes (𝑛) so the total time complexity is: O(n^2)
            This is because you generate n substrings and check each one for palindrome property,
                where each check takes O(n).

Space Complexity:
    StringBuilder: For each iteration, a new StringBuilder object is created to store the substring, so the space complexity is
        O(n)  for each substring generation.
    Total Space Complexity: Since we only create one substring at a time, the overall space complexity is
    O(𝑛).

Brute Force Approach - Summary:
    The brute force approach works by generating all substrings that result from removing one
        character and checking each of them for being a palindrome.
    It is simple and works correctly but is inefficient with a time complexity of O(n^2)




 */