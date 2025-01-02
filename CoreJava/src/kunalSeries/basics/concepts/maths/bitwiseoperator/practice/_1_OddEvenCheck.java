package kunalSeries.basics.concepts.maths.bitwiseoperator.practice;

// TODO (ts-00:33:00) : https://www.youtube.com/watch?v=fzip9Aml6og&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=29
// why we & with the 1 to the given number and check odd or even - explained
// you can read this (explained with other bitwise operator as well) : https://www.geeksforgeeks.org/check-if-a-number-is-odd-or-even-using-bitwise-operators/
// u can check this why we checking like this : https://softwareengineering.stackexchange.com/questions/417916/why-is-the-bitwise-and-of-1-and-any-even-number-equal-to-0
public class _1_OddEvenCheck {

    public static String checkEvenOdd(int num){
        if ((num & 1) == 0 ){ // if even. means if the last binary digit of num would be zero. That's y making & with 1 will make everything zero.
            return "EVEN";
        }else {
            return "ODD";
        }

//        return num&1;// return 0 if even. Always return int value so if u want to use this directly then make return type int.
    }

    public static void main(String[] args) {

            System.out.println(2 + " is "+ checkEvenOdd(2));
            System.out.println(5 + " is "+ checkEvenOdd(5));
            System.out.println(12 + " is "+ checkEvenOdd(12));
            System.out.println(96 + " is "+ checkEvenOdd(96));
            System.out.println(35 + " is "+ checkEvenOdd(35));
            System.out.println(1000 + " is "+ checkEvenOdd(1000));
        }

    }
/*

This is how binary number (base 2 number system) works. It is just mathematics. The unit digit has weight pow(2,0), namely the weight of one (1),
which is not divisible by 2. All higher digits have weights that are divisible by 2. You may find it helpful to think in terms of decimal number:
    numbers that are divisible by ten, say, fifty (50), have a zero in the digit place.

Bitwise Operation:
        - The expression number &amp; 1 checks the least significant bit of the number.
        - If this bit is 0, the number is even; if it’s 1, the number is odd.
        - This operation is typically very fast because it directly manipulates the bits.
Modulus Operation:
        - The expression number % 2 calculates the remainder when dividing the number by 2.
        - While this is straightforward, it involves more computational steps than a bitwise operation, making it generally slower.

To check if a number is even or odd, is "number & 1" faster than "number % 2"?

number & 1 = 0 result would be an even number. & is a bitwise binary logical AND operation. number & 1 = 1 is an odd number.
Since only the lowest order bit needs to be considered to determine “even or odd”, it’s hard to believe there could be a faster way
to determine that. 0100 & 1=0, so 4 is even. 0011 & 1 = 1 so 3 is odd. number % 2 >0 should be slower since % is modulo arithmetic.
10%2=0, so 10 is even. You could possibly run into issues with unsigned integers or -1, depending on the language implementation.
 */