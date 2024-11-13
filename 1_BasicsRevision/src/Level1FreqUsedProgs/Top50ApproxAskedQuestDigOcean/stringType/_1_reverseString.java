package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.stringType;

import java.util.Arrays;
import java.util.List;
// TODO : String Reverse - 2 ways
//  only 2 ways ? since basic starting just for consistency
public class _1_reverseString {

    private static void printReverseStrUtil(String revStr){
        System.out.println("Reversed String : " + revStr);
    }

    private static void printOriginalStrUtil(String revStr){
        System.out.println("Original String : " + revStr);
    }

    private static String reverseStrUsingToCharArrayWithStringBuilder(String inputStr) {
        StringBuilder out = new StringBuilder();

        char[] strToCharArray = inputStr.toCharArray();
        System.out.println("Char array : " + Arrays.toString(strToCharArray)); // [1, 2, 3, 4, 5, 6] or [N, o, o, r, u, l]

        for (int ind = inputStr.length()-1; ind >=0; ind-- ){
            out.append(strToCharArray[ind]);
        }

        return out.toString(); // 654321  , lurooN
    }// T: O(n), S: O(n)

    private static String reverseStrUsingTwoPointer(String inputStr) {
        if(inputStr==null){
            throw new IllegalArgumentException("null string is not a valid string");
        }

        StringBuilder out = new StringBuilder(inputStr); // copying the original string in string builder - Initializing StringBuilder(inputStr) takes O(n) time.

        int left = 0;
        int right = inputStr.length()-1; // rightmost index
//        while (right>=0){
        while (left<=right){
            // need to extract character : //extracting from original and putting( or replacing left to right vice versa)
            out.setCharAt(left, inputStr.charAt(right) ); // setting character from start (result str) of original(last)
            out.setCharAt(right, inputStr.charAt(left)); // setting character from left (result str) of original(start)

      // TODO: Why not using append-  out.append(inputStr.charAt(right)); will have do like traversal whole string
            left++;
            right--;
        }

        return out.toString(); // 654321  , lurooN
    } // T: O(n), S: O(n)


    public static void main(String[] args) {


            System.out.println("##############  Using ToCharArray With StringBuilder Approach    #################");
            String inputStr1 = "123456"; // "Noorul"
            printOriginalStrUtil(inputStr1);
            printReverseStrUtil( reverseStrUsingToCharArrayWithStringBuilder(inputStr1) );
                                // T: O(n), S: O(n)
            System.out.println("##############  TWO pointer Approach    #################");
            printOriginalStrUtil(inputStr1);
            printReverseStrUtil( reverseStrUsingTwoPointer(inputStr1) ); // RECOMMENDED (in terms of Space) - since in place replacement
                                // T: O(n), S: O(n)

    }


}
