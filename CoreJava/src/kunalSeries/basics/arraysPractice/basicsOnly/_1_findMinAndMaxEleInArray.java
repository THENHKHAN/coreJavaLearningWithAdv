package kunalSeries.basics.arraysPractice.basicsOnly;

import java.util.Arrays;

public class _1_findMinAndMaxEleInArray {

    public int findMax(int[] arr){
        int ans = -1;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i]>=max){
                max = arr[i];
                ans = i;
            }
        }
        return ans;
    }

    public int findMin(int[] arr){
        int ans = -1;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<=min){
                min = arr[i];
                ans = i;
            }
        }
       return ans;
    }

    public static void main(String[] args) {

        _1_findMinAndMaxEleInArray obj = new _1_findMinAndMaxEleInArray();

//        int[] nums = {15, 18, 2, 3, 6, 12}; // 2
        int[] nums = {7, 9, 11, 12, 5}; // 4


        System.out.println("Array : " + Arrays.toString(nums));
        int max = obj.findMax(nums);
        int min = obj.findMin(nums); // with two BS
        System.out.println("MAX element indx:  " + max + " and element : " + nums[max]);
        System.out.println("MIN element indx:  " + min + " and element : " + nums[min]);
    }

}
