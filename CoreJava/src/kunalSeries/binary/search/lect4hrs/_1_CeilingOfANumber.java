package kunalSeries.binary.search.lect4hrs;

import java.util.Arrays;
// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=15      at 26:40 imp
// TODO: Q-1 : Ceiling of Number : Means find the Smallest nearest element in array greater than or equal the target number. (val>=target)
// ex: [1,4,6,8,9] , target=7 ==> so abs will be 8 since there is no 7 present. And we look for nearest after just 7 is only 8 Hence 8 will be ans.
public class _1_CeilingOfANumber {

    public static int ceiling(int[] arr, int target){

            if (target == arr[arr.length-1]) // target maybe number that is last number. so since ceiling is nearest >= the number.
                return target;
            if (target > arr[arr.length-1]) // target maybe not in the array.
                return -1;

            int s = 0;
            int e = arr.length-1;

            while (s<=e){
                int middleElement = s+(e-s)/2;
                if (target>arr[middleElement]) // search toward RIGHT from middle element.
                    s = middleElement+1;
                else if (target<arr[middleElement]) // search toward LEFT from middle element.
                    e = middleElement-1;
                 else // for when we **found the target element** hence the next of this will be our ceiling number
                        return arr[middleElement+1];
            }
            // indices which means we travelled all the possible indices hence it will be the most closest to the target element hence next element will be the ceiling
       // when loop breaks : s>e=> e target s ==> so s will be ceiling of target
        return arr[s]; // for s>e
    }

    public static void main(String[] args) {
                //   0  1  2  3   4   5   6  7
//        int[] arr = {1, 4, 5, 13, 20, 28, 38, 48};  //Since sorted hence 1st approach should be Binary Search.
//        int target = 28; // 38
//        int target = 13; // 20
//        int target = 48; // 48
//        int target = 408; // -1

        int[] arr = {2, 3, 5, 9, 14, 16, 18};  //Since sorted hence 1st approach should be Binary Search.
        int target = 15; // 16 --> in this case while loop terminate normally and return arr[s] will return.


        System.out.println("Array : " + Arrays.toString(arr));
        int res = ceiling(arr, target);
        if(res !=-1)
            System.out.println("Ceiling number of "+ target+" is : "+ res);
        else
            System.out.println("NO, we didn't found Ceiling number of " + target);
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

