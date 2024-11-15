package stringQuestions.basics;

public class _1_Palindrome {

    // using two pointer approach
    static Boolean isPalindrome(String myStr){
        if(myStr.isEmpty()){
            return false;
        }
        if(myStr.length()==1){
            return true;
        }
        int l = 0;
        int r = myStr.length()-1;
        while ( l < r){
            if (myStr.toLowerCase().charAt(l) != myStr.toLowerCase().charAt(r) )
                return false;
            l++;
            r--;
        }
        return true;
    } // T: O(n), S: O(1)

    // using other approach- after reversing and then comparing
    public static Boolean palindromeCheck(String myStr){
        if(myStr.isEmpty()){
            return false;
        }
        if(myStr.length()==1){
            return true;
        }

        String reverseStr = ""; // TODO: use StringBuilder instead: Since append (O(1)) but concat(+= take O(n))
                                // for more read detail searched GPT in mobile
                for (int i = myStr.length()-1; i >= 0 ; i--){ // T: O(n), S: O(n)
                    reverseStr = reverseStr + myStr.toLowerCase().charAt(i); // T: O(n), S: O(n)(since each iteration it create new string instance and then concat)
        }// T: O(n^2), S: O(n^2)
        return myStr.toLowerCase().equals(reverseStr); // T: O(n), S: O(n)
    }// T: O(n^2), S: O(n^2)

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
