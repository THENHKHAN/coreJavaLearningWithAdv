package kunalSeries.sortingalgo._4_cyclicsort.practice;


// kunal YT : https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20     at 01:21:00 TS
// TODO: Amazon , 41. First Missing Positive : Not directly mentioned the range [0,n] or [1,n] that's y Hard level.
// But this is  a  kind of Hint: integer that not present(missing something type) in nums. You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
// Question : https://leetcode.com/problems/first-missing-positive/description/
// ref: https://algo.monster/liteproblems/41
// Difficult of this problem was to figure out what ALGO we should use to tackle this problem. Well i have explained well below
// READ below , we have explained very well
import java.util.Arrays;

public class _6_FirstMissingPositiveNumber {

        public void swap(int[]arr, int i , int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

    public int findFirstMissingPositiveNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        // Cycle Sort
        while (i<n){
            int correctIndex = nums[i]-1; // since correctIndx = value-1 since [1 N] case-1 type
            // Only place nums[i] at correctIndex if it's within the valid range and not already in the correct position
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) // skipping negative number and out of bound index
                    swap(nums, i, correctIndex);// Swap only if the number is not already in the correct position
            else //  Move to the next element if no swap needed
                i++; // since correctIndex might be -ve since we could have negative number as well so skipping it
// the above nested if else we add multiple && operator in one if that will also work.
        }
        // to traver the array and if you found any element that is not equal to the index(ith) then that index will be our answer.
       // search for first missing number : // Find the first index where nums[i] != i + 1, that index + 1 is the missing number
        for (int j = 0; j < n; j++) {
            if (nums[j] != j+1 )
                return j+1;
        }

        // case-2 if all the number present like in below array.
        // if all the index value present at their correct index then there is only one number that is missing the length of array.
        return n+1 ;// if all present then the last index element will be missing that it did not encounter the return statement(after traversing loop) since loop end(last index = length-1) successfully without intern
        // If all positions are correct, the missing number is n + 1
        // why n+1 and not n only - ex : [1,2,3] - n=3 , counting from 1 there are all at correct index hence n+1
    }

    public static void main(String[] args) {
        _6_FirstMissingPositiveNumber obj = new _6_FirstMissingPositiveNumber();

//        int[] arr = {1,2,0}; // 3,  // lc test case-1
//        int[] arr = {3,4,-1,1}; // 2,  // lc test case-2
//        int[] arr = {7,8,9,11,12}; // 1,  // lc test case-3
//        int[] arr = {0,1}; // 2,  // lc test case-1 - mine
//        int[] arr = {1,2,3}; //4 ,  // lc test case-2 - mine
        int[] arr = {1,2,-3}; //3 ,  // lc test case-3 - mine
        System.out.println("Original Array: " + Arrays.toString(arr));
        int firstMissingPositiveNumber = obj.findFirstMissingPositiveNumber(arr);
        System.out.println("After Cyclic Sort Array: " + Arrays.toString(arr));
        System.out.println("First Missing Positive number from above Array: " + firstMissingPositiveNumber);
    }
}
// TODO: My Approach : The problem is asking for the smallest positive integer missing from the array. The key insight is that for an array of size n, the smallest missing positive integer must be in the range from 1 to n+1.
                  //Each number should ideally be at the position nums[i] = i + 1 if it is a valid number in the range [1, n].
/*
0--> We can solve this problem using a technique that leverages the indexing of the array itself as a marker. so there is one ALGO i.e. Cyclic Sort concept which works on the index basis
        for finding some number if missing in some range (Here range is deciding by positive integers - smallest positive integer ). i.e 1.......n : so in this case number could be 1 ,2 ... or n+1.
1--> ignore the negative number, 0 and num>n (maximum could be n but not more than n),  since asked for positive(+) number only
2--> Always start checking from 1 : does 1 exist in the array if not then that will be ans. If exist then look for 2 same way.
3--> so step-2 is a kind of hint (approaching from 1 since cyclic sort applicable for + number only)
4--> so we can use the missing number code but here ignore the negative and zero number.

Another Intuition:
The intuition behind the solution comes from the realization that the smallest missing positive integer must be within the range [1, n+1],
    where n is the length of the array. This is because, in the worst case, the array contains all consecutive positive integers from 1 to n.

why not 0 including :
    -> The range of interest is positive integers, so it will starting from 1.
    -> 0 is an integer, but it is non-positive. The problem explicitly requires finding the smallest positive integer, and 0 does not meet this criterion.
    -> Negative numbers and zero are ignored since they cannot be part of the sequence [1, 2, 3, ...].
EX: nums = [0, -1, 3, 1]
        After ignoring non-positive numbers (0, -1), the array becomes [3, 1] (logically).
        The positive integers we care about are [1, 2, 3, ...].
        The smallest missing positive integer is 2.


Key Clarifications:
    Does it include numbers up to n + 1? Yes, the smallest missing positive number can go up to n + 1 because:
    If the array contains all numbers [1, 2, 3, ..., n], the next missing positive will be n + 1.
Example:
    Input: nums = [1, 2, 3]
    Output: 4
    Explanation: All integers from 1 to 3 are present, so the missing number is 4.

Another Intuition:

The cyclic sort concept is particularly well-suited for problems that involve finding the smallest missing positive
    integer because it allows us to place each element in its correct position in the array without needing extra space
    or additional sorting algorithms. The intuition behind using cyclic sort here is to leverage the index-based mapping
    and directly place each element in its "correct" index, which corresponds to the number itself.

 OR:
 The problem is asking for the smallest positive integer missing from the array. The **key insight** is that for an array of size n, the smallest missing positive integer must be in the range from 1 to n+1.
    Each number should ideally be at the position nums[i] = i + 1 if it is a valid number in the range [1, n].
 */
/*
Question Statement:
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

Constraints:

1 <= nums.length <= 105
-2^31 <= nums[i] <= 2^31 - 1
 */