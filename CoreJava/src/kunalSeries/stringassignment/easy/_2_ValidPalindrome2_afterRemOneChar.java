package kunalSeries.stringassignment.easy;

// TODO : 680. Valid Palindrome II  -
// https://leetcode.com/problems/valid-palindrome-ii/description/
public class _2_ValidPalindrome2_afterRemOneChar {

    public static  boolean isPalindromeMyWay(String str){

        // checking null or empty string
        if (str==null || str.isBlank() || str.length()==1)
            return true; //  // String is either null or contains only whitespace

        int l = 0;
        int r = str.length()-1;
        int mismatchCharCounter = 0; // Tracking mismatches character
        while (l<=r){
            if (str.charAt(l) != str.charAt(r)) {
                mismatchCharCounter++;

                // If we already have more than one mismatch, return false
                if (mismatchCharCounter > 1) {
                    return false;
                }

                // Check by skipping one character: either from the left or right side
                // Skip the left character (l+1) or the right character (r-1)
                if (str.charAt(l + 1) == str.charAt(r)) {
                    l++; // Skip the left character
                } else if (str.charAt(l) == str.charAt(r - 1)) {
                    r--; // Skip the right character
                } else {
                    return false; // Neither option results in a palindrome
                }
            } else {
                l++;
                r--;
            }
        }
        return true;
    }


    public static boolean isPalindromeHelper(String str, int l, int r){

        while (l<=r){
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }


    public static  boolean isPalindromeMyWayImproved(String str){

        // checking null or empty string
        if (str==null || str.isBlank() || str.length()==1)
            return true; //  // String is either null or contains only whitespace

        int l = 0;
        int r = str.length()-1;

        while (l<=r){

            if (str.charAt(l) != str.charAt(r) ){
                /*
                The intuition behind checking the substring in the helper function after encountering a mismatch is based on the problem's requirement: you are allowed to delete at most one character from the string to make it a palindrome. The key observation here is that:
                    A palindrome is a string that reads the same backward as forward.
                    If you encounter a mismatch between two characters (e.g., str[l] != str[r]), you can potentially "remove" one of the characters (either str[l] or str[r]) and check if the remaining substring can form a palindrome.
                 */
                                      // skipping left pointer                    skipping right pointer character.
                return isPalindromeHelper(str, l+1, r) || isPalindromeHelper(str, l, r-1) ;  // we have already found one mismatch so basically here we are checking 2nd mismatch.
            }
            l++;
            r--;

        }

        return  true; // String is already a palindrome
        /*
        TODO: Time Complexity analysis
Main Loop:
    Runs O(n), where n is the length of the string.
Helper Function:
    In the worst case, it is called twice and processes up to O(n) characters.
Total: O(n)+2⋅O(n)=O(n).
         */
    }

    public static void main(String[] args) {
        String str = "nitin"; // true :
//        String str = "aba"; // true :
//        String str = "abca"; // true : You could delete the character 'c' or 'b'
//        String str = "deeee"; // true : You could delete the character 'd'
//        String str = "abc"; // false
//        String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"; // true
//        String str = "p"; // true
//        String str = " "; // true : string is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.

        System.out.println("\n My String: " + str);
        System.out.println("\n ***********  ***********");
        boolean mine = isPalindromeMyWay(str);
        boolean mineImproved = isPalindromeMyWayImproved(str);
        if (mine && mineImproved){
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
Why Check the Substring After a Mismatch?
   1- Nature of Palindromes:

        For a string to be a palindrome, each character must match its mirror counterpart (the character at the other end of the string).
        If you find a mismatch between str[l] and str[r], the assumption is that one of them might be extraneous and could be removed, making the rest of the string a palindrome.

   2- Two Possible Fixes:

    When a mismatch is found, you have two ways to fix the string:
            Skip the left character (str[l]) and check if the substring starting from l+1 to r is a palindrome.
            Skip the right character (str[r]) and check if the substring starting from l to r-1 is a palindrome.

   3-  Why Only Two Substrings?

    When you encounter a mismatch at positions l and r, you are essentially testing two possibilities:
            If removing the left character (str[l]) results in a palindrome.
            If removing the right character (str[r]) results in a palindrome.
    The idea is that if either of these substrings (after one deletion) is a palindrome, you have successfully fixed the string by removing at most one character, which meets the problem's requirement.
    If both of these substrings are not palindromes, then it's not possible to make the string a palindrome by removing just one character.

 */