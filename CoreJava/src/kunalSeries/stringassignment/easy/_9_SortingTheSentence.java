package kunalSeries.stringassignment.easy;

import java.util.ArrayList;
import java.util.Arrays;

// TODO:  1859. Sorting the Sentenced
// https://leetcode.com/problems/sorting-the-sentence/description/
// ref: https://leetcode.com/problems/sorting-the-sentence/solutions/6174790/1859-sorting-the-sentence-easy-explanation/
public class _9_SortingTheSentence {

    public String sortSentence(String s) {

        ArrayList<String> lstOfWord = new ArrayList<>();
        String[] words = s.split(" "); //array of string-  [is2, sentence4, This1, a3]
        int len = words.length;
        String[] arrOfSortedString = new String[len];

        for (String w : words){
            // extract position
            int pos =  w.charAt(w.length()-1)-'0'; // // Convert the character to an integer
            //alternate  int position = Integer.parseInt(word.substring(word.length() - 1));
            arrOfSortedString[pos-1] = w.substring(0,w.length()-1); //  String actualWord
             // Position is 1-indexed, so subtract 1
        }

//        System.out.println("arrOfString : " + Arrays.toString(arrOfSortedString));

      return String.join(" ", arrOfSortedString);
    }

    public static void main(String[] args) {
        _9_SortingTheSentence obj = new _9_SortingTheSentence();
        String str = "is2 sentence4 This1 a3";
        System.out.println("Provide String : " + str);
        System.out.println("New Sorted sentence : " + obj.sortSentence(str));

    }
}
/*
A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.



Example 1:

Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

 */
