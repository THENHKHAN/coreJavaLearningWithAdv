package kunalSeries.binary.search.assignment.medium;

import java.util.Arrays;
// TODO : 153 Find Minimum in Rotated Sorted Array : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// GFG : https://www.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/0
// https://www.enjoyalgorithms.com/blog/minimum-in-sorted-and-rotated-array
public class _1_findMinInRotatedSortedArr {

    public int findMinimalEleIndx(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int ind = -1 ;
        int ans = arr[0];
        while (l<=r) {


            // if not rotated
            // The current subarray is already sorted,
            // the minimum is at the l index
            if (arr[l]<=arr[r]){
                    ind = l;
//                    System.out.println("not rotated");
                break;
            }

            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
            int mid = l+(r-l)/2;


            // if left part is sorted:  arr[0] <= ar[mid]
            // The right half is not sorted. So
            // the minimum element musSSSSSSSStt be in the right half.
            if (arr[mid]>=arr[l]){    // this may be the case when [4, 7] => two element 1/2 => midle index 0. already handled in 1st case.
                    if (arr[mid]<ans){
                        ans = arr[mid];
                        ind = mid;
                    }
                 l = mid+1;
            }
            else { // mid<l :   RIGHT part is sorted:
                    if (arr[mid]<ans){
                        ind = mid;
                        ans = arr[mid];
                    }
                // The right half is sorted. Note that in
                // this case, we do not change high to mid - 1
                // but keep it to mid. The mid element
                // itself can be the smallest [15,18,1,2,3] ==> mid = 1<15 so will look low to mid since. here will be searching from (0,mid) Ex- {15, 18, 2, 3, 6, 12};
                    r = mid;
                                    // skipping right part : since if mid<start (already checked) ==> start will always be greater than the right side from middle.
            }

        }

        return ind;
    }

    public static void main(String[] args) {
        _1_findMinInRotatedSortedArr obj =new _1_findMinInRotatedSortedArr();
//        int[] nums = {5, 1, 2, 3, 4}; // 1
//        int[] nums = {15, 18, 2, 3, 6, 12}; // 2 -- IMP mid<arr[0]
//        int[] nums = {7, 9, 11, 12, 5}; // 4    -- mid>=arr[0]
//        int[] nums = {1,2,3,4,5}; // 0
//        int[] nums = {10,4}; // 1
//        int[] nums = {1,4}; // 0   -- mid>=arr[0]
//        int[] nums = {4, 1,2,3}; // 1
//        int[] nums = {4,5,1,2,3}; // 1
//        int[] nums = {3,4,5,1,2}; // 1
        int[] nums = {24, 27, 45, 58, 61, 62, 64, 78, 81, 5}; // 9
//        int[] nums = {39, 6, 11, 14, 18, 36, 37, 38}; // 1

        System.out.println("Array : " + Arrays.toString(nums));
        int minIdx = obj.findMinimalEleIndx(nums);
        System.out.println("MIN element indx:  " + minIdx + " and element : " + nums[minIdx]);
    }
}
/*

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 */