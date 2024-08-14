package Level1FreqUsedProgs._1_Strings;

public class _1_Palindrome {

    // using two pointer approach
    static Boolean isPalindrome(String myStr){
        int l = 0;
        int r = myStr.length()-1;
        while ( l < r){
            if (myStr.toLowerCase().charAt(l) != myStr.toLowerCase().charAt(r) )
                return false;
            l++;
            r--;
        }
        return true;
    }

    // using other approach- after reversing and then comparing
    public static Boolean palindromeCheck(String myStr){
        String reverseStr = "";
                for (int i = myStr.length()-1; i >= 0 ; i--){
                    reverseStr = reverseStr + myStr.toLowerCase().charAt(i);
        }
        return myStr.toLowerCase().equals(reverseStr);
    }

    public static void main(String[] args) {
        System.out.println("#### Palindrome checking #### ");
        String str = "Noorul";
        if (isPalindrome(str)){
            System.out.println(str + " is a Palindrome String.");
        }else System.out.println(str + " is not a Palindrome String.");

        System.out.println("2nd approach - with space O(n)");
        if (palindromeCheck(str)){
            System.out.println(str + " is a Palindrome String.");
        }else System.out.println(str + " is not a Palindrome String.");

    }
}
