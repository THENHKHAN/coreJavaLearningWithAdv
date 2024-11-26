package kunalSeries.binary.search.assignment.easy;

import kunalSeries.binary.search.assignment.medium._1_findMinInRotatedSortedArr;

import java.util.Arrays;

public class _1_SearchInsertPosition {


    public int searchInsert(int[] nums, int target) {

        int l = 0;
        int r = nums.length-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]>target)
                r = mid-1;
            else if (nums[mid]<target)
                l = mid+1;
            else // nums[mid]==target  found element
                 return mid;
        }

        return l;

    }

    public static void main(String[] args) {
        _1_SearchInsertPosition obj =new _1_SearchInsertPosition();
//        int[] nums = {1,3,5,6};
//        int target = 5; // 2

//        int[] nums = {1,3,5,6};
//        int target = 2; // 1

//        int[] nums = {1,3,5,6};
//        int target = 7; // 4

        int[] nums = {1,3};
        int target = 2; // 1

//        int[] nums = {1,3};
//        int target = 0; // 0

        System.out.println("Array : " + Arrays.toString(nums));
        int insertPosition = obj.searchInsert(nums, target);
        System.out.println("The Search insert position is: " + insertPosition);

    }
}
