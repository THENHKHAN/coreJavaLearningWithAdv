package kunalSeries.binary.search.lect4hrs.medium;

// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ     at ts:1.28:00
// Aditya Board waala: https://www.youtube.com/watch?v=FzvK5uuaki8
// TODO: GFG (asked in Amazon). Find position of an element in a sorted array of infinite numbers : Since sorted hence 1st approach must be Binary Search.
// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/         with solution
// Other LC ref: https://leetcode.com/discuss/interview-experience/1979273/infinite-sorted-array
// THEORY EXPLAINED VERY WELL.
import java.util.Arrays;

public class _2_FindPosOfEleInASortedInfiniteNumOfArray {

    public int[] searchRange(int[] arr, int target){
        // first find the range
        // first start with a box of size 2
        int l= 0;
        int r= 1;
        int currVal = arr[0];
        // condition for the target to lie in the range
        while (target>currVal){
            if (2*r< arr.length-1){ //length to prevent ArrayOutOfBoundException. checking that 2*h doesn't exceed array
                System.out.println("left & right indX : " + l + ", "+r );
                l = r;
                r = 2*r; //
            }else
                r= arr.length-1;
            currVal = arr[r];
        }
//        System.out.println("left & right indX : " + l + ", "+r );
        return new int[]{l, r};
    }

    public int findPositionInInfiniteArray(int[] arr, int target){

        int[] range = searchRange(arr, target);
        int l = range[0];
        int r = range[1];
//        int pos = BinarySearch(arr, target, range[0], range[1]);
        // Binary Search
        while (l<=r){
            // find the middle element
            //int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int middleINdx = l +  (r-l)/2;
            if (arr[middleINdx]>target)
                r = middleINdx-1;
            else if(arr[middleINdx]<target)
                l = middleINdx+1;
            else
                return middleINdx;
        }

        return -1;
    }

    public static void main(String[] args) {
        _2_FindPosOfEleInASortedInfiniteNumOfArray obj = new _2_FindPosOfEleInASortedInfiniteNumOfArray();
        int nums[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;// 4


//        int[] nums = {1, 4, 5, 13, 20, 28, 38, 48};
//        int target = 13;
        System.out.println("Array : " + Arrays.toString(nums));
        int res = obj.findPositionInInfiniteArray(nums, target);
        if(res !=-1)
            System.out.println("YES, we found the element " + target + "  and its index is : " + res);
        else
            System.out.println("NO, we didn't found the element " + target);
    }
}

// prob : there is no way to initialize the right or end index since size is infinite.
        // clue to find : target element will be always be lie in b/w start and end index. Or target is always bounded b/w start & end index.
        // since we don't know the end, but we are sure it will be greater than the start index. So we can assume just next to the start index ==> end = stat+1;
// now start draw an infinite array with this approach. aAnd take a target. And remember target will always be b/w start and end. Now think of BS.
// Here if target lie to the RIGHT then were doing stat++ and end as it is But in this case  start = previous end and make end == end*2.
// while searching, we can get in situation target < number then we have to move LEFT. Now we are bounded in FINITE ARRAY and have start and end  index.
// NOW APPLY BS as usual.
// SO BASICALLY we were trying to find the end index bound.

// TODO: IMP - WHY Doubling the end pointer?????
/*
The reason for doubling the range size instead of tripling or incrementing by one index lies in optimizing the time complexity for finding the range where the
        target element lies in an infinite sorted array.


 */
/*
Explanation:

1- Doubling is Optimal for Exponential Growth:

-> The array is treated as infinite, meaning we do not know its size.
-> Doubling the range (e.g., l = r and r = 2 * r) ensures that we cover the search space exponentially. This is the fastest way
                        to "zoom out" and find a range that includes the target element.
-> In terms of time complexity, doubling the range ensures that we need only
                        O(log(target_index)) steps to find a suitable range.

2- Tripling or Incrementing Would Be Less Efficient:

    -> Tripling: While tripling the range (r=3×r) might work, it unnecessarily expands the search range faster than needed in
            most cases, and wastes iterations by overshooting the target range.
    -> Incrementing by 1: Expanding the range one index at a time (r=r+1) results in a linear time complexity (O(n))
            to find the range. This defeats the purpose of optimizing the search for infinite arrays.

3- Doubling Mimics Binary Search Philosophy:

     ->Doubling the range ensures that the search narrows down quickly to the region containing the target.
     ->After determining the range, binary search is applied to further narrow down the target’s exact position within
        O(logn).

4- Array Access Efficiency:

       -> By doubling the range, you minimize the number of array accesses. Accessing elements in very large arrays
            (or infinite arrays simulated by streams) can be expensive.


5* - Why Doubling Works:
       -> Suppose the target index is k:

        a) Doubling ensures you find a range containing k in O(logk) iterations:
                First range: [0,1]
                Second range:[1,2]
                Third range: [2,4]
                Fourth range:[4,8], and so on...
        b) Once the range is found (e.g.,[8,16]), binary search in that range takes O(logr) time.

6* - In summary:
       -> Doubling strikes the right balance between range expansion and computational efficiency.
       ->  It avoids the pitfalls of overshooting (tripling) or being too slow (incrementing by one).
 */