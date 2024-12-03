package kunalSeries.patternsprinting.assignment;
// TODO: REF 57Min Kunal Lect- https://www.youtube.com/watch?v=lsOOs5J8ycw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=22
// TODO: REF-  https://takeuforward.org/pattern/pattern-7-star-pyramid/
/*


8.   Isosceles triangle OR pyramid
        *
       ***
      *****
     *******
    *********
 */

public class _8_Pattern8IsoscelesTriangleOrPyramid {


    /*
    Key Observations:
        -> Each row contains:
            - Spaces: Decrease with each row.
            - Stars: Increase in odd numbers (1, 3, 5, 7, ...).
        The number of stars in row i is 2×i−1.

        For a given row i:

                Spaces:
                    There are n−i spaces before the stars.
                Stars:
                    There are 2×i−1 stars.
            So, for each row, you:
                    Print n−i spaces.
                    Print 2×i−1 stars.
     */
    public static void withTwoInnerLoop(int row ){
        int col = row;
        for (int i = 1; i <= row ; i++) {
            // printing space - focusing on the left space since right space printing no use
            // as  no. if spaces decrease as no. of increase with row-i so j will go from j=1 to j=row-i
            for (int j = 1; j <= row-i; j++) { // ex: i=2 => 5-2 => hence space from 1 to 3 (inclusive indices)
                System.out.print(" ");
            }
            // printing start : we already printed spaces so we just need to worry about the *.
            // this about how u can print 1st * at 5th col. And make sure it will relate to either i or row/line.
            // he second loop uses its own column counting (1 to 2×i−1) to calculate how many stars to print,
            // **regardless of where the spaces ended**.
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        /*
        What aligns the stars correctly is the behavior of the first loop: (we have used print  not println that's y * printing next to the after printing spaces)

The spaces shift the output cursor to the correct column for the stars to appear in the right place.
         */

    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of rows in your pattern : " );
//        int n = sc.nextInt();
//        int n = 5;
        int row = 7;
        System.out.println("\n========== With TWO Inner loop   ===========");
        withTwoInnerLoop(row);

        System.out.println("\n\n========== With ONE Inner loop   ===========\n");

        // with only one inner loop
            // Approach with One Inner Loop
            //Instead of using separate loops for spaces and stars, we can handle them in a single inner loop by combining their logic.

        for (int i = 1; i <= row ; i++) {
            // Calculate total columns for this row : This dynamically adjusts the total number of columns to handle spaces and stars properly as i increases.
            int cols = row+i-1; // see the pyramid- we are adding * row+currentRowProcessing-1
                                    // ex: i=2 => 5+2-1 => 7-1 => so till j== 6 it will print * and starting space is already handled.
            for (int j = 1; j <= cols ; j++) {
                // printing spaces if j<=n-i  , ex: i=2 => j<= 5-2=> j<=1,2,3
                if (j<=row-i)
                    System.out.print(" ");
                else // for j>row-i then print star
                    System.out.print("*");
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
Observed :// observed 2*i-1 no. of start * is there in each row. - ex: for i=2 => 2*2-1=>4-1=>3
 */