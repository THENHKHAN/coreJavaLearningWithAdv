package kunalSeries.sortingalgo._4_cyclicsort.practice;


// kunal YT : https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20     at 1:04:00 TS
// TODO: (Amazon&Fb)- 442. Find All Duplicates in an Array : since [1, n] used in the question so directly think of CYCLE Sort concept
// Question : https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _4_FindAllDuplicateNumber {

    // not useful for this question i have added this bcz i wanted to see the sorted array as well
    public void cyclicSort(int[] arr){
        int n = arr.length;
        int i = 0 ;
        while (i<n){
            // correctIndex = value-1  // checking correct index for current element processing. It should be at this index. If yes then nothing will change and if NO, then swap the current
            // processing element(ith element) with this correctIndex.
            int correctIndex = arr[i]-1; // since values started from 1 [1, N] and since index also starts from 0
            if (correctIndex<n && arr[i] != arr[correctIndex] )  // or we can check arr[i] <= arr.length instead of correctIndex<n both are valid and correct. For ensuring the computed index is valid.
                swap(arr, i , correctIndex); // we don't have to increment i since after swapping one element  will be at the correct index but may be the other element not. check this {4,1,0,5,3,2};
                // i=0:  {3,1,0,5,4,2} 4 is at correct but not 3
            else
                i++;
        } // since behaviours is not same in each iteration Hence not using for loop . So that's y using while loop.

    }


    public void swap(int[]arr, int i , int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    public List<Integer> findAllDuplicateNumber(int[] nums) {
            int n = nums.length;
            int i = 0;

            while(i<n){
                int correctIndx = nums[i]-1; // since [1,n] range  so value -1 will be the correct index of this ith element
                if (correctIndx<n && nums[i]!=nums[correctIndx])
                    swap(nums, i, correctIndx);
                else
                    i++;
            }

            // now we have to find th duplicate num: check all element if any element is not equal to index+1 then that will be our answer
        // and collect into list
        List<Integer> lst = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] != j+1)
                lst.add(nums[j]);
        }
            return lst;
        }

    public static void main(String[] args) {
        _4_FindAllDuplicateNumber obj = new _4_FindAllDuplicateNumber();

//        int[] arr = {4,3,2,7,8,2,3,1}; // [2,3],  // lc test case-1 - after sorting [1, 2, 3, 4, 3,2,7,8] - ignore the repeated number
//        int[] arr = {1,1}; // 1,
//        int[] arr = {1,1,2}; // [1],
        int[] arr = {1}; // [],

        System.out.println("Original Array: " + Arrays.toString(arr));
        List<Integer> repeatedNumber = obj.findAllDuplicateNumber(arr);
        obj.cyclicSort(arr);
        System.out.println("After Cyclic Sort Array: " + Arrays.toString(arr));
        System.out.println("Missing number from above Array: " + repeatedNumber);
    }
}
//TODO: intuition - all the integers of nums are in the range [1, n] also  must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output