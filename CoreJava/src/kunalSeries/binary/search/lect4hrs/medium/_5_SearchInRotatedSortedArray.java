package kunalSeries.binary.search.lect4hrs.medium;


// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ     at ts:2:30:00
// Nikhil wo brute to OPtimzie Java wala : https://www.youtube.com/watch?v=iXLMMbdjeNM
// Aditya Board waala: https://www.youtube.com/watch?v=Id-DdcWb5AU
// NeetCode: https://www.youtube.com/watch?v=U8XENwh8Oy8
// Striver: https://www.youtube.com/watch?v=5qGrJbHhqFs
// ApnaClg: https://www.youtube.com/watch?v=6WNZQBHWQJs   used
// TODO:(amazon&Google) 33. Search in Rotated Sorted Array : Already mentioned Sorted, hence 1st approach must be Binary Search. or must write an algorithm with O(log n)
// In simply we need to search the target element index in the given array. But the issue(simple sol. is linear search but can't apply since asked in O(logn) ) So 2nd option is BS so main thing how to apply BS in this.
// Other LC ref: https://leetcode.com/problems/search-in-rotated-sorted-array/description/

import java.util.Arrays;

public class _5_SearchInRotatedSortedArray {

    public int searchLinearly(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target)
                return i;
        }
        return -1;
    }

    // this won't work for Duplicates value array
    public int pivotElement(int[] nums, int target) {

        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int m = l+(r-l)/2;
// 4 cases over here
            // case-1
            if (m<r && nums[m]>nums[m+1]) // m<r to avoid indexOutOfbound from  m+1. m<r if this false then  nums[m]<nums[m+1] won't even execute since && operator. That's m<r condition checked 1st
                return m;
            // case-2
            if (m>l  && nums[m]<nums[m-1]) // m>lto avoid indexOutOfbound from  m-1]
                return m-1;
            // case-3
            if (nums[l]>=nums[m]) // since earlier it was sorted  : 4,5,6,7,0,1,2    ex; midele = 0 then after this will be lesses than the start 4 since they earlier element before 4 hence they would be lesser.
                r = m-1;
            // case-4
            else  // (nums[l]<nums[m])
                l = m+1;

        }
       return -1;
    }

    public int searchBinary(int[] nums, int target, int star, int end) {
        int l = star;
        int r = end;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==target)
                return mid;
            if (nums[mid]>target)
                r = mid-1;
            else  // nums[mid]<target
                l = mid+1;

        }


        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = pivotElement(nums, target);

        if (pivot==-1) { // if you did not find a pivot, it means the array is not rotated
            // just do normal binary search
            System.out.println(" Did not find a pivot, it means the array is not rotated ") ;
            return searchBinary(nums, target, 0, nums.length - 1);
        }

        System.out.println("pivot indx: " + pivot  + " and pivot element : " + (pivot==-1?"No element found":nums[pivot])) ;
        int isFound = searchBinary(nums, target, 0, pivot);
        if (isFound == -1)
            return searchBinary(nums, target, pivot+1, nums.length-1);
        return isFound;
    }


    // ApnaClg: roted array can always be divided in two half: left and right - so if we divided in two part - then one will definitely be sorted and other may not(since in that pivot will lie)WHY(watch-11:00)
                            // jis part me pivot hoga uske opposite wala part sorted hoga.
    public int searchSingleBinary(int[] nums, int target) {
            // based on the middle element and start element we'll decide which part is sorted.

        int l = 0;
        int r = nums.length-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==target)
                return mid;
            // deciding which part is sorted so that we can easily use BS type approach
            if (nums[l]<=nums[mid]){ //[3,4,5,6,7,0,1,2] then sorted will part will be LEFT SORTED (mid-1 to 0)

                    // now will check in which SIDE of SORTED array will have to look into
                    if (nums[l]<=target && target<=nums[mid]) //)in range(0,mid) then will search in LEFT
                         r = mid-1;
                    else //  search in RIGHT
                         l = mid+1;

            } else { // nums[mid]<nums[l]  //[6,7,0,1,2,4,5]  then sorted will part will be RIGHT SORTED (mid+1, r)
                if (nums[mid]<=target && target<=nums[r]) // in range(mid+1,r) then will search in LEFT
                    l = mid+1;
                else
                    r = mid-1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {

        _5_SearchInRotatedSortedArray obj = new _5_SearchInRotatedSortedArray();

//        int[] nums = {4,5,6,7,0,1,2,3}; // our pivot is 7
//        int target = 0;// 4

//        int[] nums = {4,5,6,7,0,1,2}; //our pivot is 7
//        int target = 3;// -1

//         int[] nums = {4,5,6,7,0,1,2}; //our pivot is 7
//         int target = 6;// 2

//        int[] nums = {6,7,0,1,2,4,5}; //our pivot is 7
//        int target = 0;// 4

//        int[] nums = {1};
//        int target = 0;     // -1

//       int[] nums = {1,5};
//        int target = 0;     // -1
//        int target = 1;     // 0

//        int[] nums = {3,1};
//        int target = 1;     // 1

        int[] nums = {8,9,10,11,0,1,2,3,4,5,6,7};
        int target = 6;     // 10


        System.out.println("Array : " + Arrays.toString(nums));
        int res1 = obj.searchLinearly(nums, target); // with LS
        int res2 = obj.search(nums, target); // with two BS
        int res3 = obj.searchSingleBinary(nums, target); // with single BS
        if(res1 !=-1 && res2!=-1  && res3!=-1){
            System.out.println("From LinearSearch : YES, The peak element " + nums[res1] + "  and its index is : " + res1);
            System.out.println("From Two Binary Search : YES, The peak element " + nums[res2] + "  and its index is : " + res2);
            System.out.println("From Single Binary Search : YES, The peak element " + nums[res3] + "  and its index is : " + res3);
        }

        else // this will never run since in constraint it said total element >= 3   hence peak element always exists.
            System.out.println("NO, we didn't found the element peak element" );

    }
}

// TODO:                                In All Rotate sorted Array, we'll always get  PIVOT element.
/*
            0-> We can't apply OrderAgnostic approach since it is Increasing order except one element
            1-> Find Pivot element = element where given array is changing its behaviour mean ( i-1 and i+i both are greater than  the element i OR i>i+1 in ASC & i<i+1 in DSC)
            2->   Now will have two array (means we have to apply two times BS) But still solution will be in O(logN). But we can apply 3rd in single Binary .
                        a) then search in left (0, pivot)
                        b) if not found in left array then search in right array. (pivot+1, length-1)

            3-> Single Binary search
 //TODO - Learnt - && operator : if 1st condition false then didn't execute the 2nd or 3rd or any further condition will be not executed.
           In any roted array can always be divided in two half: left and right - so if we divided in two part -
                then one will definitely be SORTED and other may not
 */

// 33. Search in Rotated Sorted Array  : with distinct values means if we would have duplicates then we have tweak the logic.
/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
                        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
 */