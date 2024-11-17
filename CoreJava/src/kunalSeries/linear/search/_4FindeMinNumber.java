package kunalSeries.linear.search;

// TODO : Find minimum number in the given array.

import java.util.Arrays;

public class _4FindeMinNumber {
    public static void main(String[] args) {

        int[] arr = {111, 33, 5, 9, 15, 11, 12};
        System.out.println("Array : " + Arrays.toString(arr));
        int res = findMinNum(arr);
        if(res ==-1)
            System.out.println("Empty have no minimum element");
        else
            System.out.println("Minimum number of above array is :  " + res);
    }

    private static int findMinNum(int[] arr) {
        if (arr.length == 0){
            return -1;
        }
        int min = arr[0]; // Integer.MAX_VALUE   - use this you are not handling if array is empty bcz this will fail for empty array. If the array is empty, you'll get an ArrayIndexOutOfBoundsException, so you need to handle this case explicitly.
        for (int num: arr){
            if (num < min)
                min = num;
        }
        return  min;
    }
}
