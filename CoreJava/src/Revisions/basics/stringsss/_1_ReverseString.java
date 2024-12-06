package Revisions.basics.stringsss;

import java.util.Arrays;

public class _1_ReverseString {

    public static String reverseStrByBackwardTraversalAndAppendInStringBuilder(String str){
        StringBuilder strB = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            strB.append(str.charAt(i));
        }
        return strB.toString();
    }

    public static String reverseStrByTwoPointerApproachWithStringBuilder(String str){
        StringBuilder res = new StringBuilder(str);
        int l = 0 ;
        int r = str.length()-1 ;

        while (l<r){
            res.setCharAt(l, str.charAt(r));
            res.setCharAt(r, str.charAt(l));
            l++;
            r--;
        }

        return res.toString();
    }

    public static String reverseStrByRecursionApproachWithToCharArray(String str){
        char[] charArray = str.toCharArray();
        System.out.println("Chara Array : " + Arrays.toString(charArray));
        reverseStrWithRecursion(charArray, 0, charArray.length-1);
        System.out.println("Chara Array After Recursion: " + Arrays.toString(charArray));

        return new String(charArray);
    }

    public static void reverseStrWithRecursion(char[] charArray, int l, int r){

        if (l>=r)
            return;
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;

        reverseStrWithRecursion(charArray, l+1, r-1);

    }


    public static String reverseStrByInBuiltMethod(String str){

        StringBuilder res = new StringBuilder(str);
        res.reverse();

        return res.toString();

    }

    public static void main(String[] args) {

        String s1 = "abdcfe";
        System.out.println("====== Using backward traversal – O(n) Time and O(n) Space ======");
        String res1 = reverseStrByBackwardTraversalAndAppendInStringBuilder(s1);
        System.out.println("Original String : " + s1 + " &  its " + "Revered String : " + res1 + "\n\n");
        // Original String : abdcfe &  its Revered String : efcdba


        String s2 = "abdcfe";
        System.out.println("======= Using Two Pointers – O(n) Time and O(n) Space =======");
        String res2 = reverseStrByTwoPointerApproachWithStringBuilder(s2);
        System.out.println("Original String : " + s2 + " &  its " + "Revered String : " + res2 + "\n\n");


        String s3 = "abdcfe";
        System.out.println("======= Using Recursion – O(n) Time and O(n) Space =======");
        String res3 = reverseStrByRecursionApproachWithToCharArray(s3);
        System.out.println("Original String : " + s3 + " &  its " + "Revered String : " + res3 + "\n\n");

        String s5 = "abdcfe";
        System.out.println("======= Using Inbuilt methods – O(n) Time and O(1) Space =======");
        String res5 = reverseStrByInBuiltMethod(s5);
        System.out.println("Original String : " + s5 + " &  its " + "Revered String : " + res5 + "\n\n");
    }
}
