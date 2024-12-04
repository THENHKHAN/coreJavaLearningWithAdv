package kunalSeries.patternsprinting.assignment;
// TODO: REF 57Min Kunal Lect- https://www.youtube.com/watch?v=lsOOs5J8ycw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=22
// TODO: REF 1:22:01 hrs-  Striver Lect- https://www.youtube.com/watch?v=tNm_NNSB3_w
/*
5.  Half Diamond Pattern OR Right Pascal Triangle:

    *
    **
    ***
    ****
    *****
    ****
    ***
    **
    *
 */

import java.util.Scanner;

public class _5_HalfDiamondOrRightPasca {


    public static void twoLoopingRightAndInverseRightTriangle(int row ){
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 1; i <= row-1; i++) {
            for (int j = 1; j <= (row-1)-i+1 ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // seems symmetry that's y applied this way
        twoLoopingRightAndInverseRightTriangle(5); // thinking as two triangles- one is right angle and other inverse right angle triangle
        System.out.println("\n--------------- Other logic -------------------\n");
        // other way is in two loop only with logical connection of cols with row.

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of rows in your pattern : " );
//        int n = sc.nextInt();
        int n = 9; // 2 * 5 -1  ==> 2*n -1
        int row = 5; // 2 * 5 -1  ==> 2*n -1
        for (int i = 1; i <= 2*row-1; i++) {
            int col = i<=row? i:(2*row-i);
            for (int j = 1; j <= col; j++) {
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
        a) How many columns are there .
        b) type of element in the column (symbol/numeric/character).
 3 -> What do you need to print.

NOTE: Try to find the Relations B/W Col with Rows for Step 2 :
Observed :// observed it through taking example like if i = 6 then it should print 4 start then how it can be possible with relation with row.
 */