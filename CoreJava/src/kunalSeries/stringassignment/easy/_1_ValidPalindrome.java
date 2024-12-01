package kunalSeries.stringassignment.easy;

// TODO : 125. Valid Palindrome  -
public class _1_ValidPalindrome {

    public static  boolean isPalindrome(String str){

        // checking null or empty string
//        if (str==null || str.trim().isEmpty())
        if (str==null || str.isBlank())
            return true; //  // String is either null or contains only whitespace

        // lets remove the non-alphanumeric
        str = str.replace(" ", "").toLowerCase(); // O(n)+O(n)=O(n) -to optimize - we can skip this part bcz we already covery with  isLetterOrDigit
        System.out.println("After replacing and trimming New Str : " + str); // aman,aplan,acanal:panama  , 2- raceacar
        int l = 0;
        int r = str.length()-1;
            // you can optimize further to avoid the extras pace for trim and replace using nested while loop (it will run once just like if else condition ) so in that case
                // TC:O(n) & SC: O(1)
        // BUT currently - TC:O(n) & SC: O(n)
        while (l<r){

            if (!Character.isLetterOrDigit(str.charAt(l))) // skipping the non-alphabetic character at LEFT index
                l++;
            else if (!Character.isLetterOrDigit(str.charAt(r)))  // skipping the non-alphabetic character at RIGHT index
                r--;
            else {   // if valid character (i.e. alphanumeric character)
                if (str.charAt(l) != str.charAt(r)) // comparing left pointer with right pointer character. If not equal then non palindrome.
                    return false;
                else {
                    l++;
                    r--;
                }
            }

        }

        return true;
    }
    public static void main(String[] args) {
//        String str = "nitin"; // true :
//        String str = "A man, a plan, a canal: Panama"; // true : "amanaplanacanalpanama" is a palindrome.
//        String str = "race a car"; // false : "raceacar" is not a palindrome.
        String str = " "; // true : string is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.

        System.out.println("\n My String: " + str);
        System.out.println("\n ***********  ***********");
        if (isPalindrome(str)){
            System.out.println("YES, Palindrome string ");
        } else {
            System.out.println("NO, not a Palindrome string ");
        }

    }
}

// Statement:
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
    it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

That's means we have manage - case sensitivity, non-alphanumeric(spaces , ;, :,  special character etc..),


 Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

 */


/*

Time Complexity:
    str.replace(" ", "").toLowerCase():

    str.replace: Traverses the entire string once to replace spaces. This is O(n), where n is the length of the string.
    str.toLowerCase: Traverses the string once to convert characters to lowercase. This is also O(n).
    Combined:O(n)+O(n)=O(n).
while (l < r) loop:

    Each iteration of the loop performs constant time operations (like character comparisons or pointer adjustments).
    The loop runs approximately n/2 iterations in the worst case (comparing characters from both ends), which is O(n).
    Total time complexity:O(n).

Space Complexity:
    String modifications:

    The str.replace and str.toLowerCase operations create a new string.
    This takes O(n) additional space for the new string.
    Pointer Variables:

        l and r use constant space O(1).
        Total space complexity:O(n), dominated by the creation of the modified string.

Optimized Analysis:
If you aim to optimize the space complexity:

Instead of creating a new string with replace and toLowerCase, process the original string directly while skipping non-alphanumeric characters and converting characters to lowercase on the fly. This approach reduces space complexity to O(1).
Final Complexity:
    Time Complexity:O(n).
    Space Complexity: O(n) (or 𝑂(1) with further optimization) i.e without using replace and trim.

HERE IS HOW??? - Even though the inner loops are nested, they don’t cause the same pointer to backtrack or restart. Thus, every character is processed exactly once by either l or r.
class Solution {
    public boolean isPalindrome(String str) {
        if (str == null) return false; // Null check

        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            // Skip non-alphanumeric characters on the left
            while (l < r && !Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            }

            // Skip non-alphanumeric characters on the right
            while (l < r && !Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            }

            // Compare the characters in a case-insensitive manner
            if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))) {
                return false; // Not a palindrome
            }

            // Move the pointers closer to the center
            l++;
            r--;
        }

        return true; // The string is a palindrome
    }
}
Summary:
Time Complexity:O(n), as each character is processed at most once.
Space Complexity: O(1), as no additional space is used.
 */