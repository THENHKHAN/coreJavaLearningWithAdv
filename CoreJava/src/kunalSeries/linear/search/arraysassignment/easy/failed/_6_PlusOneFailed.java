package kunalSeries.linear.search.arraysassignment.easy.failed;

import java.util.Arrays;

public class _6_PlusOneFailed {

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

    public static void main(String[] args) {
        _6_PlusOneFailed obj = new _6_PlusOneFailed();

        System.out.println("\n ****************  TEST CASE - 1    **********************");
        int[] nums = {1,2,3}; // [1,2,4]
        /*
        The array represents the integer 123.
        Incrementing by one gives 123 + 1 = 124.
        Thus, the result should be [1,2,4].
         */
        System.out.println("Original Number array1 : " + Arrays.toString(nums));

        System.out.println("Plus one returned array :  " + Arrays.toString(obj.plusOne(nums)));
        System.out.println("\n ****************  TEST CASE - 2    **********************");
        int[] nums2 = {4,3,2,1}; // [4,3,2,2]

        System.out.println("Original Number array2 : " + Arrays.toString(nums2));
        System.out.println("Plus one returned array :  " + Arrays.toString(obj.plusOne(nums2)));

        System.out.println("\n ****************  TEST CASE - 3    **********************");
        int[] nums3 = {9}; //[1,0]

        System.out.println("Original Number arra3 : " + Arrays.toString(nums3));
        System.out.println("Plus one returned array :  " + Arrays.toString(obj.plusOne(nums3)));

 // all 3 pass but
        /*
        digits = [9,8,7,6,5,4,3,2,1,0]
        expected : [9,8,7,6,5,4,3,2,1,1]
        mine = [0,-1,-2,-7,0,-9,-4,0,-4,-3,-8]
         */
    }
}
