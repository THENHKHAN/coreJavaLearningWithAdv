package kunalSeries.linear.search.arraysassignment.easy;

// TODO:  1470. Shuffle the Array
// https://leetcode.com/problems/shuffle-the-array/description/
// used one new array to fill with the existing
// another ref: https://algo.monster/liteproblems/1470
import java.util.Arrays;

public class _1_SuffleArray {

    public int[] shuffle(int[] nums, int n) {
        int[] suffleArray = new int[2*n];

        for (int i = 0; i < n; i++) {
            suffleArray[2 * i] = nums[i];       // Place xi
            suffleArray[2 * i + 1] = nums[n + i]; // Place yi
        }

        return suffleArray;
    }

    public static void main(String[] args) {
        _1_SuffleArray obj = new _1_SuffleArray();
        int[] arr = {2,5,1,3,4,7};
        int n = 3;

        int[] arr1 = {1,2,3,4,4,3,2,1};
        int n1 = 4;

        int[] arr2 = {1,1,2,2};
        int n2 = 2;

        System.out.println("================   Test case -1      =================");
        System.out.println("Original Array " + Arrays.toString(arr));
        System.out.println("Shuffled Array : " + Arrays.toString(obj.shuffle(arr, n))); // [2, 3, 5, 4, 1, 7]


        System.out.println("\n================   Test case -2      =================");

        System.out.println("Original Array " + Arrays.toString(arr1));
        System.out.println("Shuffled Array : " + Arrays.toString(obj.shuffle(arr1, n1))); //[1, 4, 2, 3, 3, 2, 4, 1]
//
        System.out.println("\n================   Test case -3      =================");
        System.out.println("Original Array " + Arrays.toString(arr2));
        System.out.println("Shuffled Array : " + Arrays.toString(obj.shuffle(arr2, n2))); // [1, 2, 1, 2]


    }
}

/*
11dec24: Basic manupulation with accessing elements
TC and SC : O(n)
but It can be solved in O(1) space. Will explore later

-->  If an O(1) space solution is required, in-place shuffling techniques can be explored (though they are more complex and may involve bit manipulation or other tricks).

 */
/*
1- The input array nums has 2 * n elements, with the first half being x1, x2, ..., xn and the second half being y1, y2, ..., yn.
2- In the loop:
                At each iteration, you place nums[i] (from the x part) at an even index (2 * i).
                You place nums[n + i] (from the y part) at the next odd index (2 * i + 1).

 */