package kunalSeries.linear.search.arraysassignment.easy;

// TODO: 1389. Create Target Array in the Given Order
// Question : https://leetcode.com/problems/create-target-array-in-the-given-order/
// here my own explanation on leetcode : https://leetcode.com/problems/create-target-array-in-the-given-order/solutions/6156618/east-to-understand-java-solution-100-0ms-ambq/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _5_CreateTargetArrInTheGivenOrder {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> lstTarget = new ArrayList<>();
        int[] targetArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lstTarget.add(index[i], nums[i]);
        }

        for (int i = 0; i < lstTarget.size(); i++) {
            targetArr[i] = lstTarget.get(i);
        }
        System.out.println("Target Array : " + Arrays.toString(targetArr));
        return targetArr;
    }


    public static void main(String[] args) {


        _5_CreateTargetArrInTheGivenOrder obj = new _5_CreateTargetArrInTheGivenOrder();

        System.out.println("\n ****************  TEST CASE - 1    **********************");
        int[] nums1 = {0,1,2,3,4};
        int[] index1 = {0,1,2,2,1};
        // Output : 0,4,1,3,2

        /*
        Explanation:
            Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
         */

        System.out.println("Create Target Array in the Given Order  : " + Arrays.toString(obj.createTargetArray(nums1, index1)));
        System.out.println("\n ****************  TEST CASE - 2    **********************");
        int[] nums2 = {1,2,3,4,0};
        int[] index2 = {0,1,2,3,0};
        // Output :[0,1,2,3,4]
//
        System.out.println("Create Target Array in the Given Order  : " + Arrays.toString(obj.createTargetArray(nums2, index2)));

        System.out.println("\n ****************  TEST CASE - 3    **********************");
        int[] nums3 = {1};
        int[] index3 = {0};
        // Output :[1]

        System.out.println("Create Target Array in the Given Order  : " + Arrays.toString(obj.createTargetArray(nums3, index3)));


    }
}

/* TODO- little bit about complexity: - more detail u can see on the above my solution link.

Time Complexity Analysis:
    Problem Recap:
        We are inserting elements from the nums array into the targetArr based on the index array, and the insertions
            can potentially require shifting elements in the array to make room.

        The key part of the time complexity is the insertion operation. Specifically, the ArrayList.add(index[i], nums[i])
        operation takes time proportional to the number of elements that need to be shifted to accommodate the new element at a specific index.

Worst-Case Analysis:


    Insertion Operation:
        -> For each element in nums, we are inserting it into the list at a position specified by the index array.
        -> In the worst case, if we insert an element at the beginning or middle of the list (especially for the first few elements), we may have to shift all subsequent elements.
        -> The shift operation is proportional to the number of elements already in the list, meaning that the insertion of the i-th element could require up to
                O(i) operations.
        For example:
                -> The first element can be inserted in constant time O(1).
                -> The second element might require shifting 1 element.
                -> The third element might require shifting 2 elements, and so on.
       The total number of shifts over all insertions would be:
                            0+1+2+⋯+(n−1)= n(n−1)/2 = O(n^2)
    So, the total time complexity of inserting all elements is indeed
        O(n^2) because each insertion could require shifting up to n elements in the worst case, and this happens for each of the n elements.

Why Not O(n)?
    If we were inserting at the end of the list, the insertion operation would be O(1), but since we are inserting at arbitrary positions, the shifting of elements causes the complexity to increase.

    Thus, the time complexity remains O(n^2) in the worst case, not O(n), because of the element shifting.

Space Complexity:
        The space complexity remains O(n) because we're using an additional ArrayList (or array) to hold the elements temporarily before converting it into the final array, which requires space proportional to the size of the input arrays (nums and index).

Final Conclusion:
        Time Complexity: O(n^2), due to the shifting of elements during each insertion.
        Space Complexity: O(n), due to the extra storage needed for the result array (targetArr).

I hope this clears up any confusion! Let me know if you have any more questions or need further clarification.

 */
