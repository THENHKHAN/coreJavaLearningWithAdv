package Revisions.advance;

import java.util.Arrays;
import java.util.stream.Stream;

public class _1_StreamApi {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        System.out.println("Array : " + Arrays.toString(array1));
        int sumOdd = 0;
        int sumEven = 0;
        // sum of all odd and sum of all Even individually
        for (int i = 0; i<array1.length; i++){
            if (array1[i]%2!=0)
                sumOdd += array1[i];
            else
                sumEven += array1[i];
        }

        System.out.println("Sum of all Odd number : " + sumOdd);
        System.out.println("Sum of all EVEN number : " + sumEven);

        System.out.println("With Stream API .......................");

        int sOdd = Arrays.stream(array1).filter(num->num%2!=0).sum();
        int sEven = Arrays.stream(array1).filter(num->num%2==0).sum();

        System.out.println("Sum of all Odd number : " + sOdd);
        System.out.println("Sum of all EVEN number : " + sEven);


    }


}
