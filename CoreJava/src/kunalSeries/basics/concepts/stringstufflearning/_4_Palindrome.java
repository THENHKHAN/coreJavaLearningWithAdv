package kunalSeries.basics.concepts.stringstufflearning;

//   TODO: Kunal :https://www.youtube.com/watch?v=zL1DPZ0Ovlo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=21   TS- 01:12:00
// will be doing two pointer approach
// for ref: CoreJava/src/Level1FreqUsedProgs/Top50ApproxAskedQuestDigOcean/stringType/_1_reverseString.java  multiple ways
// new way can be come such questions: https://www.geeksforgeeks.org/sentence-palindrome-palindrome-removing-spaces-dots-etc/

// 40+ questions on this topic (with easy/medium/hard): https://www.geeksforgeeks.org/string-palindrome/
public class _4_Palindrome {

    public static boolean isPalindrome(String str){

        // edge case :
        if (str == null || str.trim().isEmpty() || str.length()==1)
            return true;

        int l = 0;
        int r = str.length()-1;

        while (l<r){

            if (str.charAt(l) != str.charAt(r)) // if any charcter from left to right is not matches then this string will be not palindrome.
                return false;
            else{
                l++;
                r--;
            }


        }

        return true;
    }

    public static void main(String[] args) {
//        String inpStr = "abba"; // true
//        String inpStr = "anpona"; // false
//        String inpStr = "nitin"; // true
        String inpStr = "Too hot to hoot"; // false but if we remove  non-alphanumeric characters then true
        //  If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase, string s will become “toohottohoot” which is a palindrome.

        System.out.println("\n My STring: " + inpStr);
        System.out.println("\n ***********  ***********");
        if (isPalindrome(inpStr.replace(" ", "").toLowerCase())){
            System.out.println("YES, Palindrome string ");
        } else {
            System.out.println("NO, not a Palindrome string ");
        }
    }
}
/*
  Optimization of two pointers approach – O(n) time and O(1) space:
This approach is just an optimization of two variables that we have used in the above approach. Here, we can do the same with the help of single variable only. The idea is that:

Iterates through the first half of the string.
For each character at index i, checks if s[i] and s[length – i – 1])
If any pair of characters don’t match, then returns 0.
------------------------
def is_palindrome(s):
    length = len(s)

    # Iterate over the first half of the string
    for i in range(length // 2):

        # If the characters at symmetric positions are not equal
        if s[i] != s[length - i - 1]:

            # Return 0 (not a palindrome)
            return 0

    # If all symmetric characters are equal
    # then it is palindrome
    return 1

# Driver code
s = "abba"
print(is_palindrome(s))
 */