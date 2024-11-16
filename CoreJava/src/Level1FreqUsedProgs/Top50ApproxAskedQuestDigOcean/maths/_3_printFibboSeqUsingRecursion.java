package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.maths;

import java.util.ArrayList;
import java.util.List;

// TODO: 5. Write a Java program to print a Fibonacci sequence using recursion.
public class _3_printFibboSeqUsingRecursion {

    public static void printFibboUsingLoop(int count){

        int n0 = 0;
        int n1 = 1;
//        System.out.print(n0 + " ");
//        System.out.print(n1 + " ");
        List<Integer> lstOfFibSeries = new ArrayList<>();
        lstOfFibSeries.add(n0);
        lstOfFibSeries.add(n1);
        for (int ind = 0; ind<count-2; ind++){
            int n2 = n0+n1;
//            System.out.print(" " + n2); // direct printing
            lstOfFibSeries.add(n2);
            n0 = n1;
            n1 = n2;
        }
        System.out.println("Fibonacci Series of 1st " + count + " number :  " + lstOfFibSeries); // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
    }

    public static int printFibboRecursion(int currentNum){
            if(currentNum <= 1){ // since 0, 1, 1 there is no need of calculation next number
                    return currentNum;
            }
       return printFibboRecursion(currentNum-1)  + printFibboRecursion(currentNum-2);
    }

    public static void main(String[] args) {
        // Given Number N
        int n = 10;

        printFibboUsingLoop(n);
        System.out.println("\n========= Using Recursion ==========\n");
        System.out.print("Fibonacci Series of 1st " + n + " number :  ");
        for (int i = 0 ; i<n; i++){
            System.out.print( printFibboRecursion(i) +" " );
        }
    }
}


/*

Input: N = 10
Output: 0 1 1 2 3 5 8 13 21 34
Explanation: Here first term of Fibonacci is 0 and second is 1, so that 3rd term = first(o) + second(1) etc and so on.
 */