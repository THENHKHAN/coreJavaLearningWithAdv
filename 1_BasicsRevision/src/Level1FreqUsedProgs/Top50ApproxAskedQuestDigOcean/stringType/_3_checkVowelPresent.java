package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.stringType;

public class _3_checkVowelPresent {
    public static void UtilPrintResult(boolean flag, String inpStr){
        if (flag){
            System.out.println("YES, Vowel Present in the provided string : " + inpStr);
        } else {
            System.out.println("NO, Vowel not Present in the provided string : " + inpStr);

        }
    }

    public static boolean isVowelPresentInStrUsingConditionWIthEachVowelCharacter(String str){
        if(str.toLowerCase().contains("a") ||
                str.toLowerCase().contains("e") ||
                str.toLowerCase().contains("i") ||
                str.toLowerCase().contains("o") ||
                str.toLowerCase().contains("u") ) {
            return true;
        }
        return false;
    }// T: O(n) (for contains call), S: O(n) (for lowing case)

    public static boolean isVowelPresentInStrUsingMatchFunctionWithRegex(String str){
        return str.toLowerCase().matches(".*[aeiou].*");
    }// T: O(n) (for matches with regex Pattern call), S: O(n) (for lowing case)

    private static boolean isVowelPresentInStrUsingSingleLoopAndIndexOfFun(String inpStr) {
        String vowel = "aeiou";
        inpStr = inpStr.toLowerCase();
        for (int i = 0; i<vowel.length(); i++){
            if(inpStr.indexOf(vowel.charAt(i) ) != -1 ){
                return true;
            }
        }
        return false; // T: O(n) (for loop ), S: O(n) (for lowing case)
    }// indexOf() :return -> An int value, representing the index of the first occurrence of the character in the string, or -1 if it never occurs
    public static void main(String[] args) {
        String inpStr = "bbcckkdd**#";

        System.out.println("\n *********** Comparing each vowel character with IF Condition ***********");
        UtilPrintResult(isVowelPresentInStrUsingConditionWIthEachVowelCharacter(inpStr), inpStr); // he first method performs multiple contains() checks, which might involve scanning parts of the string multiple times, although they are short-circuited once a match is found.

        System.out.println("\n *********** Comparing REGEX Pattern match function ***********");
        UtilPrintResult(isVowelPresentInStrUsingMatchFunctionWithRegex(inpStr), inpStr);// more optimized in terms of readability and maintainability:
            // both above almost same
        System.out.println("\n ***********SINGLE LOOP or single pass Comparing each vowel character with IF single and indexOf() ***********");
        UtilPrintResult(isVowelPresentInStrUsingSingleLoopAndIndexOfFun(inpStr), inpStr); // most efficient
    }

}
/*

    Why This SINGLE LOOP Method is Efficient
        Single Pass:
                    Unlike the multiple .contains() method or regex, this approach uses a single loop and a constant-time check for each character.
        Lower Space Usage:
                    Avoids using multiple transformations or regex engines, making it more space-efficient.

    Conclusion
        - This single-loop approach is both time-efficient and space-efficient.
        - It's a great choice if you want a clear, performant solution without the overhead of regex or multiple method(here contains called) calls.
 */

// REGEX PATTER:
/*

.*[aeiou].*
Here's what each part means:

    .* :
        . matches any character (except a newline).
        * means "zero or more" occurrences of the preceding character, so .* matches any sequence of characters (or an empty string).

    [aeiou] :
                The square brackets [] define a character class.
                It matches any one character that is either 'a', 'e', 'i', 'o', or 'u'.

    .*[aeiou].* :
                This pattern means "any sequence of characters, followed by a vowel, followed by any sequence of characters".
                Effectively, it checks if the string contains at least one vowel.
 */
