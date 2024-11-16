package kunalSeries.basics.concepts;

import java.util.Arrays;
import java.util.stream.Collectors;

// TODO: REf: https://www.javatpoint.com/array-in-java
public class MyArrays {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        System.out.println("arr : " + java.util.Arrays.toString(arr)); // [1, 2, 3, 0, 0]
//        System.out.println("arr getClass : " + arr.getClass().getTypeName()); // int []
//        System.out.println("Arrays.toString(arr)  getClass : " + Arrays.toString(arr).getClass().getTypeName()); //  java.lang.String

        // declare and initializing at compile time
        int[] arr2 = {11, 22, 33, 44, 55};
        System.out.println("arr2 : " + Arrays.toString(arr2)); // [1, 2, 3, 0, 0]
//        System.out.println("arr2  type: " + arr2.getClass().getTypeName()); // int[]
        int[] sqrOfAboveArr = Arrays.stream(arr2).map(e->e*e).toArray();// // just to recapping the stream and map
//        System.out.println("sqrOfAboveArr : " + Arrays.toString(sqrOfAboveArr));  // [121, 484, 1089, 1936, 3025]

        System.out.println("\n########  Starting 2D ARRAY in JAVA ########\n");
        int[][] arr2DTemp = new int[4][]; // 1st is row and 2nd is col: mentioning size of row is mandatory.
        int[][] arr2D = {
                            {1, 2, 3 }, // 1st row [0][0], [0][1], [0][2]
                            {4, 5, 6 },// 2nd row [1][0], [1][1], [1][2]
                            {7, 8, 9 },// 3rd row [2][0], [2][1], [2][2]
                            {10, 11, 12 }// 3rd row [3][0], [2][1], [2][2]
                        };

        for (int[] row : arr2D){
            for (int ele: row){
                System.out.print(" " + ele);
            }
            System.out.println();
        }
        /*         1 2 3
                   4 5 6
                   7 8 9
                   10 11 12
         */
        System.out.println();


//        with normal loop
        for (int i = 0; i < arr2D.length; i++) { // arr2D.length : no. of rows
            for (int j = 0; j < arr2D[i].length; j++) { // arr2D[i].length : no. of column(or element in ith rows) of ith rows.
                System.out.print(" " + arr2D[i][j]);
            }
            System.out.println();
        }
         /*        1 2 3
                   4 5 6
                   7 8 9
                   10 11 12
         */

        // TODO: get all all 2nd element from each row
        System.out.print("\n2nd element from each row: ");
        for (int row = 0; row < arr2D.length; row++) { // arr2D.length : no. of rows
            System.out.print(" " + arr2D[row][1]); //  2 5 8 11
        }




    }
}

/*
ways of declaring an array
dataType[] arr; (or)
dataType []arr; (or)
dataType arr[];

int[] a={33,3,4,5};//declaration, instantiation and initialization
 */
