package kunalSeries.binary.search.bsin2d;

// Q-2: https://www.youtube.com/watch?v=enI_KyGLYPo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=19                ts:23:00
// Q- Search in sorted matrix : Here  the whole matrix is sorted and not like the previous one.
// LoveBabbar : https://www.youtube.com/watch?v=1CdolnvxLs0             ts: 1:02:00     for theory as well
// Striver : https://www.youtube.com/watch?v=JXU4Akft7yk             00:00:00 for theory as well used
// code striver : https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/
// striver and babbar lect seems more easy but Kunal also good. But for this and clear concept used striver and babbar
import java.util.Arrays;

public class _2_StrictlySorted2DMatrix {
    public static int[] searchElementIn2DusingLS(int[][] matrix, int target) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c]==target)
                    return new int[]{r,c};
            }
        }

        return new int[]{-1,-1};
    }


    //TODO- In 2D : We'll have to think, how u can eliminate rows and cols in the matrix. for looking for start and end pointer.
    // Alternate: here in this we can convert 2d into 1D and then use BS (using flatmap functions) Since all number are sorted
    public static int[] searchElementINStrictlySortedMatrixIn2DusingBsLoveBabbarWays(int[][] matrix, int target) {
                // think of 2d as 1D and try to find start and end pointer. That's hypothetical thought to solve.
              // You can conceptually "flatten" this matrix into a single 1D array
                int row = matrix.length;
                int col = matrix[0].length;
                System.out.println("number of rows: " + row);
                System.out.println("number of cols: " + col);
                int l = 0;
                int r = row*col-1;

                // now point is to find the row and col index so that we can access element and compare with the target: use lovebabbar  or striver
                while (l<=r){
                    int mid = l+(r-l)/2;
                    // To access the element at this mid index in the original 2D matrix
                    // Or trying to get or map from 1D hypothetical to 2D - row and col 's  indices
                    int rIndex = mid/col; // intuition behind rIndex&cIndex: at oth col all the index of row must be multiple of col number: for more see striver (ts- 11:00)
                    int cIndex = mid%col; // as example matrix2 in the below row index is 0, 1, 2 row -> indices are 0, 4, 8. COl size = 4
                    int element = matrix[rIndex][cIndex];

                    // now will be searching just like the normal 1D array
                    if (element==target)
                        return new int[]{rIndex, cIndex};
                    else if (element>target)
                        r = mid-1;
                    else  // element < target
                        l = mid+1;
                }

        return new int[]{-1, 1};
    }

    public static boolean binarySearcIn1DArray(int[]arr, int target){

        int l = 0;
        int r = arr.length-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if (arr[mid]==target)
                return true;
            else if (arr[mid]>target)
                r = mid-1;
            else  // mid<target
                l = mid+1;
        }

        return false;
    }
    // also striver given more insight of intuition same logic as I implemented in Babbar method. this below is a new one that's y written
    public static boolean searchElementINStrictlySortedMatrixIn2DusingBsStriverWays(int[][] matrix, int target) {
//        int s = 0;
//        int e = matrix[0].length-1; // last index of col
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0]<=target && matrix[r][matrix[0].length-1]>=target)
                return binarySearcIn1DArray(matrix[r], target);
        }
        return false;
    }

    public static void main(String[] args) {


        int[][] matrix = {  {1, 2, 3, 4}, // here we can write prefix as new int[][] {} but not mandatory since from left side compiler can understand that it's going to be 2D array.
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}
        };
//        int target = 10; // [2,1]
        int target = 13; // [3,0]

