package kunalSeries.patternsprinting.assignment;
// TODO: REF 57Min Kunal Lect- https://www.youtube.com/watch?v=lsOOs5J8ycw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=22

/*
2. printing a right-angled triangle star pattern.:

    *
    **
    ***
    ****
    *****
 */

public class _2_RightAngleTriangle {
    public static void main(String[] args) {
       int row = 5;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) { // col is equal to number of rows we are currently processing: ith star will be there if we are seeing the ith row
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
// TODO: Step to approach
/*
 1 -> No. of line = No. of rows ===> No. of times the OUTER LOOP will run
 2 -> Identify for every row number ;
        a) How many columns are there . : as many as rows travelling
        b) type of element in the column (symbol/numeric/character).
 3 -> What do you need to print.

NOTE: Try to find the Relations B/W Row and columns for Step 2
 */