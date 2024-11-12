package streamApi;

import java.util.Arrays;

// https://www.youtube.com/watch?v=DYyhFLC2eJ0      -- 30Min explained very well
public class _1_IntroAndBenefits {
    public static void main(String[] args) {
        // imperative approach (without stream) : finding even number from array
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int sum = 0;
        for (int i = 0 ; i < array1.length ; i++){
            if (array1[i] % 2 == 0){
                sum += array1[i];
            }
        }
        System.out.println("Sum of array1 : " + Arrays.toString(array1) + " ==> " + sum); // ==> 12

        // declarative approach (stream approach) or functional apparoach

       int[] array2 = {1, 2, 3, 4, 5, 6};
       int sum2 = Arrays.stream(array2).filter( n -> n % 2 == 0).sum();
        System.out.println("Sum of array2 : " + Arrays.toString(array2) + " ==> " + sum2); // ==> 12


    }
}
