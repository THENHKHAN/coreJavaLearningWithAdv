package kunalSeries.binary.search.lect4hrs.easy;

// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=15     at 47:00 TS
// TODO: 744. Find Smallest Letter Greater Than Target : kind of ceiling type
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class _1_FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        // base conditions
//        if (target == letters[letters.length-1]) // no need bcz in question it said greater than and not greater than or equal to.
//            return letters[letters.length-1];

         if (target< letters[0] || target >= letters[letters.length-1])  // means no letter will be there which can be greater than the target.
            return letters[0];
        int s = 0;
        int e = letters.length-1;

        while (s<=e){ // FOCUS on THIS BREAK CONDITION
            int middleChar = s +(e-s)/2;
            if (target >= letters[middleChar])
                // If mid letter is less than or equal to the target,
                // we need to search to the right of mid (exclusive)
                s = middleChar+1; // equals works when  t=c , [c, f, j ] => in 2nd move we'll get s==e so in this case s-> s+1 means next to target element .
            else // (target<letters[middleChar])
                e = middleChar-1;
            // HERE we dont focus on getting the target element(since 'e','e', 'n') , t=''e so if we 1st e it will give e as answer and n.
//            else //
//                return letters[middleChar+1];
        }
        // if loop terminated normally means we got s>e. so sth position will be the correct letter since answer has to be between s<target<e.
        return letters[s%letters.length];// This ensures that if left is beyond the last index. Since if s>e it will be greater than the last index means we travelled all and we didn't found so returning 1st element.
        // If `s` goes out of bounds (no valid character greater than target exists),
        //        // return the first character in the array (circular condition).
    }

    public static void main(String[] args) {
        _1_FindSmallestLetterGreaterThanTarget obj =new _1_FindSmallestLetterGreaterThanTarget();

//        char[] letters = {'c','f','j'};
//        char target = 'j'; // c
//        char target = 'a'; // c
//        char target = 'd'; // f
//        char target = 'g'; // j
//        char target = 'f'; // j
//        char target = 'c'; // f

//        char[] letters = {'x','x','y', 'y'};
//        char target = 'z'; // f

        char[] letters = {'e','e', 'e', 'n', 'n', 'n', 'p'};
        char target = 'e'; // failing - but should come as n


        char res = obj.nextGreatestLetter(letters, target);
        System.out.println("The smallest character that is lexicographically greater than " + target + " in letters array is : " +res);
    }
}

/*
Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].

Constraints:

2 <= letters.length <= 10^4          // at least two character will be there
letters[i] is a lowercase English letter.      // no need to use string methods upper or lower
letters is sorted in non-decreasing order.    TODO- Hint to do it 1st binary search approach since sorted array.
letters contains at least two different characters.
target is a lowercase English letter.
 */

/*
                                Character compare : https://www.scaler.com/topics/how-to-compare-character-in-java/
Using Relational Operators:
we can compare characters by using relational operators such as <, >, or =. It is possible to compare only primitive characters with this method.
In the example below, two characters are compared using relational operators in Java. There are no classes or methods involved in this method, making it the simplest.
 */

// TODO - HINT
/*
##### letter wrap around means?
// explanation detail: [article](https://algo.monster/liteproblems/744)

we look if  only within the given array element.

To address the wrapping, we use modulus operation left % len(letters). This ensures that if left is beyond the last index, we return the first character in the array.
Finding the Answer:

After the loop exits, left is the index of the smallest character that is lexicographically greater than the target. If such a character doesn't exist, left will be equal to len(letters), indicating that we have searched the entire array without finding a character greater than target.

Return Statement:

return letters[left % len(letters)] ensures we return the correct character:
If left is less than len(letters), it means we've found a character that is greater than target, and we return that character.
If left is equal to len(letters), the modulus operation causes it to wrap around to 0, returning the first character of the array, which is the required behavior when a greater character isn't found.
*/
