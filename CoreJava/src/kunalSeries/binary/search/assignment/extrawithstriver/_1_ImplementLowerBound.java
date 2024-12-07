package kunalSeries.binary.search.assignment.extrawithstriver;

// https://takeuforward.org/arrays/implement-lower-bound-bs-2/
// Problem Statement: Given a sorted array of N integers and an integer target, write a program to find the lower bound of target.
public class _1_ImplementLowerBound {

    public static int lowerBoundOfTargetBruteForce(int[] arr, int target ){
        // the thing is we need to find 1st ith value where arr[i]>= target since SORTED so this will be the lowest value for target.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>= target)
                return i;
        }


        return arr.length; // as per the definition of lower bound
        /*
Time Complexity: O(N), where N = size of the given array.
Reason: In the worst case, we have to travel the whole array. This is basically the time complexity of the linear search algorithm.

Space Complexity: O(1) as we are using no extra space.
         */
    }

    public static int lowerBoundOfTargetBinarySearch(int[] arr, int target ){
        int l = 0;
        int r = arr.length-1;
        int ans = arr.length;
        while (l<=r){
            int mid = l+(r-l)/2;
            // maybe an answer
            if (arr[mid]>=target){
                ans = mid;
                r = mid-1; // this can also be the 1st greater number , EX : 1,2,2,3 and target=2 ans - 1=> Index 1 is the smallest index such that arr[1] >= target
                // mid already stored in ans. so we can go left mid-1
            }
            else { // arr[mid] < target
                l = mid+1;
                } // In this case, mid cannot be our answer and we need to find some bigger element. So, we will eliminate the left half and search in the right half for the answer.


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
//         int target = 5; // 1
        int[] arr = {1,2,2,3};
        int target = 2; //  Index 1 is the smallest index such that arr[1] >= target.
//        int[] arr = {3,5,8,15,19};
//        int target = 9; // Index 3 is the smallest index such that arr[3] >= target.

        int indLS = lowerBoundOfTargetBruteForce(arr, target);
        int indBS = lowerBoundOfTargetBinarySearch(arr, target);
        System.out.println("LS - The lower bound is the index: " + indLS + " and its value : " + arr[indLS]);
        System.out.println("BS - The lower bound is the index: " + indBS + " and its value : " + arr[indBS]);


    }
}

/*
What is Lower Bound?
The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. target.

The lower bound is the smallest index, ind, where arr[ind] >= target. But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.

 */
