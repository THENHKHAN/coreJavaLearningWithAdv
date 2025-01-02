package kunalSeries.basics.concepts.maths.bitwiseoperator.practice;

import java.util.Arrays;
// TODO - LC : 136. Single Number - https://leetcode.com/problems/single-number/description/
// TODO (ts-00:42:00) : https://www.youtube.com/watch?v=fzip9Aml6og&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=46
// Find th unique number in a given array.
// discussed all 3 approach:   https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
// https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/
/

public class _2_EveryNumAppeartwiceOneNumberOnlyOnceFindThatNum {

    public static int findUniqueNumberBrute(int[] nums){

        // One simple brute-force solution would be to iterate through the array and compare each element with every other element. If the element is not found twice in the array, it is the unique number. This approach has a time complexity of
        //O(n^2) because it uses two loops to compare each element.
        for (int i = 0;i <nums.length; i++){
            boolean isUnique = true;
            for (int j = 0 ; j<nums.length; j++){
                if ( i!=j && nums[i] == nums[j]){
                        isUnique = false;
                        break;
                }
            }
            if (isUnique){
                return nums[i];
            }
        }

        return -1; // if not found
       }
       // Accepted on LEETCODE
//But GFG -getting TLE  - https://www.geeksforgeeks.org/problems/element-appearing-once2552/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

    public static int findUniqueNumberXOR(int[] nums) {
        /*
                     a ^ a = 0 (XORing a number with itself results in 0)
                     a ^ 0 = a (XORing a number with 0 results in the number itself)
                     XOR is commutative and associative, meaning the order of operations does not matter.
                     If every number in the array appears twice, all pairs of numbers will cancel each other out (because a ^ a = 0). The only number that will not be cancelled out is the unique one, as it doesn't have a pair.
         */

        int uniqueNum = 0;
        for (int ele: nums){
            uniqueNum =uniqueNum ^ ele;
        }

        return uniqueNum;
    }

        public static void main(String[] args) {

            int[] arr = {2, 3, 3, 4, 2, 6, 4};
            int uniqNum = findUniqueNumberBrute(arr);// 6
            int uniqNumXOR = findUniqueNumberXOR(arr);// 6
            System.out.println( " Provided Array "+ Arrays.toString(arr));
            System.out.println( " unique Number of among the above numbers: "+ uniqNum);
            System.out.println( "XOR way- unique Number of among the above numbers: "+ uniqNumXOR);

        }

    }

    // TODO: Explaing thr optimized XOR- how due to associative and commutative helps to cal cel each repeated elements and remains only the unique one.
/*
Let's walk through the XOR process again, but using properties:
    Start with uniqueNum = 0.
    XOR each number in the array: 0 ^ 2 -1st iteration. 2 ^ 3 =>  2 ^ 3 ^ 3 => 2^0=2 ^ 4 ^ 2 ^ 6 ^ 4 similary other or you can think of same give 0 and diff give 1 so ultimately give the unique element. But simply ypu should think of same will get cancelled with the help of XOR property.
    Using commutative and associative properties, we group the same numbers together:
                                    (0 ^ 2 ^ 2) ^ (3 ^ 3) ^ (4 ^ 4) ^ 6
                                    0 ^ 0 ^ 0 ^ 6 = 6
    The final result is 6, which is the unique number in the array.

    This demonstrates how XOR's commutative and associative properties allow us to find the unique number efficiently, regardless of the order in which we XOR the numbers.
 */