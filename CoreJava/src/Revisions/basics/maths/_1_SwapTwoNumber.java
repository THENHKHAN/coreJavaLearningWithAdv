package Revisions.basics.maths;

public class _1_SwapTwoNumber {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.printf("a: %d , b: %d", a, b);
        System.out.println("\nAfter Swapping Using third variable ...");
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("a: %d , b: %d", a, b);


        System.out.println("\nAfter Swapping Without Using third variable ...");
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.printf("a: %d , b: %d", a, b);

    }
}
