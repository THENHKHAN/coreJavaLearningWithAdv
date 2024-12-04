package kunalSeries.binary.search.assignment.easy;

// TODO : 374. Guess Number Higher or Lower : Intuition :  From 1 to n - series of number in ASC Order, hence BS used
// Hence Binary Search is the 1st choice
// Understand the question clearly. Solution is very easy.
// https://leetcode.com/problems/guess-number-higher-or-lower/description/

public class _3_GuessNumHigherOrLower {

    // Simulating the guess API with a hidden number.
    private int pick; // This is the hidden number to guess
    public _3_GuessNumHigherOrLower(int pick) {
        this.pick = pick;
    }

    // pre-defined api (as per the leetcode)
    public int guess(int num){
        if (num == this.pick)
            return 0;
        else if (num > this.pick ) // Your guess is higher than the number I picked
            return -1;
        else // num < pick // Your guess is lower than the number I picked
            return 1;
    }

    public int guessNumber(int n) {
            int l = 1;
            int r = n;
            int mid = -1;
            while (l<=r){
                mid = l+(r-l)/2;
                int check = guess(mid);
                if (check == 0)
                    return mid;
                else if (check == 1) // if guess is lower than the number I picked
                    l = mid+1;
                else // check==-1 // // if guess is higher than the number I picked
                    r = mid-1;
            }

        return mid;
    }

    // WIll be getting TLE for this
    public int guessNumberLinearSearch(int n){
        int ans = -1 ;
        for (int i = 1; i <= n ; i++) {
            if (guess(i) == 0){
                ans = i;
                break;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
//        int pick = 6;
        int pick = 1;
        _3_GuessNumHigherOrLower obj =new _3_GuessNumHigherOrLower(pick);

        int higherLimitNum = 10;
//        int higherLimitNum = 1;
//        int higherLimitNum = 2;

        System.out.println("Higher number till will be : " + higherLimitNum);
        int correctGuess = obj.guessNumber(higherLimitNum);// Guess between 1 and 10
        int correctGuessLS = obj.guessNumberLinearSearch(higherLimitNum);// Guess between 1 and 10
        System.out.println("The Binary Searching correct guess : " + correctGuess);
        System.out.println("The Linear Searching correct guess : " + correctGuessLS);

    }
}
/*
TODO:  From 1 to n - series of number in ASC Order, hence BS used
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1


Constraints:

Constraints:

1 <= n <= 2^31 - 1              ---- int max value
1 <= pick <= n
 */