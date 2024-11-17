package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.stringType;

// TODO: 7. How do you check whether a string is a palindrome in Java?
public class _2_PalindromCheck {
// you can also use two pointer ( T: O(n), S: O(1)) or StringBuilder (T: O(n), S: O(n))
    public static boolean isPalindrome(String str){
        if(str.isEmpty()){
            return false;
        }
        if(str.length()==1){
            return true;
        }

        for (int i = 0; i < str.length()/2; i++) {
            if(str.toLowerCase().charAt(i) != str.toLowerCase().charAt(str.length()-1 - i)) // if any character not matched from start with end then not palindrome
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String inpStr = "anpona"; // 012345

        System.out.println("\n ***********  ***********");
        if (isPalindrome(inpStr)){
            System.out.println("YES, Palindrome string ");
        } else {
            System.out.println("NO, not a Palindrome string ");
        }
    }

}
