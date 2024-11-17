package kunalSeries.linear.search;

import java.util.Arrays;

// TODO : Search in the array (search for k element in range of INDEX (1, 4)) : return the index if item found
//    // otherwise if item not found return -1
public class _3SearchingEleInArrayInRange {
    public static void main(String[] args) {

         int[] arr = {1, 33, 5, 9, 15, 11, 12};
         int target = 9;
         int start = 1;
         int end = 4; // inclusive
        System.out.println("Array : " + Arrays.toString(arr));
        int res = searchElement(arr, target,start, end);
        if(res !=-1)
            System.out.println("YES, we found the element " + target +" in index range" +" (" + start + ", " + end+") and its index is : " + res);
        else
            System.out.println("NO, we didn't found the element " + target + " in index range" +" (" + start + ", " + end+")");
    }

    public static int searchElement(int[] arr, int target, int start, int end){
        // basic checks
        if (arr.length == 0){
            return -1;
        }

        for (int i = start; i <= end; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1 ;
    }
}
