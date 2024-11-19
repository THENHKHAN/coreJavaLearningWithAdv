package kunalSeries.linear.search.leetcode.easy;

// TODO: 1295. Find Numbers with Even Number of Digits
//  https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class _1FindNumWIthEvenNumOfDigInArray {
    public static void main(String[] args) {
        int[] nums = {12,-345,2,6,7896}; // 2
//        int[] nums = {555,901,482,1771}; // 1
        int count = 0;
        for(int e: nums){
            if(checkNumOfDigInNum(e))
                count++;
        }
        System.out.println("Total Number which contains Even number of Digits : " + count);
    }

    public static boolean checkNumOfDigInNum(int num){// counting number of digits in each number
        // TODO: checking if the digit starts from zero
        //  check below to optimize for this function
        // it might be possible number is 0000 so in this case total digits is 4 so even
        // but in this question: see the Constraints - num will be >=1

        int digCount = 0;
        while(num!=0 ){ // num!=0 handle for + and - numbers  but num>0 only handle + numbers and not - numbers
            num /=10;
            digCount ++;
        }
        if(digCount%2==0)
            return true;
        return false;
    }


}

/*
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.


Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.
 */

/*
about checkNumOfDigInNum() fun:
time complexity of this method is
O(d), where d is the number of digits in num. Where as per the Constraints number can be of 1 or 6 digit(10^5 = 100000)
so for main():
So, the worst-case time complexity would be
O(n×100000)=O(n).
Overall Time Complexity
O(n), where 𝑛 is the size of the input array nums
*/

// TODO: for optimization - counting number of digits in any number
/*
**Concepts** : counting number of digits in any number
**Calculate the number of digits**: For each integer, use the logarithmic method to find the number of digits.
`(int)Math.log10(num) + 1 ` provides the count of digits in num.

int digits = (int) (Math.log10(num) + 1);
The expression Math.log10(num) + 1 is a mathematical technique used to find the number of digits in a positive integer num. Let's break down how it works.

Understanding Math.log10(num)
The logarithm base 10 of a number num, denoted as log10(num), gives you the power to which 10 must be raised to obtain num.
For example:
log10(100)= 2 because  10^2=100 .
log10(1000)=3 because 10^3=1000 .
log10(500) ≈2.7 because 10^2.7 ≈500.

Converting to an Integer:
								int digits = (int) (Math.log10(num) + 1);

**Special Cases to Consider:**
num = 0:
						log10(0) is undefined (leads to negative infinity). Thus, you should handle num = 0 as a special case since it has exactly 1 digit.

						int digits = (num == 0) ? 1 : (int) (Math.log10(num) + 1);
**Negative Numbers:** If you have negative numbers, use the absolute value (Math.abs(num)) to calculate the digit count.
					int digits = (num == 0) ? 1 : (int) (Math.log10(Math.abs(num)) + 1);

System.out.println((int) (Math.log10(5) + 1));        // Output: 1 (one digit)
System.out.println((int) (Math.log10(50) + 1));       // Output: 2 (two digits)
System.out.println((int) (Math.log10(999) + 1));      // Output: 3 (three digits)
System.out.println((int) (Math.log10(10000) + 1));    // Output: 5 (five digits)


Using Math.log10() is efficient with a time complexity of
O(1) because it's a mathematical computation and does not involve looping through digits like the traditional method.

Summary
Math.log10(num) + 1 is a quick way to find the number of digits in a positive integer.
Make sure to handle edge cases like num = 0 and negative numbers.
It's efficient and can be a good alternative to using a loop for counting digits, especially if you're optimizing for speed.


 */
