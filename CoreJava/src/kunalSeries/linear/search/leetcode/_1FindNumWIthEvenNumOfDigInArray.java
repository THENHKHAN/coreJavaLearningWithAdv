package kunalSeries.linear.search.leetcode;

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
