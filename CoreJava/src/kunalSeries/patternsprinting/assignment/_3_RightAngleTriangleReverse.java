package kunalSeries.patternsprinting.assignment;
// TODO: REF 57Min Kunal Lect- https://www.youtube.com/watch?v=lsOOs5J8ycw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=22

/*
3. Printing an Inverted Right Triangle Star Pattern :

    *****
    ****
    ***
    **
    *
 */

public class _3_RightAngleTriangleReverse {
    public static void main(String[] args) {
        int n = 5;
        int row = 5;
        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= row+1-i ; j++) { // we are decreasing ith number cols for each increasing row.
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
        a) How many columns are there . : as the number of rows increases , cols start decreasing - 1 row -> 5 col , 2 row -> 4 col ....
        b) type of element in the column (symbol/numeric/character).
 3 -> What do you need to print.

NOTE: Try to find the Relations B/W Row and columns for Step 2
 */