package kunalSeries.binary.search.assignment.easy;

// TODO : 278. First Bad Version : Intuition :  [1, 2, ..., n] and you want to find out in ASC Order OR minimize the number of calls to the API., hence BS used
// Hence Binary Search is the 1st choice
// Understand the question clearly. Solution is very easy.
// https://leetcode.com/problems/first-bad-version/description/

public class _4_FirstBadVersion {
    //  minimize the number of calls to the API.   Hint for Binary Search.
    // versions [1, 2, ..., n] and you want to find out. ASC Sorted order.elc

    // Simulate the "bad" version (hidden from the firstBadVersion function).
    private int bad;
    public _4_FirstBadVersion(int pick) {
        this.bad = pick;
    }

    // Simulated isBadVersion API. : // pre-defined api (as per the leetcode)
    public boolean isBadVersion(int version) {
        return version >= bad;
    }

    public int firstBadVersion(int n) {
        // Initialize the search range: 'l' is the start of the range, and 'r' is the end.
            int l = 1;
            int r = n;
        // Perform binary search to find the first bad version.
            while (l<=r){
                // Calculate the mid-point of the current range.
                // Using (l + (r - l) / 2) prevents overflow issues when l and r are very large.
                int firstBadVersion = l+(r-l)/2;
                // Check if the current mid-point is a bad version.
                if (isBadVersion(firstBadVersion))
                    // If 'mid' is a bad version, then the first bad version must be at 'mid' or before it.
                    // Narrow the search range to the left half by setting 'r' to 'mid - 1'.
                    r = firstBadVersion-1;
                else // if ( isBadVersion( firstBadVersion ) == false )
                    // If 'mid' is not a bad version, then the first bad version must be after 'mid'.
                    // Narrow the search range to the right half by setting 'l' to 'mid + 1'.
                    l = firstBadVersion+1;
            }

        // When the loop ends, 'l' points to the first bad version.
        // The range converges to a single element, which is the answer.
        return l;  // `l` will converge to the first bad version
    }

    // WIll be getting TLE for this
    public int firstBadVersionLinearSearch(int n){
        int ans = -1 ;
        for (int i = 1; i <= n ; i++) {
            if (isBadVersion(i)){
                ans =  i;
                break;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
//        int pick = 6;
        int bad = 1;
        _4_FirstBadVersion obj =new _4_FirstBadVersion(bad);

        int totalVersion = 1;

        System.out.println("All Versions from 1 to  : " + totalVersion);
        int correctFirstVersion = obj.firstBadVersion(totalVersion);
        int correctFirstVersionLS = obj.firstBadVersionLinearSearch(totalVersion);
        System.out.println("The Binary Searching first Bad Version guess : " + correctFirstVersion);
        System.out.println("The Linear Searching first Bad Version guess : " + correctFirstVersionLS);

    }
}
/*
TODO:  From 1 to n - series of number in ASC Order, hence BS used
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.



Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1


Constraints:

1 <= bad <= n <= 2^31 - 1
 */