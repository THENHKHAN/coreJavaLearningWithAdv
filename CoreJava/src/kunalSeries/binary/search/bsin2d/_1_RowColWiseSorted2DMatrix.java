package kunalSeries.binary.search.bsin2d;

// Q-1: https://www.youtube.com/watch?v=enI_KyGLYPo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=19                ts:6:31
// Q- Matrix is sorted in a Row wise and Column wise manner. Search a target. Using binary search

import java.util.Arrays;

public class _1_RowColWiseSorted2DMatrix {



    //TODO- In 2D : We'll have to think, how u can eliminate rows and cols in the matrix. for looking for start and end pointer.
    public static int[] searchElementIn2DusingBs(int[][] matrix, int target) {
            int r = 0;
            int c = matrix.length-1;

            while (r<matrix.length && c>=0){ //  r<matrix.length : Ensures that the row pointer r does not exceed the number of rows in the matrix.
                                            //  c >= 0: Ensures that the column pointer c does not go below the first column index (0).
                if (matrix[r][c] < target){
                    r = r+1;
                } else if (matrix[r][c]>target){
                    c = c-1;
                } else {
                    // found
                    return new int[]{r,c};
                }
            }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {


        int[][] matrix = {  {10, 20, 30, 40}, // here we can write prefix as new int[][] {} but not mandatory since from left side compiler can understand that it's going to be 2D array.
                            {15, 25, 35, 45},
                            {28, 29, 37, 49},
                            {33, 34, 38, 50}
        };
//        int target = 29; // [2, 1]
//        int target = 37; //  [2, 2]
//        int target = 370; //  [-1, -1]
        int target = 50; // [3, 3]
        System.out.println("2D Array : " );
        for (int[] row : matrix){
            for (int ele : row )
                System.out.print(" " + ele);
            System.out.println();
        }
        System.out.println();
        int[] res = searchElementIn2DusingBs(matrix, target); // format of return value should be {row, col}
        if(res[1] !=-1)
            System.out.println("YES, we found the element " + target + "  and its index(row, col) is : " + Arrays.toString(res));
            // YES, we found the element 12  and its index(row, col) is : [1, 3]
        else
            System.out.println("NO, we didn't found the element " + target);
    }


}
// TODO: Hint- try to minimize the search space whenever you've to search something.
/*
                Traversal Pattern:
The search starts at the top-right corner of the matrix (matrix[0][matrix[0].length - 1]):

If the current element is smaller than the target, move down (r++) because all elements below are larger.
If the current element is larger than the target, move left (c--) because all elements to the left are smaller.
The while condition ensures that:

You move down until you hit the bottom boundary (r < matrix.length).
You move left until you hit the left boundary (c >= 0).

                Why This Algorithm Works
This approach works because of the row-wise and column-wise sorting properties of the matrix. By starting at the ***top-right corner***:

The largest element of the current row is immediately accessible.
The smallest element of the current column is immediately accessible.
This allows us to **eliminate one row or one column** in each step, reducing the search space efficiently.
 */