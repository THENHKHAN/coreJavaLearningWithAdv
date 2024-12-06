package Revisions.basics.stringsss;

public class _2_ValidPalindromeOfSingleWord {


    public static boolean isPalindrome(String str){

        // two pointer approach:
        int l = 0 ;
        int r = str.length()-1 ;
        while (l<r){
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public static boolean palindromeCheckWithStringBuilder(String str){
        StringBuilder strB = new StringBuilder();
        for (int i = str.length()-1; i >= 0 ; i--) {
            strB.append(str.charAt(i));
        }
        return strB.toString().equals(str);
    }

    public static boolean palindromeCheckWithBuiltInMethodOfStringBuilder(String str){
            StringBuilder strB = new StringBuilder(str);
            strB.reverse();

            return strB.toString().equals(str);
    }


    public static void main(String[] args) {

        System.out.println("#### Palindrome checking #### ");
        String str = "abaa";
        if (isPalindrome(str)){
            System.out.println(str + " is a Palindrome String.");
        }else System.out.println(str + " is not a Palindrome String.");

        System.out.println("2nd approach - with space O(n)");
        if (palindromeCheckWithStringBuilder(str)){
            System.out.println(str + " is a Palindrome String.");
        }else System.out.println(str + " is not a Palindrome String.");


        System.out.println("3rd  approach - BuiltMethod  space O(n)");
        if (palindromeCheckWithBuiltInMethodOfStringBuilder(str)){
            System.out.println(str + " is a Palindrome String.");
        }else System.out.println(str + " is not a Palindrome String.");

    }
}
