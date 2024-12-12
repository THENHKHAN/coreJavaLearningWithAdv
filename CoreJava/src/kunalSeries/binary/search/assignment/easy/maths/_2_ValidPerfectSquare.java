package kunalSeries.binary.search.assignment.easy.maths;


// TODO : 367. Valid Perfect Square : check this for more ._1_SquareRootOfNum
// https://leetcode.com/problems/valid-perfect-square/description/
//REF :  ._1_SquareRootOfNum
// https://github.com/THENHKHAN/coreJavaLearningWithAdv/blob/main/CoreJava/src/kunalSeries/binary/search/assignment/easy/maths/_1_SquareRootOfNum.java
public class _2_ValidPerfectSquare {

    private static boolean isPerfectSquareBruteForce(int num) {
        int i = 1; // since in question given num will from 1 to maxINT
        while (i*i <= num){
            int check = i*i;
            if (check==num){
                System.out.println("i*i : " + i*i);
                return true;
            }

            i++;
        }
        return false;
    }

    private static boolean isPerfectSquareBinarySearch(int num){
        int l = 1; // since in question given num will from 1 to maxINT
        int r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid == num / mid && num % mid == 0) {
                // mid * mid == num, but rewritten to prevent overflow
                return true;
            } else if (mid < num / mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 16;
//        int num = 2147483647; // maxINT - linear will give - Time Limit Exceeded


        System.out.println("Brute Force - Valid Perfect Square  of number " + num +" : " + isPerfectSquareBruteForce(num)); //O(N))
        System.out.println("Binary Search- Valid Perfect Square  of number  " + num +" : " + isPerfectSquareBinarySearch(num)); // O(logN))
        // O(logn), as binary search divides the range by half at each iteration.
    }

}

//TODO: Why you should use Binary Search  in this, the intuition
// Similar to finding the Square root of number