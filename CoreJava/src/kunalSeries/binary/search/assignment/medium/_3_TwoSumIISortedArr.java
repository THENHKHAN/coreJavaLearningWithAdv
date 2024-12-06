package kunalSeries.binary.search.assignment.medium;

import java.util.Arrays;

// TODO : 167. Two Sum II - Input Array Is Sorted :  Intuition for BS - sorted in non-decreasing order,
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// REF: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solutions/5101915/video-using-two-pointers-to-solve-the-question-with-o-1-space/
// TODO: Approach Explained below
public class _3_TwoSumIISortedArr {


    // working good  - accepted
    public int[] twoSumIIBrute(int[] numbers, int target) {
        int[] res = new int[]{-1,-1};

        for (int i = 0; i <numbers.length ; i++) {
            // traversing each element
            for (int j = i+1; j < numbers.length; j++) {
                    if (numbers[i]+numbers[j] == target){
//                    if (numbers[i]+numbers[j] == target && numbers[i]!=numbers[j]){
                        res[0] = i+1;
                        res[1] = j+1;
                        return res;
                    }
            }
        }
       return res;
    }


    public int[] twoSumIIBinarySearch(int[] numbers, int target) {
        int[] res = new int[]{-1,-1};
        int l = 0;
        int r = numbers.length-1;
        // here we'll move both the pointer and no need for middle index concept
      // Move both the pointer and there is no need for Middle index find since we need two element simultaneous at once.
        while (l<r){
            if (numbers[l]+numbers[r]==target){
                res[0] = l+1;
                res[1] = r+1;
                return res;
            } else if (numbers[l]+numbers[r]<target) {  // go right: since every element before arr[l] add with arr[r] will be lesser
                l++;
            } else { // numbers[l]+numbers[r]>target   -- go left
                r--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        // INFO:  1-indexed array of integers
        _3_TwoSumIISortedArr obj =new _3_TwoSumIISortedArr();
//        int[] nums = {2,7,11,15}; //The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//        int target = 9; //  [1,2]  // since index asked from 1 not 0. We have to add in the indices 1 before returning from twoSumII() FUN.

//        int[] nums = {2,3,4}; // The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
//        int target = 6; //  [1,3]

//        int[] nums = {-1,0}; // The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
//        int target = -1; //  [1,2]

//        int[] nums = {0,0,3,4}; // The sum of 1 and 2 is 0. Therefore index1 = 1, index2 = 2. We return [1, 2].
//        int target = 0; //  [1,2]

        int[] nums = {-3, 1,2,4}; // The sum of 1 and 2 is 0. Therefore index1 = 1, index2 = 2. We return [1, 2].
        int target = -1; //  [1,3]


        System.out.println("Array : " + Arrays.toString(nums));
        int[] resLS = obj.twoSumIIBrute(nums, target);
        int[] resBS = obj.twoSumIIBrute(nums, target);
        System.out.println("LS- Two Sum of These Two Indices:  " + Arrays.toString(resLS));
        System.out.println("BS- Two Sum of These Two Indices:  " + Arrays.toString(resBS));
    }
}
/*

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
            Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:

2 <= numbers.length <= 3 * 10^4
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order. // TODO- since sorted and we need search HENCE Binary Search
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */

/* TODO: Approach
If you know Two Sum question that is the first question of LeetCode, you can solve this question with HashMap.
    But HashMap solution should O(n) space. The description says "Your solution must use only constant extra space",
    so you need to change your strategy.
ref: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solutions/5101915/video-using-two-pointers-to-solve-the-question-with-o-1-space/
 */