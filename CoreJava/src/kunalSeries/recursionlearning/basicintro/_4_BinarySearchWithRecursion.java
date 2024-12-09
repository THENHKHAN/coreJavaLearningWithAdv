package kunalSeries.recursionlearning.basicintro;
// TODO: https://www.youtube.com/watch?v=M2uO2nMT0Bk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24
// TS: 00:59:00 kunal
// Find the nth fibonacci number using Recursion
public class _4_BinarySearchWithRecursion {

    public static int binarySearchWithRecursion( int[] arr, int target, int l, int r){ // introducing l&r in params since things(reducing search space) are depends on this that's y.

        if (l>r) // base condition - when recurrence call stop
            return -1;
        int mid = l+(r-l)/2;
        if (arr[mid]==target)
            return mid;

        if (arr[mid]>target) // then we should change something - Need to move from mid to left
            return binarySearchWithRecursion(arr, target, l, mid-1);
            // no else condition since above have a return so either it will come return from the function.
        // arr[m]>target
        return binarySearchWithRecursion(arr, target, mid+1, r);

    }

    public static void main(String[] args) {
        int[] arr = {2,5,8,10,23,25,36,78};
        int target = 8;

        int ind = binarySearchWithRecursion(arr, target, 0, arr.length-1);

        if(ind != -1)
            System.out.println("YES, we found the element " + target + "  and its index is : " + ind);
        else
            System.out.println("NO, we didn't found the element " + target);
    }
}