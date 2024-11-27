package kunalSeries.binary.search.assignment.medium;

// TODO : 74. Search a 2D Matrix : https://leetcode.com/problems/search-a-2d-matrix/description/
// AlgoMonster : https://algo.monster/liteproblems/74
// striver: https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/
// striver:  https://www.youtube.com/watch?v=JXU4Akft7yk             00:00:00 for theory as well used
// MyGit : https://github.com/THENHKHAN/coreJavaLearningWithAdv/blob/main/CoreJava/src/kunalSeries/binary/search/bsin2d/_2_StrictlySorted2DMatrix.java
public class _2_SearchIn2DSortedMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
// if we flatten the given 2D matrix to a 1D array, the 1D array will also be sorted. By utilizing binary search on this sorted 1D array to locate the 'target' element, we can further decrease the time complexity.
        int row = matrix.length;
        int col = matrix[0].length;

        System.out.println("number of rows: " + row);
        System.out.println("number of cols: " + col);
        int l = 0;
        int r = row*col-1; //  last element index.

        while (l<=r){
            int mid = l + (r-l)/2;
            int rIndex = mid/col;
            int cIndex = mid%col;

            if (matrix[rIndex][cIndex]==target)
                return true;
            else if (matrix[rIndex][cIndex]<target) // Move Forward
                l = mid+1;
            else // matrix[rIndex][cIndex]>target   // Move Backward
                r = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        _2_SearchIn2DSortedMatrix obj =new _2_SearchIn2DSortedMatrix();

//        int[][] matrix = {  {1, 2, 3, 4}, // here we can write prefix as new int[][] {} but not mandatory since from left side compiler can understand that it's going to be 2D array.
//                            {5, 6, 7, 8},
//                            {9, 10, 11, 12},
//                            {13, 14, 15, 16}
//                        };
//        int target = 10; // true
//        int target = 13; // true
//        int target = 100; // true

//        int[][] matrix = {  {1, 3, 5, 7},
//                            {10, 11, 16, 20},
//                            {23, 30, 34, 60}  // 3*4
//        };
//        int target = 10; // [1,0]
//        int target = 16; // [1,2]
//        int target = 0; // [1,2]

//        int[][] matrix = {  {1,3,5,7},  {10,11,16,20},  {23,30,34,60}   };
//        int target = 3 ;// true

        int[][] matrix = {  {1,3,5,7},  {10,11,16,20},  {23,30,34,60}   };
        int target = 13 ;// false


        System.out.println("2D Array : ");
        for (int[] row : matrix){
            for (int ele : row )
                System.out.print(" " + ele);
            System.out.println();
        }
        System.out.println();
        boolean res = obj.searchMatrix(matrix, target); // format of return value should be {row, col}
        // logm+logn => log(m*n) where m and n are the number  of rows and columns respectively.
        if(res){
            System.out.println("YES, we found the element from BS Babbar ways of target : " + target);
        }
        else
            System.out.println("NO, we didn't found the element ");
    }
}
/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */