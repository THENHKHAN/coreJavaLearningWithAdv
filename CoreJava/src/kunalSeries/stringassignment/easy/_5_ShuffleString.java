package kunalSeries.stringassignment.easy;

import java.util.Arrays;

// TODO: 1528. Shuffle String : Solved with the help of provided HINT in the hint tab.
// https://leetcode.com/problems/shuffle-string/description/
// for future ref: https://algo.monster/liteproblems/1528
public class _5_ShuffleString {

    public String restoreString(String str, int[] indices) {
        int n = str.length();
        char[] chArray = new char[n]; // will store here with the provide correct indices in indices array.
                            // and place each character as the ith position of indices array.
        int i = 0; // will us for indices array as index
        int j = 0; // will use for string indices

        while(i<n && j<n){
            chArray[indices[i]] = str.charAt(j);
            i++;
            j++;
        }
        System.out.println("chArray : " + Arrays.toString(chArray)); // [l, e, e, t, c, o, d, e]
        return new String(chArray); // it's working similar to below. But since there is no such method we're using String constructor. This will not be counted as space
//        return ''.join(chArray);
    }

    public static void main(String[] args) {
        _5_ShuffleString obj = new _5_ShuffleString();
        String str = "codeleet";
        int[] correctIndices = {4,5,6,7,0,2,1,3};


        System.out.println(" Original String : " + str);


        String shuffleStr = obj.restoreString(str, correctIndices);
        System.out.println(" Shuffled String : " + shuffleStr);
        // time complexity is: O(n)
        // space complexity is: O(n)
    }
}
// The problem requires you to 'shuffle' or rearrange the characters in s based on the values in indices.