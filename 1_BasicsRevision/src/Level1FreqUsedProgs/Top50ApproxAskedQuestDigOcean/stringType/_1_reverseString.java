package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.stringType;

import java.util.Arrays;
import java.util.List;

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
    }

    private static String reverseStrUsingTwoPointer(String inputStr) {

        StringBuilder out = new StringBuilder();

        int left = 0;
        int right = inputStr.length()-1; // rightmost index

        return out.toString();
    }

    public static void main(String[] args) {


            System.out.println("##############  Using ToCharArray With StringBuilder Approach    #################");
            String inputStr1 = "123456"; // "Noorul"
            printOriginalStrUtil(inputStr1);
            printReverseStrUtil( reverseStrUsingToCharArrayWithStringBuilder(inputStr1) );

            System.out.println("##############  TWO pointer Approach    #################");
            printOriginalStrUtil(inputStr1);
            printReverseStrUtil( reverseStrUsingTwoPointer(inputStr1) );


    }


}
