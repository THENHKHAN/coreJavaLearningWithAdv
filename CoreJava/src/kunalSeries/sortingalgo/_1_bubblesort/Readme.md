* Will be learning `Merge Sort` and `Quick Sort` in `Recursion` topic. <br>
### <div style="text-align: center;"> Bubble Sort </div>
* It is a `Comparison sort` method.
* `Compares adjacent` elements, and swaps them if they are in the wrong order
* Think of it as "bubbling up" the largest elements to the top (or end) of the list in each pass.
* Remember this way : `Bubbling out the Largest number` in each pass.
* Bubble sort also known  as `sinking` or `exchange sort`
* It is an `in-place` ALGO.
* Space: `O(1)` , TC: `Best - O(n)` if array is already sorted. `Worst- O(N^2)` if array is sorted in DESC order (In this case `j` never swaps for all value of i). For more [click](https://www.youtube.com/watch?v=F5MZyqRp_IM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=17) at TS:26:00:00
* ### Key Points: <br>
  *  It compares two adjacent elements and swaps them if needed.
  *    After each pass, the `largest unsorted element moves to its correct position.`
  *   It keeps sorting until no swaps are needed.
### What???
* In every step, compares two adjacent elements and swaps them if needed.
### Why???
* In every pass (after traversing whole array for ith element. Where `0<= i < size of array`,
* The largest element will `moved to the right end`. And this will be at 1st largest index.
* Similar `i=1`  the 2nd largest element will move to the 2nd largest index. take `[3,1,5,4,2]` and see on paper.
* In 2nd pass we don't have to compare with the last index element since it already sorted (or largest or sorted in the 1st pass.)
* Similar 3rd pass we skip the comparison with 1st and 2nd large element (since sorted in 1st and 2nd passes). In Simple `j<n-i-1`
* `i` will decide the number of passes and `j` will use for comparing the elements.
* `j` will be the inner loop and hence will be comparing & sorting the array.

```java
Definition: Bubble Sort is a simple sorting algorithm that repeatedly compares adjacent elements and swaps them if needed until the entire list is sorted.

Visual Example:

Sorting `[5, 3, 8, 6, 2]` in ascending order:

| Pass  | Step                                      | Result          |
|-------|-------------------------------------------|-----------------|
| 1     | Compare 5 and 3 → Swap                   | `[3, 5, 8, 6, 2]` |
|       | Compare 5 and 8 → No Swap                | `[3, 5, 8, 6, 2]` |
|       | Compare 8 and 6 → Swap                   | `[3, 5, 6, 8, 2]` |
|       | Compare 8 and 2 → Swap                   | `[3, 5, 6, 2, 8]` |
| 2     | Compare 3 and 5 → No Swap                | `[3, 5, 6, 2, 8]` |
|       | Compare 5 and 6 → No Swap                | `[3, 5, 6, 2, 8]` |
|       | Compare 6 and 2 → Swap                   | `[3, 5, 2, 6, 8]` |
| 3     | Compare 3 and 5 → No Swap                | `[3, 5, 2, 6, 8]` |
|       | Compare 5 and 2 → Swap                   | `[3, 2, 5, 6, 8]` |
| 4     | Compare 3 and 2 → Swap                   | `[2, 3, 5, 6, 8]` |

 The final sorted array is `[2, 3, 5, 6, 8]`.

```
* Read these article about the stable and unstable Algo:
* [NotesKunalLect](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/11-sorting/Handwritten%20notes%20on%20bubble%20sort.pdf.pdf)
* [link1_StackOverflow](https://stackoverflow.com/questions/1517793/what-is-stability-in-sorting-algorithms-and-why-is-it-important)
* [link2FGF1](https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/)
* [educative](https://www.educative.io/answers/stable-and-unstable-sorting-algorithms)
* [link2FGF2](https://www.geeksforgeeks.org/commonly-asked-algorithm-interview-questions-set-1/) also other interview asked questions
* [link3_interview kickstart](https://www.interviewkickstart.com/blogs/learn/stability-in-sorting-algorithms)