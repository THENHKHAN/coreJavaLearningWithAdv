package kunalSeries.patternsprinting.assignment;
// TODO: REF 57Min Kunal Lect- https://www.youtube.com/watch?v=lsOOs5J8ycw&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=22
// TODO: REF 1:22:01 hrs-  Striver Lect- https://www.youtube.com/watch?v=tNm_NNSB3_w    not used for this
/*


6.
         *
        **
       ***
      ****
     *****
 */

public class _6_Pattern6 {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of rows in your pattern : " );
//        int n = sc.nextInt();
        int row = 5;

        for (int i = 1; i <= row; i++) {
            int col = row;
            for (int j = 1; j <= col; j++) {
                if (j<= (row-i))
                    System.out.print(" ");
                else
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
Observed :// observed j is becoming greater than the j> (row-i) then only * is printing.
 */