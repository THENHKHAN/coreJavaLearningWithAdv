package AdvTopic.streamApi;

import java.util.Arrays;

// https://www.youtube.com/watch?v=DYyhFLC2eJ0      -- 30Min explained very well
// STARTED from JAVA 1.8        --- It is related to Collection Framework
// --> It is different from io stream (Sequence of data process from source to destination) And Stream (Group of Objects process or Collections)
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

        // declarative approach (stream approach) or functional approach

       int[] array2 = {1, 2, 3, 4, 5, 6};
       int sum2 = Arrays.stream(array2).filter( n -> n % 2 == 0).sum();
        System.out.println("Sum of array2 : " + Arrays.toString(array2) + " ==> " + sum2); // ==> 12


    }

    // TODO: IMP -> Stream Api and Stream
    /*
    In Java, the term Stream can refer to two different concepts:

        Java I/O Streams (part of java.io package)
        Java Stream API (part of java.util.stream package)
        Focus: ioStream:	I/O handling (files, network, etc.)	             StreamApi:   Functional programming on collections

        Use Java I/O Streams when dealing with low-level input/output operations like reading files, network communication, etc.
        Use the Java Stream API for processing collections of data in a functional style, especially when you want to perform complex operations
                like filtering, mapping, and reducing.

These two concepts are unrelated despite having similar names, so it's important to use them in the appropriate context.
     */
}
