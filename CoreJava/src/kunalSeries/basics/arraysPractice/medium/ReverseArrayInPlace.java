package kunalSeries.basics.arraysPractice.medium;

import java.util.Arrays;

// TODO : Reverse array in place. will be using
//  PATTERN : two pointer APPROACH
public class ReverseArrayInPlace {

    public  static  void swap(int[] arr, int l, int r) {
            arr[l] = arr[l] + arr[r];
            arr[r] = arr[l] - arr[r];
            arr[l] = arr[l] - arr[r];
    }
    public  static  void reverseArray(int[] arr){
            int l = 0;
            int r = arr.length-1;

            while (l<r){
//                int temp = arr[l];
//                arr[l] = arr[r];
//                arr[r] = temp;
//                OR
                swap(arr, l, r);
                l++;
                r--;
            }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("ORIGINAL  array : " + Arrays.toString(arr));// [1, 2, 3, 4, 5]
        reverseArray(arr);
        System.out.println("After Reversing array : " + Arrays.toString(arr));// [5, 4, 3, 2, 1]

    }
}
