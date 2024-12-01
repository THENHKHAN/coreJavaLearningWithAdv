package kunalSeries.patternsprinting.assignment;
// TODO: REF 57Min Kunal Lect- https://www.youtube.com/watch?v=lsOOs5J8ycw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=22
/*
1. Square Pattern:

    *****
    *****
    *****
    *****
    *****
 */

public class _1_Square {
    public static void main(String[] args) {
        // since square: row and col  number will be same
        int row = 5;
        int col = row;
        // this outer loop will run as many number of rows/lines are there in the given pattern.
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row ; j++) { // ith rows contains ith number of star
                System.out.print("* ");
            }
            System.out.println(); // to break the line
        }

    }
}
// TODO: Step to approach
/*
 1 -> No. of line = No. of rows ===> No. of times the OUTER LOOP will run
 2 -> Identify for every row number ;
        a) How many columns are there .
        b) type of element in the column (symbol/numeric/character).
 3 -> What do you need to print.

NOTE: Try to find the Relations B/W Row and columns for Step 2
 */