package stringQuestions.basics;

// TODO: Left Rotation and Right Rotation of a Array by D element
// https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
// https://www.geeksforgeeks.org/array-rotation/               -- solving from this article

import java.util.ArrayList;
import java.util.Arrays;

/*
Left (Or anticlockwise) rotate the given string by d elements (where d <= n)
Right (Or clockwise) rotate the given string by d elements (where d <= n).
 Ex:
Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2
Output: {3, 4, 5, 6, 1, 2}
Explanation: After first left rotation, arr[] becomes {2, 3, 4, 5, 6, 1} and after the second rotation, arr[] becomes {3, 4, 5, 6, 1, 2}


Input: arr[] = {1, 2, 3}, d = 4
Output: {2, 3, 1}
Explanation: The array is rotated as follows:


After first left rotation, arr[] = {2, 3, 1}
After second left rotation, arr[] = {3, 1, 2}
After third left rotation, arr[] = {1, 2, 3}
After fourth left rotation, arr[] = {2, 3, 1}
*/
public class _3_0_LeftRightRotationOfArrayByDElement {

    public static void utilPrintRotatedArray(int[] rotatedArr, int d){
        System.out.print("\nLeft Rotated Array by "+ d + " element : ");
        for (int ele : rotatedArr) {
            System.out.print(ele + " ");
        }
        System.out.println("\n\n");
    }

    /*
    In each iteration, shift the elements by one position to the left in a circular fashion (the first element becomes the last).
    Perform this operation d times to rotate the elements to the left by d positions.
     */
    private static void leftRotateOneByOneNaiveApproach(int[] intArr, int d){

        for (int i=0; i<d; i++){ // this will pick how many element to be rotated

            int firstEleOrArr = intArr[0];
            for (int j=0; j<intArr.length-1; j++){
                intArr[j] = intArr[j+1];
            }
            intArr[intArr.length-1] = firstEleOrArr;
        }
    }

/*
The idea is to use a temporary array of size n, where n is the length of the original array. If we left rotate the array by d positions,
                                                the last n – d elements will be at the front and the first d elements will be at the end.

--> Copy the last (n – d) elements of original array into the first n – d positions of temporary array.
--> Then copy the first d elements of the original array to the end of temporary array.
--> Finally, copy all the elements of temporary array back into the original array.
 */
    private static void leftRotateUsingTempArrayBetterApproach(int[] intArr, int d){
        int arryLength = intArr.length; // 6
        int[] tempArr = new int[arryLength];
        // let's copy last (n-d) element into the temporary Array : // Copy last n - d elements to the front of temp
        for (int i=0; i<arryLength-d; i++){
            tempArr[i] = intArr[d+i];
        }

        // let copy the d the element from starting into tempArr :  // Copy the first d elements to the back of tempArr
        for (int i = 0; i<d; i++){
            tempArr[arryLength - d + i] = intArr[i];
        }

        // Copying the elements of temp in arr to get the final rotated array
        for (int i = 0; i<arryLength; i++){
            intArr[i]=tempArr[i];
        }

    }

    /*
    The idea is to use Juggling Algorithm which is based on rotating elements in cycles. Each cycle is independent and represents a group of elements that will
            shift among themselves during the rotation. If the starting index of a cycle is i, then next elements of the cycle can be found at
            indices (i + d) % n, (i + 2d) % n, (i + 3d) % n … and so on till we return to the original index i.

    So for any index i, we know that after rotation, the element that will occupy this position is arr[(i + d) % n]. Consequently, for every index in the cycle,
            we will place the element that should be in that position after the rotation is completed.
     */
    private static void leftRotateUsingJuggingAlgoApproach(int[] intArr, int d){

    }


    public static void main(String[] args) {


        // method-1
        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        int d1 = 2;
        System.out.println("====== [Naive Approach] Rotate one by one – O(n * d) Time and O(1) Space ======");
        System.out.print("Original Array : " );
        for (int ele : arr1) {
            System.out.print(ele + " ");
        }
        leftRotateOneByOneNaiveApproach(arr1, d1); // 3 4 5 6 1 2
        /*
Time Complexity: O(n*d), the outer loop runs d times, and within each iteration, the inner loop shifts all n elements of the array by one position, resulting in a total of n*d operations.
Auxiliary Space: O(1)
         */
        utilPrintRotatedArray(arr1, d1);


        // method-2
        int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        int d2 = 2;
        System.out.println("====== [Better Approach] Using Temporary Array – O(n) Time and O(n) Space ======");
        System.out.print("Original Array : " );
        for (int ele : arr2) {
            System.out.print(ele + " ");
        }
        leftRotateUsingTempArrayBetterApproach(arr2, d2); // 3 4 5 6 1 2
        /*
        Time Complexity: O(n), as we are visiting each element only twice.
        Auxiliary Space: O(n), as we are using an additional temporary array.
         */
        utilPrintRotatedArray(arr2, d2);


        // method-3
        int[] arr3 = { 1, 2, 3, 4, 5, 6 };
        int d3 = 2;
        System.out.println("====== [Expected Approach 2] Using Reversal Algorithm – O(n) Time and O(1) Space ======");
        System.out.print("Original Array : " );
        for (int ele : arr3) {
            System.out.print(ele + " ");
        }
        leftRotateUsingJuggingAlgoApproach(arr3, d3); // 3 4 5 6 1 2
        /*
        Time Complexity: O(n)
        Auxiliary Space: O(1)
         */
        utilPrintRotatedArray(arr3, d3);

    }
}
