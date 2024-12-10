package kunalSeries.stringassignment.medium;

// medium level
// TODO: 55. Jump Game - WHY IT FAILED read below
// https://leetcode.com/problems/jump-game/description/
public class _0_JumpGameFailedWhy {

    // When do you know for sure that you can reach the last index? (Hint: If the farthest reachable position is greater than or equal to the last index.)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int prevStepCovered = -1;
        if(n==1)
            return true;  // Arrays with a single element (you’re already at the last index, so the answer is true).

        for (int i = 0; i < n ; i++) {
//            System.out.println("item : " + nums[i]);
           if (nums[i] == 0){
               return false;
           } else{
               if ( nums[i]>=n-1 || nums[i] >= (n-1)-i ){

//                   System.out.println("item reached: " + nums[i]);
                   return true;
               }
           }

        }

    return false;
    }

    public static void main(String[] args) {
       _0_JumpGameFailedWhy obj = new _0_JumpGameFailedWhy();
//       int[] arr = {2,3,1,1,4}; // true  - Jump 1 step from index 0 to 1, then 3 steps to the last index.
//       int[] arr = {3,2,1,0,4}; // false - You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

        // Example cases
        System.out.println(obj.canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(obj.canJump(new int[]{3, 2, 1, 0, 4})); // false

        // Edge cases
        System.out.println(obj.canJump(new int[]{0})); // true
        System.out.println(obj.canJump(new int[]{1, 0})); // true
        System.out.println(obj.canJump(new int[]{0, 1})); // false
        System.out.println(obj.canJump(new int[]{2, 0, 0})); // true

//       boolean res = obj.canJump(arr);
//        if (res){
//            System.out.println("Yes, We can reach the last index");
//        } else
//            System.out.println("No, We can't reach the last index");
    }
}

// CASE - nums =[3,0,8,2,0,0,1] - expected true but my output was false.
/*
TODO- Look why it failed:
Your code has the correct idea of checking if you can reach the last index by iterating through the array and evaluating the jump capability at each position. However, there are logical flaws that will lead to incorrect results.

Problemssssssssssssssssssssssssss in the Code:
1- Misinterpretation of nums[i]:

    nums[i] represents how far you can jump from index i. It doesn't necessarily need to equal (n-1)-i or n-1 directly to determine reachability. You need to check if you can "cover" the last index from that position, either directly or through other jumps.
    For example, in nums = [2, 3, 1, 1, 4], at i=0, nums[0]=2 can only reach index 2. However, you can still jump further from subsequent indices. Your condition misses this chaining aspect.

2- Early Termination on nums[i] == 0:

    If nums[i] == 0, it doesn't always mean you can't reach the last index. Whether or not 0 blocks you depends on whether a previous jump can "skip over" this position.
    Example: nums = [3, 2, 1, 0, 4] — A 0 at index 3 is reachable, and you can continue past it.

3- prevStepCovered Is Unused:

    You define prevStepCovered = -1, but it doesn't play any role in your logic.

4- Return Conditions:

    Your logic to return true on nums[i] >= n-1 or nums[i] >= (n-1)-i is too restrictive and doesn't allow for dynamic chaining of jumps.


Correcteddddddddddddddddddddddddd Approach:
To make your solution work without using advanced techniques:

1- Use a variable to track the farthest index you can reach dynamically as you iterate through the array.
2- At each index i, check if you can update the farthest index based on nums[i].
3- If at any point your current index exceeds the farthest reachable index, it means you can't proceed further, and the answer is false.
4- If the farthest reachable index is greater than or equal to n-1 by the end, return true.



 */