package kunalSeries.basics.arraysPractice.basicsOnly;

import java.util.Arrays;

// TODO: swap 2nd and 4th element in the array
// 2nd element means 1st index, 4th element 3rd index
public class SwapTwoIndexvalues {

    public  static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1]= arr[index2];
        arr[index2] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Before swapping 2nd and 4th element from array : " + Arrays.toString(arr));// [1, 2, 3, 4, 5]
        swap(arr, 1, 3);
        System.out.println("AFTER swapping 2nd and 4th element from array : " + Arrays.toString(arr));// [1, 4, 3, 2, 5]
    }


}
