package kunalSeries.stringassignment.easy;

// TODO: 1704. Determine if String Halves Are Alike
// https://leetcode.com/problems/determine-if-string-halves-are-alike/description/

import java.util.HashSet;
import java.util.Set;
public class _12_StringHalfAlikeOrNot {

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String vowels = "AEIOUaeiou";
        StringBuilder str1 = new StringBuilder();
        int countStr1Vowels = 0;
        StringBuilder str2 = new StringBuilder();
        int countStr2Vowels = 0;

        for (int i =0 ; i<n; i++){
            if (i<n/2){

                 str1.append(s.charAt(i));
                if (vowels.indexOf(s.charAt(i)) !=-1){
                    countStr1Vowels++;
                }

            } else{
                str2.append(s.charAt(i));
                if (vowels.indexOf(s.charAt(i)) !=-1){
                    countStr2Vowels++;
                }
            }


        }
        System.out.println("count1 : " + countStr1Vowels + " and count2: " + countStr2Vowels);

        System.out.println("Str1 : "  + str1) ;
        System.out.println("Str2 : "  + str2) ;


        return countStr1Vowels==countStr2Vowels;
    }

    public boolean halvesAreAlikeMoreOptimizedUsingHashSet(String s) {
        int n = s.length();
        int count1stHalf = 0;
        int count2ndHalf = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        System.out.println("Set Of Vowels : " + vowels);

        // Vowels Set: Instead of using a string to store vowels, I've used a HashSet<Character>. Checking membership in a Set is faster, and it eliminates the need to use indexOf().
        for (int i = 0; i < n/2; i++) {
            if (vowels.contains(s.charAt(i))){
                count1stHalf++;
            }
            // Loop Optimization: The loop now iterates only over the first half, and in the same loop, we count vowels in the second half by using n - i - 1 for the corresponding character from the second half.
            if( vowels.contains(s.charAt(n-i-1)) ) { // from last to mid
                count2ndHalf++;
            }
        }

        System.out.println("count1stHalf : " + count1stHalf + " and count2ndHalf : " + count2ndHalf);

        return count1stHalf==count2ndHalf;
        // You can simplify the vowel-checking condition by avoiding the use of String.indexOf(). Using a Set of vowels would be more efficient, as checking membership in a Set is generally faster than using String.indexOf().
    }

    public static void main(String[] args) {

        _12_StringHalfAlikeOrNot obj = new _12_StringHalfAlikeOrNot();
        System.out.println("-------------------TEST-1-------------------------------");
        String str = "book";
        System.out.println("Provide String : " + str);
        System.out.println("Half Alike or Not : " + obj.halvesAreAlike(str));
        System.out.println("Half Alike or Not HashSet: " + obj.halvesAreAlikeMoreOptimizedUsingHashSet(str));

        System.out.println("-------------------TEST-2-------------------------------");
        String str2 = "textbook";
        System.out.println("Provide String : " + str2);
        System.out.println("Half Alike or Not : " + obj.halvesAreAlike(str2));
        System.out.println("Half Alike or Not HashSet: " + obj.halvesAreAlikeMoreOptimizedUsingHashSet(str2));

    }
}

// TODO: Some observation :


/*
TIME:
The optimized version uses a HashSet for storing vowels. A HashSet provides average constant time O(1) for checking membership (contains() operation).

        The loop iterates over the first half of the string (n/2 times), and for each character in both halves, the contains() operation is O(1).

        O(n/2) ≈ O(n) because the loop runs for half of the string, but constants are ignored in Big-O notation.

Space:
The optimized code uses a HashSet for vowels, which requires space proportional to the number of distinct vowels in the set. Since there are only 10 distinct vowels, this space is O(1).

Therefore, the space complexity of the optimized code is O(1) for the HashSet and the variables to store counts, resulting in O(1) space complexity.

 */