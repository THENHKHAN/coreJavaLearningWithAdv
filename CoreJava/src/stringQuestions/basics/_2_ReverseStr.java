package stringQuestions.basics;

// TODO : String Reverse - 5 ways
// https://www.geeksforgeeks.org/string-reverse/?ref=lbp#reverse-string-using-inbuilt-method-on-time-and-o1-space

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _2_ReverseStr {

    public static String reverseStrByBackwardTraversal(String str){
        // Use StringBuilder for mutability
        StringBuilder res = new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--){ // Time Complexity: O(n) for backward traversal
            res.append(str.charAt(i)) ; //S: O(1), T:O(1) // add each character to a new string
        }
        //Auxiliary Space:  O(n) for storing the reversed string.
        return res.toString() ;// S: O(n)
    } // T: O(n), S: O(n)

    /*
 The idea is to maintain two pointers: left and right, such that left points to the beginning of the string and right points to the end of the string.

        While left pointer is less than the right pointer, swap the characters at these two positions. After each swap,
        increment the left pointer and decrement the right pointer to move towards the center of the string. This will swap all the characters in the first half with
        their corresponding character in the second half.
     */
    public static String reverseStrByTwoPointerApproach(String str) {
        StringBuilder res = new StringBuilder(str);// copying the original string in string builder - Initializing StringBuilder(inputStr) takes O(n) time.
        int l = 0;
        int r = str.length()-1;

        while (l < r){
//            System.out.println("left : " + l + " right : " + r);
            // need to extract character : //extracting from original and putting( or replacing left to right vice versa)
            res.setCharAt(l, str.charAt(r) );// setting character from start (result str) of original(last)
            res.setCharAt(r, str.charAt(l));// setting character from left (result str) of original(start)
            l++;
            r--;
        }

        return res.toString() ;
    }

    /*
    The idea is to use recursion and define a recursive function that takes a string as input and reverses it. Inside the recursive function,
                 Swap the first and last element.
                 Recursively call the function with the remaining substring.
     */
    public static String reverseStrByRecursionApproach(String str){
        char []charArr = str.toCharArray();
        System.out.println("Char Array : " + Arrays.toString(charArr));// to see char araray else it will print obj
        reverseStrRecursion(charArr, 0, charArr.length-1);
        System.out.println("Char Array Reversed : " + Arrays.toString(charArr));// to see char araray else it will print obj

        return new String(charArr);
    }

    private static void reverseStrRecursion(char[] charArr, int l , int r) {
        // terminating condition
        if (l>r) return;
        // need to swap
        char temp = charArr[l];
        charArr[l] = charArr[r];
        charArr[r] = temp;

        reverseStrRecursion(charArr, l+1, r-1);// recursive call
    }

    /*
    The idea is to use stack for reversing a string because Stack follows Last In First Out (LIFO) principle. This means the last character you add is the first one
    you’ll take out. So, when we push all the characters of a string into the stack, the last character becomes the first one to pop.
     */
    private static String reverseStrByStackApproach(String str) {// LAST IN FIRST OUT approach
        Stack<Character> stack = new Stack<>();// since it will be a stack of character and not string
        // let's push each character into STACK
        for (int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        // Pop the characters of stack into the original string
        for ( int i = 0 ; i < str.length() ; i++){
            res.append(stack.pop()); // it will always remove the last element on the stack and return.
        }
        return res.toString();

    }

    /*
    The idea is to use built-in reverse method to reverse the string. If built-in method  for string reversal does not exist, then convert string to array or list and use their built-in method for reverse. Then convert it back to string.
     */
    private static String reverseStrByInBuiltMethod(String str){
        StringBuilder res = new StringBuilder(str); // since String Class does not have reverse method OR we could use List or Array
        return res.reverse().toString();
    }

    // TODO: Building a New String Using Two Pointers WITH CHAR ARRAY : same Optimization(space and time) as above TWO pointer Approach
    //  but recommended StringBuilder Approach
    private static String reverseStrUsingTwoPointer(String inputStr) {
        int left = 0;
        int right = inputStr.length() - 1;
        char[] result = new char[inputStr.length()];

        while (left <= right) {
            result[left] = inputStr.charAt(right);
            result[right] = inputStr.charAt(left);

            left++;
            right--;
        }

        return new String(result);
    }

    public static void main(String[] args) {

        String s1 = "abdcfe";
        System.out.println("====== Using backward traversal – O(n) Time and O(n) Space ======");
        String res1 = reverseStrByBackwardTraversal(s1);
        System.out.println("Original String : " + s1 + " &  its " + "Revered String : " + res1 + "\n\n");
        // Original String : abdcfe &  its Revered String : efcdba


        String s2 = "abdcfe";
        System.out.println("======= Using Two Pointers – O(n) Time and O(n) Space =======");
        String res2 = reverseStrByTwoPointerApproach(s2);
        System.out.println("Original String : " + s2 + " &  its " + "Revered String : " + res2 + "\n\n");

        String s3 = "abdcfe";
        System.out.println("======= Using Recursion – O(n) Time and O(n) Space =======");
        String res3 = reverseStrByRecursionApproach(s3);
        System.out.println("Original String : " + s3 + " &  its " + "Revered String : " + res3 + "\n\n");

        String s4 = "abdcfe";
        System.out.println("======= Using Stack – O(n) Time and O(n) Space =======");
        String res4 = reverseStrByStackApproach(s4);
        System.out.println("Original String : " + s4 + " &  its " + "Revered String : " + res4 + "\n\n");

        String s5 = "abdcfe";
        System.out.println("======= Using Inbuilt methods – O(n) Time and O(1) Space =======");
        String res5 = reverseStrByInBuiltMethod(s5);
        System.out.println("Original String : " + s5 + " &  its " + "Revered String : " + res5 + "\n\n");


    }

}
