package kunalSeries.binary.search;

// BINARY SEARCH : for this array must be SORTED if not then sorted and then apply if U want to.
// TODO : Search in the array(SORTED): return the index if item found
// otherwise if item not found return -1. It does not matter ASC or DESC order sorted we'll handle both cases.
// See below of code we have explained well,

import java.util.Arrays;

public class _3OrderAgnosticBInarySearch {

    public static int searchElement(int[] arr, int target) {
        // basic checks
        if (arr.length == 0) {
            return -1;
        }
        // Determine if the array is sorted in ascending or descending order
        boolean isAscendingOrder = arr[0]<arr[arr.length-1];
        int s = 0;
        int e = arr.length-1;

        while (s<=e){
            int middleIndex = s + (e-s)/2;
            if (target == arr[middleIndex])
                return middleIndex; // Target found
            if (isAscendingOrder) { // ASC
                    if (target>arr[middleIndex])
                        s = middleIndex+1;
                    else if (target<arr[middleIndex])
                        e = middleIndex-1;
            }
            else { // for descending order
                    if (target > arr[middleIndex]) // search toward LEFT from the middle
                        e = middleIndex - 1;
                    else if (target < arr[middleIndex])
                        s = middleIndex + 1;
            }
    }
      return -1; // not found
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 13, 20, 28, 38, 48};  // ASC order
        int target = 28; // 5
//        int target = 400; // -1

               //   0    1  2  3    4    5     6
//        int[] arr = {17, 12, 4, -4, -20, -48, -100}; // DESC order
//        int target = -48; // 5
//        int target = 12; // 1
//        int target = 4; // 2
//        int target = 114; // -1

        System.out.println("Array : " + Arrays.toString(arr));
        int res = searchElement(arr, target);
        if(res !=-1)
            System.out.println("YES, we found the element " + target + "  and its index is : " + res);
        else
            System.out.println("NO, we didn't found the element " + target);
    }
}

// TODO : Order-Agnostic Binary search INFO
// DEF: Order Agnostic refers to an approach or algorithm that can handle both ascending and descending order arrays without requiring prior knowledge of their order.
        /*In the context of binary search, an order-agnostic binary search is an algorithm that determines whether the array is sorted in ascending or descending
        order and then proceeds accordingly. This eliminates the need to hardcode separate logic for ascending and descending arrays.
         */


/*
Why Use Order-Agnostic Search?
In scenarios where you are not sure whether the input array is sorted in ascending or descending order, an order-agnostic search is helpful. For example:

The input array might change dynamically.
A library function may return sorted arrays without specifying the order.

Key Idea
1-> First, determine the order of the array by comparing the first and last elements.
                If the first element is smaller than the last, the array is in ascending order.
                Otherwise, the array is in descending order.
2-> Use a binary search algorithm, adjusting the comparison logic based on the detected order.
 */
/*
 // Determine if the array is sorted in ascending or descending order
    boolean isAscending = arr[start] < arr[end];



Key Advantages
        -->    Versatile: Works for both ascending and descending sorted arrays.
        -->    Efficient: Same O(logn) time complexity as standard binary search.
        -->    Simplifies Code: Eliminates the need for separate logic or pre-processing to determine the order of the array.
 */