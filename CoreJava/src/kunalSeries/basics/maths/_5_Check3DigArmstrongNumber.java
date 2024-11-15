package kunalSeries.basics.maths;

// TODO: Print all Armstrong number of 3 digit number.
public class _5_Check3DigArmstrongNumber {

    public  static void check3DigArmstrongNumber(int order, int number){
        int calCNum = 0;
        int temp = number;
        while (number>0){
            int dig = number%10;
            number /=10;
            calCNum += (int) Math.pow(dig, order);
        }
        if (calCNum == temp) {
            System.out.println( temp + " is an Armstrong number");
        } else{
            System.out.println( temp + " is NOT an Armstrong number");
        }

    }
    public static void main(String[] args) {
        int order = 3;
        check3DigArmstrongNumber(order, 153); // 153 is an Armstrong number
        check3DigArmstrongNumber(4, 1253); //1253 is NOT an Armstrong number
        // below can be used to find the length of number if asked for n number digit then by this we can get from here order variable
//        int num = 232424;
//        System.out.println(String.valueOf(num).getClass().getTypeName()); // java.lang.String
//        System.out.println(Integer.toString(num).getClass().getTypeName()); //java.lang.String
    }
}

/*
A positive integer of n digits is called an Armstrong number of order n (order is the number of digits) if
abcd... = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + ....

OR
 abcd... = a^n + b^n + c^n + d^n + ...
 EX:
 In case of an Armstrong number of 3 digits, the sum of cubes of each digit is equal to the number itself. For example:

153 = 1*1*1 + 5*5*5 + 3*3*3  // 153 is an Armstrong number.
--------------------------------------------
EX:
Input:153
Output: Yes
153 is an Armstrong number.
1*1*1 + 5*5*5 + 3*3*3 = 153

Input: 1253
Output: No
1253 is not a Armstrong Number
1*1*1*1 + 2*2*2*2 + 5*5*5*5 + 3*3*3*3 = 723
 */
