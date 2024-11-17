package kunalSeries.linear.search;

import java.util.Arrays;

// TODO : Search in the String: return the index if character found
//    // otherwise if item not found return -1
public class _2SearchCharInString {

    public static void main(String[] args) {
        String str = "Noorul";
        char targetChar = 'r';
        System.out.println("String  : " + str);
        int res = searchCharInStr(str.toLowerCase(), targetChar);
        if(res !=-1)
            System.out.println("YES, we found the target character " + targetChar + "  and its index is : " + res);
        else
            System.out.println("NO, we didn't found the character " + targetChar);
    }

    private static int searchCharInStr(String str , char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==target)
                return i;
        }
        return -1;
    }

    // M-2 : converting into charArray and then searching
//    private static int searchCharInStr(String str , char target) {
//        char[] charArr = str.toCharArray();
//        for (int i = 0; i < charArr.length; i++) {
//            if (charArr[i]==target)
//                return i;
//        }
//        return -1;
//    }



}
