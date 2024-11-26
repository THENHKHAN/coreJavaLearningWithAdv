package kunalSeries.binary.search.assignment.easy;

import kunalSeries.binary.search.assignment.medium._1_findMinInRotatedSortedArr;
// TODO : 35. Search Insert Position : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// https://leetcode.com/problems/search-insert-position/description/
// ref: https://takeuforward.org/arrays/search-insert-position/                  but i have used my own. it just ref
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
/*
TODO: Sorted in ASC and ask for O(log n) hence BS used
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 */