package kunalSeries.recursionlearning.basicintro;
// TODO: https://www.youtube.com/watch?v=M2uO2nMT0Bk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24
// TS: 00:59:00 kunal
// Find the nth fibonacci number using Recursion
public class _4_BinarySearchWithRecursion {

    public static int binarySearchWithRecursion( int[] arr, int target, int l, int r){ // introducing l&r in params since things(reducing search space) are depends on this that's y.
            // JUST Determine what variable you'll need to change then just take them in the function Params. DON'T OVERTHINK
        // i.e. the variable you'll need in recurrence call. Put in the function Params without thinking twice.
        if (l>r) // base condition - when recurrence call stop
            return -1;

        // now checks will here since we know in Normal Binary Search.
        int mid = l+(r-l)/2;
        if (arr[mid]==target)
            return mid;

        if (arr[mid]>target) // then we should change something - Need to move from mid to left
            return binarySearchWithRecursion(arr, target, l, mid-1);
            // no else condition since above have a return so either it will come return from the function.
        // arr[m]>target
        return binarySearchWithRecursion(arr, target, mid+1, r);
        // since return type of function is int so make sure you'll be returning int type. In some case we have make return type as used in the function return type.
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
