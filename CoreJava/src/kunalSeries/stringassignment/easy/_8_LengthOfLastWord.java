package kunalSeries.stringassignment.easy;

// TODO:  58. Length of Last Word
// https://leetcode.com/problems/length-of-last-word/description/
// ref: https://leetcode.com/problems/length-of-last-word/solutions/4954087/97-43-easy-solution-with-explanation/
public class _8_LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        s = s.stripTrailing();// remove only trailing spaces and not the leading.
        int n = s.length(); // since after removing trailing now this will be our new string
        int countChar = 0;
        for (int i = n-1 ; i >= 0; i--) {
            if (s.charAt(i) == ' ') // whenever we encounter end of the last word
                break;
            else
                countChar++;
        }

        return countChar;
    }

    public int lengthOfLastWordNoExtraSpace(String s) {
        int n = s.length();
        int countChar = 0;
        for (int i = n-1 ; i >= 0; i--) {
           if (s.charAt(i) != ' ')
               countChar++;
           else if (countChar>0){ // this will run only if the all the character traversed of last word in string.
               break;
           }
        }

        return countChar;
    }



    public static void main(String[] args) {
        _8_LengthOfLastWord obj = new _8_LengthOfLastWord();
        String str = "Hello World";
        System.out.println("My Provide String : " + str);
        System.out.println("Length of Last Word : " + obj.lengthOfLastWord(str));

    }
}

/*
A word is a maximal substring consisting of non-space characters only.

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

 */

//TODO:  Space Complexity & Time Complexity::
/*
s = s.stripTrailing(); creates a new string (after stripping the trailing spaces). This consumes additional space equal to the length of the string, i.e., O(n).
No additional data structures are used beyond simple integer variables, so the space complexity is O(n) due to the string copy created by stripTrailing().

Time :

-> s.stripTrailing(): This removes trailing spaces, which takes O(n) time where n is the length of the string.
-> The for loop iterates over the string from the end to the beginning, which takes O(n) in the worst case (if the last word is the only one in the string).
-> Thus, the overall time complexity is O(n).
 */
// todo: lengthOfLastWordNoExtraSpace
/*
space:
No extra space is used except for a few integer variables (countChar and i), so the space complexity is O(1), which is constant.

time:
-> The for loop iterates over the string from the end to the beginning. In the worst case (if there is no space at all or the string ends with no spaces), this takes O(n) time where n is the length of the string.
-> The loop performs O(n) operations in total, so the time complexity is O(n).



 */
