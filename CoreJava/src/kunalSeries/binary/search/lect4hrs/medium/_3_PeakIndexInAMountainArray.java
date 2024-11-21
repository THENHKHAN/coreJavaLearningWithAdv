package kunalSeries.binary.search.lect4hrs.medium;


// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ     at ts:1.57:00
// Aditya Board waala: https://www.youtube.com/watch?v=FzvK5uuaki8   NOT FOR THIS
// TODO: 852. Peak Index in a Mountain Array : USes increase to a peak element and then decrease (sorted in ASC as well DSC order ). hence 1st approach must be Binary Search.
// Other LC ref: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/


import java.util.Arrays;
// ALSO CALLED Bitonic Array  (increasing and decreasing)
public class _3_PeakIndexInAMountainArray {

    // But this will give TLE - since in the Question it asked to solve O(logN) where N is the size of array.
    // I solved it in this way linear search since i wanted go with Brute Force 1st.
    public int peakIndexInMountainArrayWithLinearSearch(int[] arr){
        int i1 = 0, i2 = 1;
            while (i1<i2){
                if (arr[i1]> arr[i2])
                    return i1;
                else {
                    i1 = i1+1;
                    i2 = i2+1;
                    if(i2>arr.length-1) // to resolving the ArrayOutOfBoundException
                        i2= arr.length-1;
                }

            }

        return -1;
    }

    public int peakIndexInMountainArray(int[] arr){

        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int middleIndx = l+(r-l)/2;
                                // middleIndx+1 will never be the ArrayIndexOutOfBoundsException BCZ at least 3 element mentioned. And middle index can never be the last index of the array.
            if (arr[middleIndx]<arr[middleIndx+1]) // we are in increasing part of array hence will look RIGHT side
                l = middleIndx + 1;

            else // arr[middleIndx]>arr[middleIndx+1]
                r = middleIndx-1;  // decreasing part of array hence will look LEFT side
        }
        return l; // will reach here when l>r (when l and r cross each other) only then will get the peak. Draw on paper you'll understand.

        // OTHER WAY just a small tweak: just in condiotn and else condition handling
        /*
                while (l<r){ // Prevents middleIndx + 1 from being out of bounds
                    int middleIndx = l+(r-l)/2;

                    if (arr[middleIndx]<arr[middleIndx+1])
                        l = middleIndx + 1; // here taking from next of middle since mid+1 > mid so mid ele can't be the peak element
                            // here checking b/w l mid mid+1  r  => mid+1 to r
                    else // arr[middleIndx]>arr[middleIndx+1]
                        r = middleIndx;  // decreasing part of array hence will look LEFT side
                        // here we are taking from mid since here Decr hence it might be possible a[mid] so it can also be the ans.
                        // here checking b/w l mid mid+1  r  => l to mid

                }

        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
                return l; // l and r converge to the peak index OR // or return r as both are equal
        */
    }


    public static void main(String[] args) {
        _3_PeakIndexInAMountainArray obj = new _3_PeakIndexInAMountainArray();

        int[] nums = {0,1,0}; // 1
//        int[] nums = {0,10,5,2}; // 1
//        int[] nums = {0,2,1,0}; // 1

//        int nums[] = new int[]{3, 5, 7, 9, 10, 90, 10, 8,  5,};  // 90 -> so index = 5
//        int[] nums = {1,2, 4, 5, 13, 10, 4, 2, 1}; //13 ->  4
//        int[] nums = {1,2, 4, 16, 11, 10, 4, 2, 1}; //16 ->  3
//        int[] nums = {0, 1, 2, 3, 4, 3, 2, 1}; //4 -> 4
//        int[] nums = {0, 2, 4, 3, 1}; //4 -> 2


        System.out.println("Array : " + Arrays.toString(nums));
//        int res = obj.peakIndexInMountainArrayWithLinearSearch(nums);
        int res = obj.peakIndexInMountainArray(nums); // with BS
        if(res !=-1)
            System.out.println("YES, The peak element " + nums[res] + "  and its index is : " + res);
        else // this will never run since in constraint it said total element >= 3   hence peak element always exists.
            System.out.println("NO, we didn't found the element peak element" );
    }
}

// TODO: Approach since here, there is no target element .
//  So compare mid and mid+1 element. As we know if arr[mid] < arr[mid+1] which means we are in INCREASING order part of array.
//                                                  Hence will get max value to the RIGHT from the middle. And
//   if arr[mid] > arr[mid+1]  means we are in DECREASING part of array.
//                          Hence will get Max or Peak element to LEFT of the middle.


/*

You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
Return the index of the peak element.
Your task is to solve it in O(log(n)) time complexity.

Example 2:

Input: arr = [0,2,1,0]

Output: 1

given test case
[0,1,0]
[0,10,5,2]    - means can be not height of same length
[0,2,1,0]
 */
