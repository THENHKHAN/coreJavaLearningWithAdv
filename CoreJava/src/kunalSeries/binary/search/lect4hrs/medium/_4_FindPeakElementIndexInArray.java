package kunalSeries.binary.search.lect4hrs.medium;


// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ     at ts:2:18:00
// TODO: 852. 162. Find Peak Element in array : A peak element is an element that is strictly greater than its neighbors. (sorted in ASC as well DSC order ). hence 1st approach must be Binary Search.
// You must write an algorithm that runs in O(log n) time. HENCE BS
// Other LC ref: https://leetcode.com/problems/find-peak-element/description/


import java.util.Arrays;

// ALSO CALLED Bitonic Array  (increasing and decreasing)
public class _4_FindPeakElementIndexInArray {

    // But this will give TLE - since in the Question it asked to solve O(logN) where N is the size of array.
    // I solved it in this way linear search since i wanted go with Brute Force 1st.
    public int peakIndexInMountainArrayWithLinearSearch(int[] arr){
        int i1 = 1, i2 = 2;
            while (i1<i2){
                if (arr[i1-1] < arr[i1] && arr[i1]> arr[i2])
                    return i1;
                else {
                    i1 = i1+1;
                    i2 = i2+1;
                    if(i2>arr.length-1) // to resolving the ArrayOutOfBoundException
                        i2= arr.length-1;
                }

            }

        return -1;
    }

    public int peakElementIndexInArray(int[] arr){

        int l = 0;
        int r = arr.length-1;

        // OTHER WAY just a small tweak KUNAL: just in condition and else condition handling
        while (l<r){ // Prevents middleIndx + 1 from being out of bounds
            int middleIndx = l+(r-l)/2;

            if (arr[middleIndx]<arr[middleIndx+1])
                l = middleIndx + 1; // here taking from next of middle since mid+1 > mid so mid ele can't be the peak element
                    // here checking b/w l mid mid+1  r  => mid+1 to r
            else //(arr[middleIndx]>arr[middleIndx+1])
                r = middleIndx;  // decreasing part of array hence will look LEFT side
                // here we are taking from mid since here Decr hence it might be possible a[mid] so it can also be the ans.
                // here checking b/w l mid mid+1  r  => l to mid

        }
    return l; // l and r converge to the peak index OR // or return r as both are equal
    }


    public static void main(String[] args) {
        _4_FindPeakElementIndexInArray obj = new _4_FindPeakElementIndexInArray();

        int[] nums = {1,2,3,1}; // 2 for 3
//        int[] nums = {1,2,1,3,5,6,4}; // 1 for 2 or 5 for 6 element


//        int nums[] = new int[]{3, 5, 7, 9, 10, 7, 10, 90,  5,};  // 10 or 90 -> so index = 4 or 7 respectively
//        int[] nums = {0, 2, 1, 4, 3, 1}; //1  0r 3->


        System.out.println("Array : " + Arrays.toString(nums));
//        int res = obj.peakIndexInMountainArrayWithLinearSearch(nums);
        int res = obj.peakElementIndexInArray(nums); // with BS
        if(res !=-1)
            System.out.println("YES, The peak element " + nums[res] + "  and its index is : " + res);
        else // this will never run since in constraint it said total element >= 3   hence peak element always exists.
            System.out.println("NO, we didn't found the element peak element" );
    }
}

// TODO: See the 3_peakIndex in mountain array. FOr more detail of this solution


/*

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
            return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be
    strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */
