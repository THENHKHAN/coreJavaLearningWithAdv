package kunalSeries.binary.search.lect4hrs.medium;


// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ     at ts:3:10:00
// Striver: https://www.youtube.com/watch?v=w2G2W8l__pc            USED for Single BS

// TODO:(amazon&Google) 81. Search in Rotated Sorted Array II - contains duplicate values : Sorted in non-decreasing order(given).Already mentioned Sorted, hence 1st approach must be Binary Search. or must write an algorithm with O(log n)
// In simply we need to search the target element index in the given array. But the issue(simple sol. is linear search but can't apply since asked in *You must decrease the overall operation steps as much as possible.)
//       So 2nd option is BS so main thing how to apply BS in this.
// Other LC ref: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/         duplicate values
// look my git or prob5 of _5_SearchInRotatedSortedArray :https://github.com/THENHKHAN/coreJavaLearningWithAdv/blob/main/CoreJava/src/kunalSeries/binary/search/lect4hrs/medium/_5_SearchInRotatedSortedArray.java
import java.util.Arrays;

public class _6_SearchInRotatedSortedArrayWithDuplicateElements {

    // this is the part that changes for if array is containing duplicates
    public int pivotWthDuplicateElementIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public boolean searchBinary(int[] nums, int target, int star, int end) {
        int l = star;
        int r = end;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==target)
                return true;
            if (nums[mid]>target)
                r = mid-1;
            else  // nums[mid]<target
                l = mid+1;

        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int pivot = pivotWthDuplicateElementIndex(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return searchBinary(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return true;
        }

        if (target >= nums[0]) {
            return searchBinary(nums, target, 0, pivot - 1);
        }

        return searchBinary(nums, target, pivot + 1, nums.length - 1);

    }

    public boolean searchSingleBinary(int[] nums, int target) {
            // based on the middle element and start element we'll decide which part is sorted.

        int l = 0;
        int r = nums.length-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==target)
                return true;

            // only this line is added in the Rotated sorted array question without duplicate
            if (nums[mid]==nums[l] && nums[mid]==nums[r]){  // skipping the duplicate element
                l++;
                r--;
                continue;
            }

            // deciding which part is sorted so that we can easily use BS type approach
            if (nums[l]<=nums[mid]){ //[3,4,5,6,7,0,1,2] then sorted  part will be LEFT SIDE (0 to mid-1)

                    // now will check in which SIDE of SORTED array will have to look into
                    if (nums[l]<=target && target<=nums[mid]) //)in range(0,mid) then we are searching in LEFT
                         r = mid-1;
                    else //  search in RIGHT
                         l = mid+1;

            } else { // nums[mid]>nums[l]  //[6,7,0,1,2,4,5]  then sorted part will be RIGHT SIDE (mid+1, r)
                if (nums[mid]<=target && target<=nums[r]) // in range(mid+1,r) then will search in LEFT
                    l = mid+1;
                else
                    r = mid-1;

            }
        }
        return false;
    }

    public static void main(String[] args) {

        _6_SearchInRotatedSortedArrayWithDuplicateElements obj = new _6_SearchInRotatedSortedArrayWithDuplicateElements();

        int[] nums = {2,5,6,0,0,1,2}; // our pivot is 6
        int target = 0;// true

//        int[] nums = {2,5,6,0,0,1,2}; // our pivot is 6
//         int target = 3;// false

//        int[] nums = {2,9,2,2,2};
//         int target = 3;// false

//         int[] nums = {3,1,2,3,3,3,3};
//         int target = 3;// true

//        int[] nums = {3,3,1,3,3,3,3};
//         int target = 3;// true


        System.out.println("Array : " + Arrays.toString(nums));
        boolean res2 = obj.search(nums, target); // with two BS
        boolean res3 = obj.searchSingleBinary(nums, target); // with single BS
        if(res3 && res2){
//            System.out.println("From LinearSearch : YES, The peak element " + nums[res1] + "  and its index is : " + res1);
            System.out.println("From Two Binary Search : YES, The peak element " + target + "  FOUND" );
            System.out.println("From Single Binary Search : YES, The target element " + target+ "  FOUND ");
        }

        else // this will never run since in constraint it said total element >= 3   hence peak element always exists.
            System.out.println("NO, we didn't found the target element" );

    }
}

// PROBLEM TO Identifying which part is sorted and which is not  : [3,1,2,3,3,3,3] ==> can't compare with start with mid or end with mid to check sorted or not.