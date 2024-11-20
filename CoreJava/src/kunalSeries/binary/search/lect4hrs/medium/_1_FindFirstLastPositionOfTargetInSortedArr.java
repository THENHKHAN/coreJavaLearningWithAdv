package kunalSeries.binary.search.lect4hrs.medium;

import java.util.Arrays;

// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=16     at ts:1.02:00
// TODO: 34. Find First and Last Position of Element in Sorted Array : Since sorted hence 1st approach must be Binary Search.
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class _1_FindFirstLastPositionOfTargetInSortedArr {

    // WON'T ACCEPT SINCE it takes O(n) and  required O(logN) hence Binary search
    public int[] searchRangeWithLinearBruteForce(int[] nums, int target) {
     // starts searching from left and then right
        int[] pos = {-1, -1};
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] == target) {
                pos[0] = l;
                break;
            }
        }

        for (int r = nums.length-1 ; r >= 0; r--) {
                if (nums[r]==target){
                    pos[1] = r;
                    break;
                }
        }

        return pos;
    }

    public int search1(int[] arr, int target, boolean isStart){
        int ans = -1;
        int l = 0;
        int r = arr.length-1;
        int middleIndx = 0;
        if (isStart){
                while (l<=r){
                    middleIndx = l + (r-l)/2;
                    if (arr[middleIndx] > target)
                        r = middleIndx-1;
                    else if (arr[middleIndx]<target)
                        l = middleIndx+1;
                    else {
                        ans = middleIndx;
                        r = middleIndx-1; // Have to look LEFT to this middle element. searching the start position.
                    }
                }
        } else { // for finding last position
              while (l<=r){
                  middleIndx = l +(r-l)/2;
                  if (arr[middleIndx]>target)
                      r = middleIndx-1;
                  else if (arr[middleIndx]<target)
                      l = middleIndx+1;
                  else {
                      ans = middleIndx;
                      l = middleIndx+1;// Have to look RIGHT to this middle element. searching the Last position.
                  }
              }
        }
        return ans;
    }

    public int search2ReducingCodeInWhileLoop(int[] arr, int target, boolean isStart){
        // since both if and else of outer having some code common like both the if and else if code same. Only difference is in while loop else part.
        int ans = -1;
        int l = 0;
        int r = arr.length-1;
        int middleIndx = 0;
        while (l<=r){
                middleIndx = l + (r-l)/2;
                if (arr[middleIndx] > target)
                    r = middleIndx-1;
                else if (arr[middleIndx]<target)
                    l = middleIndx+1;
                else {
                        if (isStart){
                            ans = middleIndx;
                            r = middleIndx-1; // Have to look LEFT to this middle element. searching the start position.
                        } else {
                            ans = middleIndx;
                            l = middleIndx+1;// Have to look RIGHT to this middle element. searching the Last position.
                        }
                     }
            }
        return ans;
    }


    // It will be accepted since O(logN) where N is the size of array. But we can manage in one Binary not two way.
    public int[] searchRangeBinaryWithBinarySearch(int[] nums, int target) {
        int[] pos = {-1, -1};
        int l = 0;
        int r = nums.length-1;
        pos[0]  = search2ReducingCodeInWhileLoop(nums,target, true);
        pos[1] = search2ReducingCodeInWhileLoop(nums,target, false);
//        System.out.println("first position : " + startPos);
//        System.out.println("last position : " + lastPos);
//        pos[0] = startPos;
//        pos[1] = lastPos;
//        System.out.println("Pos : " + Arrays.toString(pos));

        return pos;
        }

    public static void main(String[] args) {
        _1_FindFirstLastPositionOfTargetInSortedArr obj =new _1_FindFirstLastPositionOfTargetInSortedArr();

//        System.out.println("hello");
//        System.exit(1);

//        int[] nums = {5,7,7,8,8,10};
//        int target = 8; // {3, 4}

//        int[] nums = {5,7,7,8,8,10};
//        int target = 6; // {-1, -1}

         int[] nums = {};
         int target = 0; // {-1, -1}

//         int[] nums = {5,7,7,7,7,8,10};
//        int target = 7; // {1, 4}

//        int[] res = obj.searchRangeWithLinearBruteForce(nums, target); working grt
        int[] res = obj.searchRangeBinaryWithBinarySearch(nums, target);
        System.out.println("Find First and Last Position of Element: " + target +" in Sorted Array :  " + Arrays.toString(res));

    }
}

/*
 * Why BS : Since sorted hence 1st approach must be Binary Search 1st.
 * We divided array in two part and assuming left will give me start index and right part will give me last position.
                  When we did in Two Binary Search. We have One BS as well see the Brute as well.
 */



/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 */
