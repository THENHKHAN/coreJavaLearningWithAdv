package kunalSeries.stringassignment.medium;

// medium level
// TODO: 55. Jump Game -
// https://leetcode.com/problems/jump-game/description/
public class _0_JumpGame {

    // When do you know for sure that you can reach the last index? (Hint: If the farthest reachable position is greater than or equal to the last index.)
   // TODO: Failing -reason is in failed. java file of this
    public boolean canJumpWrong(int[] nums) {
        int n = nums.length;
        int prevStepCovered = -1;
        if (n == 1)
            return true;  // Arrays with a single element (you’re already at the last index, so the answer is true).

        for (int i = 0; i < n; i++) {
//            System.out.println("item : " + nums[i]);
            if (nums[i] == 0) {
                return false;
            } else {
                if (nums[i] >= n - 1 || nums[i] >= (n - 1) - i) {

//                   System.out.println("item reached: " + nums[i]);
                    return true;
                }
            }

        }

        return false;
    }

    // TODO- Kind of Greedy ALGO Used (haven't learnt this ALgo yet but seems easy and normal approach)
    public boolean canJump(int[] nums) {
    int n = nums.length;

    if(n ==1)return true; // Single element array is trivially true

    int farthest = 0; // Tracks the farthest index we can reach

    for(int i = 0; i<n; i++) {
        // If the current index is beyond the farthest reachable point, we can't proceed
                if (i > farthest) {
                    return false;
                }

                // Update the farthest index we can reach from this point
                farthest = Math.max(farthest, i + nums[i]); // use Striver

                // If we can already reach or surpass the last index, return true
                if (farthest >= n - 1) {
                    return true;
                }
      }

    return false; // If we exit the loop without reaching the end

}

    public static void main(String[] args) {
       _0_JumpGame obj = new _0_JumpGame();
//       int[] arr = {2,3,1,1,4}; // true  - Jump 1 step from index 0 to 1, then 3 steps to the last index.
//       int[] arr = {3,2,1,0,4}; // false - You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
        // TODO- tip - if array don't have any zero then it will always be true since they will jump t least one jump so they will definitely reach to the END.
        // Example cases
        System.out.println(obj.canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(obj.canJump(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(obj.canJump(new int[]{3,0,8,2,0,0,1})); // true   - last 1st Fun is failed in this test case.

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

/*
Correcteddddddddddddddddddddddddd Approach:
To make your solution work without using advanced techniques:

1- Use a variable to track the farthest index you can reach dynamically as you iterate through the array.
2- At each index i, check if you can update the farthest index based on nums[i].
3- If at any point your current index exceeds the farthest reachable index, it means you can't proceed further, and the answer is false.
4- If the farthest reachable index is greater than or equal to n-1 by the end, return true.



 */