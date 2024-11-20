package kunalSeries.binary.search.lect4hrs;

import java.util.Arrays;

// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=15      at 32:40 started
// TODO: Q-2 : Floor of Number (also called GIF) : Means find the Greatest nearest element less than or equal the target number in an array . (val<=target)
// ex: [1,4,6,8,9] , target=7 ==> so ans will be 6 since there is no 7 present. And we look for nearest BEFORE just 7 is only 6 Hence 6 will be ans.
public class _2_FloorOrGIFOfANumber {

    // greatest number <= target number
    public static int floor(int[] arr, int target){

        if (arr[0] == target)
            return target;
        if (target > arr[arr.length-1] || target < arr[0]) // target maybe not in the array.
            return -1;

        int s = 0;
        int e = arr.length-1;
        while (s<=e){
            int middleElement = s + (e-s)/2;
            if (target>arr[middleElement])
                s = middleElement+1;
            else if (target < arr[middleElement])
                e = middleElement-1;
            else // target found
                return arr[middleElement-1];
        }
//while loop terminated normally means element not found hence now e<s ===> e target s ===> e will be the nearest greatest <= target and e will be our ans.
    return arr[e];
    }

    public static void main(String[] args) {
                //   0  1  2  3   4   5   6  7
        int[] arr = {1, 4, 5, 13, 20, 28, 38, 48};  //Since sorted hence 1st approach should be Binary Search.
//        int target = 1; // 1
        int target = 28; // 20
//        int target = 13; // 5
//        int target = 48; // 38
//        int target = 408; // -1

//        int[] arr = {2, 3, 5, 9, 14, 16, 18};  //Since sorted hence 1st approach should be Binary Search.
//        int target = 15; // 14


        System.out.println("Array : " + Arrays.toString(arr));
        int res = floor(arr, target);
        if(res !=-1)
            System.out.println("Floor number of "+ target+" is : "+ res);
        else
            System.out.println("NO, we didn't found Floor number of " + target);
    }
}

/*
1. Floor Function (⌊x⌋) also called GIF: draw number line you'll better understand
        Maps x to the greatest integer ≤x.
        Example:
                ⌊2.7⌋=2, ⌊−1.3⌋=−2.
     The floor function gives the greatest nearest value that is less than or equal to the specified value.
                That means the resultant value will be less than the specified value.

2. Ceiling Function (⌈x⌉) : draw number line you'll better understand. Here also see how brackets used
        Maps x to the greatest integer ≥x.
        Example:
                ⌈2.7⌉=3, ⌈−1.3⌉=−1.
OR
      The ceiling function gives the ***smallest nearest integer***(maybe used in binary search) that is greater than or equal to the specified value in a number line.
                It gives the rounds up the given number.

        OR:
        Evaluate the ceiling function of 4.5 and – 4.5. Also, explain the answer.

                Solution :
                ⌈4.5⌉ = 5 and ⌈- 4.5⌉ = – 4
                Explanation:
                            The ceiling function of a real number is the least integer number greater than or equal to the given number.
                            In the case of 4.5, the integers greater than 4.5 are 5, 6, 7, 8, …..
                            The smallest of all is 5.
                            Therefore, ⌈4.5⌉ = 5.
                            In the case of -4.5, the integers that are greater than – 4.5 are – 4, – 3, – 2,…
                            The smallest of them is – 4
                            Therefore, ⌈- 4.5⌉ = – 4
 */
/*
          x	  Floor	Ceiling
        −1.1	−2	−1
         0	     0   0
        1.01	1	2
        2.9	    2  	3
        3   	3	3


 */

