package kunalSeries.linear.search;

import java.util.Arrays;

// TODO : Search in the array: return the index if item found
//    // otherwise if item not found return -1
public class _1SearchEleAndReturnIndex {

    public static int searchElement(int[] arr, int target){
        // basic checks
        if (arr.length == 0){
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1 ;
    }

    public static void main(String[] args) {

         int[] arr = {1, 33, 5, 9, 15, 11, 12};
         int target = 122;
        System.out.println("Array : " + Arrays.toString(arr));
        int res = searchElement(arr, target);
        if(res !=-1)
            System.out.println("YES, we found the element " + target + "  and its index is : " + res);
        else
            System.out.println("NO, we didn't found the element " + target);
    }
}
