package kunalSeries.linear.search.arraysassignment.easy;

// TODO - easy: 1512. Number of Good Pairs
// ref : https://leetcode.com/problems/number-of-good-pairs/description/
// hint given on question : Count how many times each number appears. If a number appears n times, then n * (n – 1) // 2 good pairs can be made with this number.
// just for future ref: https://leetcode.com/problems/number-of-good-pairs/solutions/6143082/count-good-pairs-using-frequency-array-beats-100/
import java.util.ArrayList;
import java.util.List;

public class _3_NumOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {

        int goodPairsCount = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {

                if (nums[i]==nums[j])
                    goodPairsCount++;
            }

        }

        return goodPairsCount;
    }

    public static void main(String[] args) {
        _3_NumOfGoodPairs obj = new _3_NumOfGoodPairs();

        System.out.println("\n ****************  TEST CASE - 1    **********************");
        int[] nums = {1,2,3,1,1,3}; // 4
        // There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

        System.out.println("Number of good pairs count : " + obj.numIdenticalPairs(nums));

        System.out.println("\n ****************  TEST CASE - 2    **********************");
        int[] nums2 = {1,1,1,1}; // 6
        // Each pair in the array are good.

        System.out.println("Number of good pairs count : " + obj.numIdenticalPairs(nums2));

        System.out.println("\n ****************  TEST CASE - 3    **********************");
        int[] nums3 = {1,2,3}; //0


        System.out.println("Number of good pairs count : " + obj.numIdenticalPairs(nums3));

    }
}