package kunalSeries.binary.search;

import java.util.Arrays;
 // BINARY SEARCH : for this array must be SORTED if not then sorted and then apply if U want to.
// TODO : Search in the array(SORTED): return the index if item found
//    // otherwise if item not found return -1
public class _1SearchEleAndReturnIndexInAscOrder {

    public static int searchElement(int[] arr, int target){
        // basic checks
        if (arr.length == 0){
            return -1;
        }

        int s = 0;
        int e = arr.length-1;

        while (s<=e){
//            int middleIndex = (s+e)/2; start_end ==> might exceed the integer limit that's y we got a new way to do the same
            int middleIndex = s + (e-s)/2; //  (s+e +s-s)/2 => (2s+e-s)/2 => 2s/2 + (e-s)/2 => s + (e-s)/2 now this won't exceed integer range
            if (target > arr[middleIndex] ) { // search right to the middle element
                        s = middleIndex+1;
            } else if (target < arr[middleIndex]) { // search left to the middle element
                        e = middleIndex-1;
            }
            else{ // for arr[middleIndex]==target
                return middleIndex;
            }
        }
        return -1 ;
    }

    public static void main(String[] args) {

         int[] arr = {1, 4, 5, 13, 20, 28, 38, 48};
         int target = 28;
        System.out.println("Array : " + Arrays.toString(arr));
        int res = searchElement(arr, target);
        if(res !=-1)
            System.out.println("YES, we found the element " + target + "  and its index is : " + res);
        else
            System.out.println("NO, we didn't found the element " + target);
    }
}
