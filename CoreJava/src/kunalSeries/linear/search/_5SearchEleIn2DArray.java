package kunalSeries.linear.search;

import java.util.Arrays;

// TODO : Search in the 2D array: return the index if item found
//    // otherwise if item not found return -1
public class _5SearchEleIn2DArray {

    public static int[] searchElementIn2D(int[][] arr, int target){
        // basic checks
        if (arr.length == 0){
            return new int[]{-1, -1}; // we can't directly pass the { } value since we didn't initialize it
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++){
                if (arr[row][col] == target)
                    return new int[]{row, col};
            }
        }
     return new int[]{-1, -1} ;
    }

    public static void main(String[] args) {

         int[][] arr = { {1, 33, 5,}, // here we can write prefix as new int[][] {} but not mandatory since from left side compiler can understand that it's going to be 2D array.
                         {9, 15, 11, 12},
                         {10, 12, 102}
                       };
         int target = 12;
        System.out.println("2D Array : " );
        for (int[] row : arr){
            for (int ele : row )
                System.out.print(" " + ele);
            System.out.println();
        }
        System.out.println();
        int[] res = searchElementIn2D(arr, target); // format of return value should be {row, col}
        if(res[1] !=-1)
            System.out.println("YES, we found the element " + target + "  and its index(row, col) is : " + Arrays.toString(res));
                // YES, we found the element 12  and its index(row, col) is : [1, 3]
        else
            System.out.println("NO, we didn't found the element " + target);
    }
}

/*

2D Array :
 1 33 5
 9 15 11 12
 10 12 102

YES, we found the element 12  and its index(row, col) is : [1, 3]

 */