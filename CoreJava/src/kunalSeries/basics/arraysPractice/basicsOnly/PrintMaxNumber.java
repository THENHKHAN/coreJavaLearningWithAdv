package kunalSeries.basics.arraysPractice.basicsOnly;

import java.util.Arrays;
// TODO: find maximum number from array of int.
// REF for other approach: https://www.geeksforgeeks.org/find-second-largest-element-array/
public class PrintMaxNumber {
    public  static int findMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max)
                max = arr[i];
        }
        return max;
    }

    public  static int find2NdMax(int[] arr){
        int max1 = findMax(arr);
        int max2 = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max2 && arr[i]!=max1)
                max2 = arr[i];
        }
        return max2;
    }


    public  static  int findMaxIndexRange(int[]arr, int start, int end){
        if (start > end || arr.length==0) return -1;

        int max = arr[start];
        for (int i = start; i < end; i++) { // end is exclusive
            if (arr[i]>max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {33, 44, 20, 30, 333, 10,28, 13};
        System.out.println("Array : " + Arrays.toString(arr));// [33, 44, 20, 30, 333, 10, 28, 13]
        System.out.println(" 1st Max value : " + findMax(arr));// 333

        System.out.println(" 2nd Max value : " + find2NdMax(arr));// 44


        int[] arr2 = {33, 44, 20, 30, 333, 10,28, 13, 555 , 22, 35};
        System.out.println("Array2 : " + Arrays.toString(arr2));// [33, 44, 20, 30, 333, 10, 28, 13, 555, 22, 35]
        System.out.println("Max value between index range (3, 9): " + findMaxIndexRange(arr2, 3, 9));// 555

    }
}
