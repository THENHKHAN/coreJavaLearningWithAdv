### <div style="text-align: center;"> Selection Sort ALGO </div>
* It is a `Comparison sort` method.
* The Selection Sort algorithm finds the lowest value in an array and moves it to the front of the array.
* Selection sort is a sorting algorithm that ***`SELECTS`*** the `smallest element` from an unsorted list in each iteration and places that element at the beginning of the unsorted list. <br><br>
* `GFG`: Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly `selecting` the `smallest (or largest) element` from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire array is sorted.
* ### How??? [GFG](https://www.geeksforgeeks.org/selection-sort-algorithm-2/)
 * First we `find the smallest element` and swap it with the first element(move it to the correct position). This way we get the smallest element at its correct position.
 * Then we find the smallest among `remaining elements (or second smallest)` and move it to its correct position by swapping.
 * We keep doing this until we get all elements moved to correct position

* ### How it works: [W3School](https://www.w3schools.com/dsa/dsa_algo_selectionsort.php)
  * Go through the array to find the lowest value.
  * Move the lowest value to the front of the unsorted part of the array.
  * Go through the array again as many times as there are values in the array.

### Other Articles & YT Ref:
* [Programizz](https://www.programiz.com/dsa/selection-sort) Article
* [striver](https://takeuforward.org/sorting/selection-sort-algorithm/) Article   - approach great.
* [Kunal](https://www.youtube.com/watch?v=Nd4SCCIHFWk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=18) YT used
* [Babbar](https://www.youtube.com/watch?v=UdO2NeHB46c) YT used

### How does Selection Sort differ from Bubble Sort? 

* ***Answer***: Selection Sort selects the minimum element and places it in the correct position with fewer swaps, while Bubble Sort repeatedly swaps adjacent elements to sort the array. For more [GFG](https://www.geeksforgeeks.org/selection-sort-algorithm-2/)
* Here we are `selecting` as well as swapping(though fever only).