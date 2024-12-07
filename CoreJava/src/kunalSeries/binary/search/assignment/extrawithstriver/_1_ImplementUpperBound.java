package kunalSeries.binary.search.assignment.extrawithstriver;
// TODO: Implement Upper Bound
// https://takeuforward.org/arrays/implement-upper-bound/
// Pre-requisite: Binary Search algorithm and lower bound
// Problem Statement: Given a sorted array of N integers and an integer target, write a program to find the upper bound of target.
public class _1_ImplementUpperBound {

    public static int upperBoundOfTargetBruteForce(int[] arr, int target ){
        // the thing is we need to find 1st ith value where arr[i]> target since SORTED so this will be the upper bound value for target.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]> target) // that 1st element that is greater than the target. Since Sorted hence 1st match will be our ans.
                return i;
               //  upper bound found:
        }


        return arr.length; // as per the definition of lower bound
        /*
Time Complexity: O(N), where N = size of the given array.
Reason: In the worst case, we have to travel the whole array. This is basically the time complexity of the linear search algorithm.

Space Complexity: O(1) as we are using no extra space.
         */
    }

    public static int upperBoundOfTargetBinarySearch(int[] arr, int target ){
        int l = 0;
        int r = arr.length-1;
        int ans = arr.length;
        while (l<=r){
            int mid = l+(r-l)/2;
            // maybe an answer
            if (arr[mid]>target){
                ans = mid;
                r = mid-1; // previous mid-value already stored hence mid-1 of right.
                // mid already stored in ans. so we can go left mid-1
            }
            else { // arr[mid] < target
                l = mid+1;
                } // In this case, mid cannot be our answer(since we are searching for bigger than the target) and we need to find some bigger element. So, we will eliminate the left half (along wiht mid so L = mid+1) and search in the right half for the answer.


        }

        return ans;
        /*
        Time Complexity: O(logN), where N = size of the given array.
Reason: We are basically using the Binary Search algorithm.

Space Complexity: O(1) as we are using no extra space.
         */
    }


    public static void main(String[] args) {
//        int[] arr = {3, 5, 8, 15, 19};
//         int target = 2; // 1
        int[] arr = {1,2,2,3};
        int target = 2; //   Index 3 is the smallest 1st index such that arr[3] > target.
//        int[] arr = {3,5,8,9,15,19};
//        int target = 9; // Index 4 is the smallest index such that arr[4] >  target.
//        int target = 7; // Index 2 is the smallest index such that arr[2] >  target.

        int indLS = upperBoundOfTargetBruteForce(arr, target);
        int indBS = upperBoundOfTargetBinarySearch(arr, target);
        System.out.println("LS - The upper bound is the index: " + indLS + " and its value : " + arr[indLS]);
        System.out.println("BS - The upper bound is the index: " + indBS + " and its value : " + arr[indBS]);


    }
}

/*
What is Upper Bound?
The upper bound algorithm finds the first or the smallest index in a sorted array where the value
 at that index is greater than the given key i.e. target.

The upper bound is the smallest index, ind, where arr[ind] > target.



 if any such index is not found, the upper bound algorithm returns n i.e. size of the given array.
    The main difference between the lower and upper bound is in the condition.
    For the lower bound the condition was arr[ind] >= target and here, in the case of the upper bound, it is arr[ind] > target.
 */
