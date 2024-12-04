package kunalSeries.patternsprinting.assignment;
// TODO: REF 57Min Kunal Lect- https://www.youtube.com/watch?v=lsOOs5J8ycw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=22

/*
4. Printing Simple number Pattern : No. of cols is equal to number rows

    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
 */

public class _4_RightAngleTriangleNumberPattern {
    public static void main(String[] args) {
        int n = 5;
        int row = 5;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
}
// TODO: Step to approach
/*
 1 -> No. of line = No. of rows ===> No. of times the OUTER LOOP will run
 2 -> Identify for every row number ;
        a) How many columns are there . : as the number of rows increases , cols increases :  1 row -> 1 col , 2 row -> 2 col ....
        b) type of element in the column (symbol/numeric/character).
 3 -> What do you need to print.

NOTE: Try to find the Relations B/W Row and columns for Step 2
 */