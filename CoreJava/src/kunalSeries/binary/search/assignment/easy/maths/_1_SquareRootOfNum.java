package kunalSeries.binary.search.assignment.easy.maths;


// TODO : 69. Sqrt(x) Intuition :  sorted in ascending order - since square root of any number will be greater than or equal zero
// so it will be in a range from 0 to n: so we can see we have a  number from 0 to n and we have to SEARCH correct number based on condition.
//  we can leverage the properties of squares and their monotonicity (i.e., the square of a number increases as the number itself increases).
// Hence SORTED SO we can use Binary search
// so basically we are SEARCHING NUMBER.
// sqrt(x) ≥0 for all x≥0   -> This means the square root of any non-negative number is always non-negative.
// EX: sqrt(25) -> 5 not -5      so ssimilar sqrt(8) - 2.43435 but since asked for only integer so 2
// also y<=x^1/2
// Hence Brute Force Search is the 1st choice
// Hence Binary Search is the 2nd choice
// https://leetcode.com/problems/sqrtx/description/

public class _1_SquareRootOfNum {

    private static int findSqrtBruteForce(int num) {

        if (num==1){
            return 1;
        }
// BRUTE FORCE: Instead of int, use long. This is because int only goes up to 2147395600,
// while long goes much higher than that. However, the expense is that you would have to convert to long, then back to int.
        long res = 0;
        long i = 0;

        while (i*i<=num){
            res = i; // we can remove this line if we want to return i-1 : with just one variable
            i++;

        }
        return (int)res; // or i-1;   see x=65 when i is 9 it wll break that's
    }

    private static int findSqrtBinarySearch(int num){
        if (num == 0 || num == 1) return num;
// The possible values of y  are between 0 and x, inclusive (bcz sqrt(x) ≤x ) for all x≥1).
        // initialize two pointers: so l= 0 , e = x itself
        long l = 0;
        long r = num;
        long mid = -1;
        int ans = -1;

        while (l<=r){
            mid = l +(r-l)/2; // already will be getting int value so no worry about only integer should return.
            if (mid*mid <= num){
                ans = (int)mid;
                l = mid+1; // bcz  this may ans exist greater than that
            }
            else
                r = mid-1;

        }

    return ans;
    }

    public static void main(String[] args) {
//        int num = 1;
//        int num = 4;
//        int num = 8;
//        int num = 14;
        int num = 2147395599; //  46339
//        int num = 2147395600; //  46340
        System.out.println("Brute Force - Square Root of " + num +" : " + findSqrtBruteForce(num)); //O(Sqrt(N))
        System.out.println("Binary Search- Square Root of " + num +" : " + findSqrtBinarySearch(num)); // O(logn)
        // well O(logN) is better TC than O(Sqrt(N))
    }


}

//TODO: Why you should use Binary Search  in this, the intuition
/*
ref1: https://leetcode.com/problems/sqrtx/solutions/3706594/easy-explained-solution-beats-100/
ref2: https://leetcode.com/problems/sqrtx/solutions/5980531/step-by-steps-solution-beginner-friendly-beats-100-user-in-each-solution-of-me/
// y <= (x)^1/2   - since it asked only the integer part.
Statement means:
        We need to find the square root of x, rounded down to the nearest integer, without using built-in functions. This problem has constraints that allow us to approach it in multiple ways, including binary search and brute force.

Why Binary Search Works????????????

Binary search is suitable for this problem because:

1-> The square of a number increases monotonically. If 𝑚^2 <x, then all integers less than 𝑚 are too small. Similarly, if 𝑚^2>x, then all integers greater than m are too large.
2-> This **monotonic property** of square values allows us to narrow down the search range efficiently.
3-> Instead of testing every possible number, binary search helps reduce the range by half in each iteration, making it highly efficient.
Thus, binary search is ideal for finding the square root when we have a range of possible values and a monotonic relationship.

Key Takeaways for Similar Problems:
1-> Monotonic Property: Binary search works well when the problem involves a monotonic function, such as checking powers, logs, or cumulative sums.
2-> Range Reduction: Problems where you can rule out half the search space in each step are prime candidates for binary search.
3-> Optimization over Brute Force: Binary search significantly improves efficiency compared to brute-force solutions, especially for large inputs.

some brute force : but not working in leetcode for value->  x = 2147395600
for x = 4
0×0=0, which is ≤4. Increment
1×1=1, which is ≤4. Increment
2×2=4, which is ≤4. Increment
3×3=9, which is >4. Stop the loop.
The square root of 4 is exactly 2, so the answer is 2.


why you were failing when declared as int  ( x = 2147395600)
You have declared i as an int and trying to do sqaure of i, which will throw error as int cannot hold such large values, use long to declare i or caste it i to long. But why do this when you can do it in O(log n) using Binary Search.
 */

// some more info about square root:
/*
Why is the square root of a negative number undefined?
Any number squared will produce a positive number, so there is no true square root of a negative number. Square roots of negative numbers can only be determined using the imaginary number called an iota, or i.

What does a negative square root mean?
The term square root applies to the positive square roots of numbers, and are called principal square roots. But their negative values multiplied together also produce the positive value, so the negative square roots are the negative versions of the principal square roots.

Can you find the square root of a negative number?
Yes. The square root of a negative number is the principal square root of the positive radicand multiplied by the imaginary square root of -1, or i.


 */