package kunalSeries.binary.search.lect4hrs.hard;

// Ref: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ     at ts:2:18:00
// Aditya Board waala: https://www.youtube.com/watch?v=FzvK5uuaki8   NOT FOR THIS
// codestorywithMI penPaper :https://www.youtube.com/watch?v=wzHmgBIdQXA
// TODO: 1095. Find in Mountain Array : mountain array Hence similar to Peak Index in a Mountain Array  (sorted in ASC as well DSC order just like mountain). hence 1st approach must be Binary Search.
// Other LC ref: https://leetcode.com/problems/find-in-mountain-array/description/


import java.util.Arrays;

public class _1_FindTargetInMountainArray {

    public int searchOrderAgnostic(int[] mountainArr, int target,int start, int end, boolean isAscending) {
        int l = start;
        int r = end;
        // normal BS for searhing Target in
        while (l<=r){
            int mid = l+(r-l)/2;
            if (mountainArr[mid]==target)
                return mid;
            if (isAscending){  // Ascending order logic
                if (mountainArr[mid]>target) // search LEFT From mid
                    r = mid-1;
                else // (mountainArr[mid]<target)    //  search RIGHT From mid
                    l = mid+1;;
            } else {// Descending order logic
                if (mountainArr[mid]>target) // search RIGHT From mid  (toward smaller numbers)
                    l = mid+1;
                else    //mountainArr[mid]<target  search LEFT From mid (toward larger numbers)
                    r = mid-1;
            }
        }
        return -1;// if not found in left ZONE Or  right zone.
    }

    public int findPeakInMountainArray(int[] mountainArr) {
            int l = 0;
            int r = mountainArr.length-1;

            while (l<r){
                int middleIndx = l + (r-l)/2;
                if (mountainArr[middleIndx]<mountainArr[middleIndx+1]) // Search in ASC ZOne so RIGHT SEARCH
                    l = middleIndx+1; //  since arr[mid] < arr[mid+1] hence mid can't be peak since [mid+1] > mid.
               else // (mountainArr[middleIndx] > mountainArr[middleIndx+1] )  Search in DESC ZOne so LEFT SEARCH
                    r = middleIndx; // moving left hence mid element can also be the peak since mid>mid+1 since satisfying the condition of peak element
            }
        return l;// l and r converge to the peak index OR // or return r as both are equal
    }

    public int findInMountainArray(int target, int[] mountainArr) {
        int l = 0;
        int r = mountainArr.length-1;
        int peak = findPeakInMountainArray(mountainArr);
        System.out.println("Peak element : " + mountainArr[peak] + " its index: " + peak);
        int minIndx = searchOrderAgnostic(mountainArr, target, l, peak, true); // will search in ASC zone
        if (minIndx != -1){
            return minIndx;
        }
        System.out.println("Min Ind from ASC ZONE : " + minIndx + " its element: No element found in left side");// not neede this line. Just to see the print that's y i used
        int maxIndx = searchOrderAgnostic(mountainArr, target, peak+1, mountainArr.length-1,false); // will search in DSC zone
        System.out.println("Min Ind from DSC ZONE : " + maxIndx + " its element: " + (maxIndx==-1?"No elemnt found in Right zone as well " : mountainArr[maxIndx]));

        return maxIndx;

    }



    public static void main(String[] args) {
        _1_FindTargetInMountainArray obj = new _1_FindTargetInMountainArray();
//        int nums[] = new int[]{1,2,3,4,5,3,1};
//        int target = 3;// left 3 hence ind 2

//        int nums[] = new int[]{0,1,2,4,2,1};
//        int target = 3;// -1

        int nums[] = new int[]{3,5,3,2,0};
        int target = 3;// -1

//        int nums[] = new int[]{1,2,3,4,5,3,1,0};
//        int target = 0;// 0 hence ind 7

//        int nums[] = new int[]{3, 5, 7, 9, 10, 90, 100, 10, 4, 2, 1};
//        int target = 10;// 4


//        int[] nums = {1, 4, 5, 13, 20, 28, 38,900, 20, 13, 4, 2};
//        int target = 13; // 3
        System.out.println("Array : " + Arrays.toString(nums));
        int res = obj.findInMountainArray(target, nums);
        if(res !=-1)
            System.out.println("YES, we found the element " + target + "  and its index is : " + res);
        else
            System.out.println("NO, we didn't found the element " + target);
    }

}
// ex: [1,2,3,4,5,3,1], target = 3
// 1-> find the peak element  => index 4
// 2-> so now we know left will be ASC so Binary search target  in (0,4)
// 3-> If not found then search in DESC Array (4,r)
/*
Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 */