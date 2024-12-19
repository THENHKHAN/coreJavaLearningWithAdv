package kunalSeries.linear.search.arraysassignment.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//todo - 66. Plus One
// https://leetcode.com/problems/plus-one/description/

public class _6_PlusOne {

    // failing for this: digits = [9,8,7,6,5,4,3,2,1,0]
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int i = n-1; i>=0;i--) {
            sum += (int) (digits[i]*Math.pow(10,n-i-1));
        }
        sum += 1;
        String str = String.valueOf(sum);
        int[] res = new int[str.length()];
        int i = 0;
        while (sum!=0){
            int dig = sum%10;// exacting last digit
            res[str.length()-i-1] = dig;
            sum /= 10;
            i++;
        }

        return res;
    }


    public int[] plusOneCorrect(int[] digits) {
        int n = digits.length;

        // Start from the last digit and propagate carry if necessary
        // Traverse from Right to Left: The loop starts from the last element. If the current digit is less than 9, we simply increment it and return the array because no carry is needed.
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // No carry needed, just increment the digit
                return digits;
            }
            digits[i] = 0;  // Set current digit to 0 and carry over
        }

        // If all digits are 9, we need a new array to store the result
        int[] result = new int[n + 1];
        result[0] = 1;  // The first digit is 1 and rest are 0
        /*
        Handle Carry Over: If the digit is 9, we set it to 0 (carry over) and continue checking the next digit. If we reach the leftmost digit and it's also 9, we need to extend the array by one element and set the first element to 1 (as a carry over for cases like 999 -> 1000).
         */
        return result;
    }

    // OPTIMIZED ABOVE:
    public int[] plusOneOptimized(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit and propagate carry if necessary
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // No carry needed, just increment the digit
                return digits;  // Early return after incrementing
            }
            digits[i] = 0;  // Set current digit to 0 and carry over
        }

        // If all digits are 9, extend the array
        // Create a new array with one extra digit
        digits = new int[n + 1];
        digits[0] = 1;  // The first digit is 1, and the rest are 0
        return digits;
    }

    public static void main(String[] args) {
        _6_PlusOne obj = new _6_PlusOne();

        System.out.println("\n ****************  TEST CASE - 1    **********************");
        int[] nums = {1,2,3}; // [1,2,4]
        /*
        The array represents the integer 123.
        Incrementing by one gives 123 + 1 = 124.
        Thus, the result should be [1,2,4].
         */
        System.out.println("Original Number array1 : " + Arrays.toString(nums));

        System.out.println("Plus one returned array :  " + Arrays.toString(obj.plusOneCorrect(nums)));
        System.out.println("\n ****************  TEST CASE - 2    **********************");
        int[] nums2 = {4,3,2,1}; // [4,3,2,2]

        System.out.println("Original Number array2 : " + Arrays.toString(nums2));
        System.out.println("Plus one returned array :  " + Arrays.toString(obj.plusOneCorrect(nums2)));

        System.out.println("\n ****************  TEST CASE - 3    **********************");
        int[] nums3 = {9}; //[1,0]

        System.out.println("Original Number arra3 : " + Arrays.toString(nums3));
        System.out.println("Plus one returned array :  " + Arrays.toString(obj.plusOneCorrect(nums3)));

        System.out.println("\n ****************  TEST CASE - 4    **********************");
        int[] nums4 = {9,8,7,6,5,4,3,2,1,0}; //[9,8,7,6,5,4,3,2,1,1]

        System.out.println("Original Number arra4 : " + Arrays.toString(nums4));
        System.out.println("Plus one returned array :  " + Arrays.toString(obj.plusOneCorrect(nums4)));


        // all 3 pass but
        /*
        digits = [9,8,7,6,5,4,3,2,1,0]
        expected : [9,8,7,6,5,4,3,2,1,1]
        mine = [0,-1,-2,-7,0,-9,-4,0,-4,-3,-8]
         */

    }
}
// todo - we can optimize the  plusOneCorrect() fun
// he solution can be optimized in terms of space and performance. While the solution is already quite efficient in terms of time complexity, we can make the following optimizations:
/*
Optimization Ideas:
   1-> No Extra Space: In the previous solution, we created a new array when all digits were 9 (i.e., when the input was something like [9, 9, 9], the result was [1, 0, 0, 0]). This step uses extra space (O(n + 1) for the result array). We can optimize it by modifying the array in place, reducing the space complexity to O(1) extra space (excluding the input/output).

   2-> Early Return: The solution already includes an early return when no carry is needed (i.e., when a digit is less than 9). We can keep this logic but make the carry processing simpler.

   3-> In-Place Array Modification: Instead of creating a new array, we can modify the array directly by handling the carry from right to left. If the leftmost digit needs to be changed (e.g., from 999 to 1000), we can expand the array in-place by shifting elements when necessary.

Final Optimized Approach:
  1->  Traverse the array from the rightmost side.
  2->  Handle the carry by updating the digits in-place.
  3->  If all digits are 9, handle it by extending the array in-place, with no need to create a new result array.

Optimizations Explained:
   1-> In-Place Updates: When a carry is generated, we set the current digit to 0 and move to the next one. If the current digit is less than 9, we simply increment it and return the result, avoiding the need for extra space.
   2-> Edge Case Handling: If all digits are 9, the array is expanded by one element, and the first element is set to 1, simulating the carry that propagates past the most significant digit. This results in the new number with an extra digit (e.g., 999 becomes 1000).
   3-> Space Complexity: The space complexity is O(1) for the algorithm itself, as we are modifying the array in place (only creating a new array when necessary). The space complexity for the result is O(n) for the input and output arrays, but there’s no need for extra intermediate arrays.
Performance:
  1-> Time Complexity: The time complexity is still O(n) because we only loop through the array once (in the worst case).
  2-> Space Complexity: The space complexity is O(1) extra space (excluding the space for input and output arrays), which is an improvement over the previous approach that used additional space for string conversion and new arrays.

This approach efficiently handles all cases with minimal extra space and performs well even with large inputs.
 */