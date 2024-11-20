package kunalSeries.binary.search.lect4hrs.easy.failedcasestrack;

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

        while (s<=e){
            int middleChar = s +(e-s)/2;
            if (target > letters[middleChar])
                s = middleChar+1;
            else if (target<letters[middleChar])
                e = middleChar-1;

            else // HERE we dont focus on getting the target element(since 'e','e', 'n') , t=''e so if we 1st e it will give e as answer and n.
                return letters[middleChar+1];
        }
        // if not found then returning 1st character in letters.
        return letters[s];
    }

    public static void main(String[] args) {
        _1_FindSmallestLetterGreaterThanTarget obj =new _1_FindSmallestLetterGreaterThanTarget();

//        char[] letters = {'c','f','j'};
//        char target = 'j'; // j
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