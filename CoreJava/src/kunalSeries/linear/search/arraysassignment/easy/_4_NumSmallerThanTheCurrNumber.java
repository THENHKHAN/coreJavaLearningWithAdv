package kunalSeries.linear.search.arraysassignment.easy;

// TODO - easy: 1365. How Many Numbers Are Smaller Than the Current Number
// ref : https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
// Hint : Brute force for each array element. AND - OR
// In order to improve the time complexity, we can sort the array and get the answer for each array element.
// Naive Approach: The simplest approach is to traverse the array and for each array element, count the number of array elements that are smaller than them and print the counts obtained.
/*
Time Complexity: O(N^2)
Auxiliary Space: O(1)
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _4_NumSmallerThanTheCurrNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n  = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n ; j++) {
                if (nums[i]>nums[j] && nums[i]!=nums[j])
                    count++;
            }
            res[i] = count;
        }
        return res;
    }

    // The second method, smallerNumbersThanCurrentOptimized, is more optimized in terms of time complexity and overall performance.
    public int[] smallerNumbersThanCurrentOptimized(int[] nums) {
        int n  = nums.length;
         // public static <T> T[] copyOf(T[] original, int newLength) - original: The array from which elements are to be copied.
                                                                        // newLength: The length of the new array. If it is greater than the length of the original array, the new array is padded with default values.
        // https://www.tutorialspoint.com/java/util/arrays_copyof_int.htm
//        https://www.geeksforgeeks.org/arrays-copyof-in-java-with-examples/
        int[] forSorting = Arrays.copyOf(nums, n);// can be used : Arrays.sort(nums) but this is in-place sorting - OR Arrays.stream(nums).sorted().toArray();

        // Sort the array in place
        Arrays.sort(forSorting); // by this the  original nums order won't change.

        System.out.println("SortedArray : " + Arrays.toString(forSorting));
        Map<Integer, Integer> map  = new HashMap<>();
        for (int i = n-1; i >=0; i--) {
            map.put(forSorting[i], i); //  counting through indices : putting indices corresponding to the indices.
            //  The index represents how many numbers are smaller
        }
        System.out.println("map : " + map); // {1=0, 2=1, 3=3, 8=4}

        for (int i = 0; i < n; i++) {
            nums[i] = map.get(nums[i]); // so that we put as the per the order the element were in original array.
        }
        return nums;
    }
    /*
    For your specific case, use Arrays.sort(nums) (in-place sorting) or make a copy of the array to keep the original intact. Avoid using Arrays.stream(nums).sorted().toArray() because of the additional overhead(for creating stream).
     */

    public static void main(String[] args) {
        _4_NumSmallerThanTheCurrNumber obj = new _4_NumSmallerThanTheCurrNumber();

        System.out.println("\n ****************  TEST CASE - 1    **********************");
        int[] nums = {8,1,2,2,3}; //  [4,0,1,1,3]
        /*
        Explanation:
                    For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
                    For nums[1]=1 does not exist any smaller number than it.
                    For nums[2]=2 there exist one smaller number than it (1).
                    For nums[3]=2 there exist one smaller number than it (1).
                    For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
         */

//        System.out.println("Number of good pairs count : " + Arrays.toString(obj.smallerNumbersThanCurrent(nums)));
        System.out.println("Number of good pairs count : " + Arrays.toString(obj.smallerNumbersThanCurrentOptimized(nums)));
System.exit(1);
        System.out.println("\n ****************  TEST CASE - 2    **********************");
        int[] nums2 = {6,5,4,8}; // [2,1,0,3]

        System.out.println("Number of good pairs count : " + Arrays.toString(obj.smallerNumbersThanCurrent(nums2)));

        System.out.println("\n ****************  TEST CASE - 3    **********************");
        int[] nums3 = {7,7,7,7}; //[0,0,0,0]


        System.out.println("Number of good pairs count : " + Arrays.toString(obj.smallerNumbersThanCurrent(nums3)));


    }
}

// ref for Optimization:  https://www.geeksforgeeks.org/count-smaller-elements-present-in-the-array-for-each-array-element/
// https://medium.com/theleanprogrammer/how-many-numbers-are-smaller-than-the-current-number-a97921755aff

// TODO comparison :
/*
   1- smallerNumbersThanCurrent

   Time Complexity: The outer loop runs n times, and for each iteration of the outer loop, the inner loop also runs n times. This results in an overall time complexity of O(n²).

Space Complexity: You use an additional res array of size n, so the space complexity is O(n).

Explanation: This method compares each number with every other number in the array, leading to a time complexity of O(n²). This can be very slow for large arrays.

 TODO - 2- smallerNumbersThanCurrentOptimized

Time Complexity:

Sorting the array: O(n log n)
Iterating through the array twice (once for filling the map and once for assigning values): O(n)
Overall: O(n log n) (because sorting dominates)

Space Complexity:

You create a copy of the array (forSorting), which takes O(n) space.
You also use a HashMap for mapping values, which takes O(n) space in the worst case.
Overall space complexity is O(n).
Explanation: This method sorts the array, which reduces the need for nested comparisons. After sorting, it creates a map of each element to its position in the sorted array, which tells us how many elements are smaller. The time complexity is dominated by the sorting step (O(n log n)), making this method much more efficient than the first one, especially for large arrays.

TODO - Conclusion:
The second method (smallerNumbersThanCurrentOptimized) is the optimized one because it has a time complexity of O(n log n), compared to the O(n²) time complexity of the first method. Sorting the array once and using a map to track the results is much more efficient than using nested loops to compare every pair of elements.
Thus, the smallerNumbersThanCurrentOptimized method is the better choice for performance, especially with larger input arrays.

 */
