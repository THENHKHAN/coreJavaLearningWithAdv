* `NOTE`: Will be learning `Merge Sort` and `Quick Sort` in `Recursion` topic. <br>
* In every sorting algo, will be sorting step by step.
* They will be differed by each step(`what are they doing`).This is what make all the Algo different from each other.

### <div style="text-align: left;"> Bubble Sort </div>
* It is a `Comparison sort` method.
* `Compares adjacent` elements, and swaps them if they are in the wrong order
* Think of it as "bubbling up" the largest elements to the top (or end) of the list in each pass.
* The word `Bubble` comes from how this algorithm works, it makes the highest values `bubble up`.
* ### Key Points: <br>
  *  It compares two adjacent elements and swaps them if needed.
  *    After each pass, the `largest unsorted element moves to its correct position.`
  *   It keeps sorting until no swaps are needed.

### <div style="text-align: left;"> Selection Sort </div>
[GFG](https://www.geeksforgeeks.org/selection-sort-algorithm-2/)<br>
Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly `selecting` the `smallest (or largest) element` from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire array is sorted.
* First we find the smallest element and swap it with the first element. This way we get the smallest element at its correct position.
* Then we find the smallest among `remaining elements (or second smallest)` and move it to its correct position by swapping.
* We keep doing this until we get all elements moved to correct position
### My thought:
  * We have to 1st find the minimum value and then put at the ith pass(round) using swapping with the current ith element. 
  * ith position par hame minimum value put karni hoti hai. Means ith wale ko swap with the minimum value from the unsorted range.
### <div style="text-align: left;"> Insertion Sort </div>