//        int[][] matrix = {  {1, 3, 5, 7},
//                            {10, 11, 16, 20},
//                            {23, 30, 34, 60}  // 3*4
//        };
//        int target = 10; // [1,0]
//        int target = 16; // [1,2]
//        int target = 0; // [1,2]

        System.out.println("2D Array : " );
        for (int[] row : matrix){
            for (int ele : row )
                System.out.print(" " + ele);
            System.out.println();
        }
        System.out.println();
        int[] res1 = searchElementIn2DusingLS(matrix, target); // format of return value should be {row, col}
        // O(n^2)
        int[] res2 = searchElementINStrictlySortedMatrixIn2DusingBsLoveBabbarWays(matrix, target); // format of return value should be {row, col}
        // logm+logn => log(m*n) where m and n are the number  of rows and columns respectively.
        boolean res3 = searchElementINStrictlySortedMatrixIn2DusingBsStriverWays(matrix, target); // format of return value should be {row, col}
        // O(m)+logn =>where m is number of rows and n is the cols. logn will run only time and not for every element since only once the condition will run. Since sorted whole matrix.
        if(res1[0] !=-1 && res2[0]!=-1 && res3){

            System.out.println("YES, we found the element from LS: " + target + "  and its index(row, col) is : " + Arrays.toString(res1));
            // YES, we found the element 12  and its index(row, col) is : [1, 3]
            System.out.println("YES, we found the element from BS Babbar: " + target + "  and its index(row, col) is : " + Arrays.toString(res2));
            System.out.println("YES, we found the element from BS Striver : " + target + "   : " + res3);
        }
        else
            System.out.println("NO, we didn't found the element " + target);
    }



}
// TODO: Hint- try to minimize the search space whenever you've to search something.
/*

The formula [mid / col][mid % col] is used to calculate the row and column indices in a 2D matrix when you are performing a binary search on the matrix treated as a flattened 1D array.

Here’s the intuition:

Flattening a 2D Matrix:
Imagine a 2D matrix, matrix[row][col], with row rows and col columns. You can conceptually "flatten" this matrix into a single 1D array:

            Row 0 (index 0): Contains elements from matrix[0][0] to matrix[0][col - 1].
            Row 1 (index 1): Contains elements from matrix[1][0] to matrix[1][col - 1].
            Row r (index r): Contains elements from matrix[r][0] to matrix[r][col - 1].

If we number all elements in row-major order (from top-left to bottom-right), the flattened array would look like this:

         matrix[0][0], matrix[0][1], ..., matrix[0][col-1], matrix[1][0], ..., matrix[row-1][col-1]

In this flattened representation:

        The total number of elements is row * col.
        Each 2D index (i, j) maps to a 1D index index = i * col + j.
        Conversely, a 1D index index maps back to a 2D index (i, j) as:
        i = index / col (integer division gives the row).
        j = index % col (modulo gives the column).

Why [mid / col][mid % col]???????????
When performing binary search:

You define start = 0 and end = row * col - 1 to represent the range of indices in the flattened array.
mid = (start + end) / 2 calculates the midpoint of the flattened array.
To access the element at this mid index in the original 2D matrix:
    The row is mid / col (how many full rows fit into the index).
    The column is mid % col (the remainder after filling full rows).
    Example
    Consider the matrix:

    Copy code
    1  3  5
    7  9 11
    13 15 17
    This is a 3x3 matrix (row = 3, col = 3).

If you treat it as a flattened 1D array, the indices would look like this:

makefile
Copy code
Index:  0   1   2   3   4   5   6   7   8
Value:  1   3   5   7   9  11  13  15  17

Binary Search Example
    Start: start = 0, end = 8 (for 9 elements total).
    Midpoint: mid = (0 + 8) / 2 = 4.
    To find the 2D coordinates of mid = 4:
    row = mid / col = 4 / 3 = 1 (integer division → row 1).
    col = mid % col = 4 % 3 = 1 (remainder → column 1).
    So matrix[1][1] = 9.
Why This Works?????????
This method allows you to perform binary search directly on the conceptual 1D representation of the matrix while still accessing elements in their original 2D coordinates. This is efficient because:

    You avoid copying or flattening the matrix (saves space).
    The binary search ensures a logarithmic time complexity: O(log(row * col)).

Key Benefits:::::::::::
    1-> The matrix’s row and column constraints are respected, as mid / col and mid % col correctly map the 1D index to its corresponding 2D indices.
    2-> You only deal with the indices logically, so there's no need to actually flatten the matrix, saving memory.

This technique is widely used for searching in 2D arrays, especially when the array is sorted in a row-major or column-major order.

 */