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
  #### My thought:
  * We have to 1st find the minimum value and then put at the ith pass(round) using swapping with the current ith element. 
  * ith position par hame minimum value put karni hoti hai. Means ith wale ko swap with the minimum value from the unsorted range.

### <div style="text-align: left;"> Insertion Sort </div>
* For every index, put that index element at the correct index of LHS 
* Partially Sorting the array
* The Insertion Sort algorithm uses one part of the array to hold the sorted values, and the other part of the array to hold values that are not sorted yet.
* The algorithm takes one value at a time from the unsorted part of the array and puts it into the right place in the sorted part of the array, until the array is sorted.

* ### How it works:: [w3School](https://www.w3schools.com/dsa/dsa_algo_insertionsort.php)<br>
  *  Take the first value from the unsorted part of the array.
  *  Move the value into the correct place in the sorted part of the array.
  *  Go through the unsorted part of the array again as many times as there are values.
  
* ###  When to use???
  * Used for smaller value of N.
  * Array is partially sorted.
  * It takes part in hybrid sorting algo.


### <div style="text-align: left;"> Cyclic sort algorithm </div>
* `Amazon`, `google`, `facebook`, `microsoft` etc. Directly ASKED Questions `from this Pattern`
* It is an `in-place` and **`unstable`** sorting algorithm. Cycle sort forces an array to be `factored into a number of cycles` where e`very element can rotate` in order to produce a sorted array. The time complexity of cycle sort is `O(n^2)`, even in the best case.
* It is particularly useful when sorting arrays containing elements with a small range of values.
* The basic idea behind cycle sort is to divide the input array into cycles, where each cycle consists of elements that belong to the same position in the sorted output array. The algorithm then performs a series of swaps to place each element in its correct position within its cycle, until all cycles are complete and the array is sorted.
  * **_2nd Type (Mostly Asked from this)_** : [GFG-Method-2](https://www.geeksforgeeks.org/cycle-sort/) -> This method is `only applicable` when given `array values or elements are in the range of 1 to N or  0 to N`. In this method, we do not need to rotate an array

     * **Approach :** All the given array values should be in the `range of 1 to N` or `0 to N`. If the range is `1 to N ` then every array element’s correct position will be the `index == value-1` i.e. means at the 0th index value will be 1 similarly at the 1st index position value will be 2 and so on till nth value. <br> 
                       similarly `for 0 to N values` correct index position of each array element or `value will be the same as its value` i.e. at 0th index 0 will be there 1st position 1 will be there.
                        
<br><br>
* _**Conclusion**_: The Range is the Biggest `Clue` or `Hint/Intuition` to solve sorting questions or any questions ([example-finding missing number leetcode](https://leetcode.com/problems/missing-number/description/))
    * **Problem Perspective**  : It helps to solve questions not only sorting number but also if you see those range type mention then try to think about this algo 1st. Specially for finding num. [find Missing Num](https://leetcode.com/submissions/detail/1466429363/), [find all disparaged num in array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/) , [find duplicate number](https://leetcode.com/problems/find-the-duplicate-number/description/) 
* **Articles**:
    * [*kunal](https://www.youtube.com/watch?v=JfinxytTYFQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=20) - explained 2nd Type of above GFG
    * [educative](https://www.educative.io/answers/what-is-a-cyclic-sort-algorithm)
    * [GFG](https://www.geeksforgeeks.org/cycle-sort/)
    * [JavaPoint](https://www.javatpoint.com/cycle-sort)
    * [Medium](https://blog.stackademic.com/coding-pattern-cyclic-sort-96511b0f60ac)
    * [SomeQuestionsPattern On LC Solved With article](https://leetcode.com/discuss/study-guide/2958275/cyclic-sort-important-pattern)
    * [PaperPDF](https://watermark.silverchair.com/330365.pdf?token=AQECAHi208BE49Ooan9kkhW_Ercy7Dm3ZL_9Cf3qfKAc485ysgAAA1UwggNRBgkqhkiG9w0BBwagggNCMIIDPgIBADCCAzcGCSqGSIb3DQEHATAeBglghkgBZQMEAS4wEQQMN5ebnQkhBGk_8rERAgEQgIIDCEfhKlR0-8wXD2NW-1BULkr0oGAPwFmJp6E6YCTayozE4wPyi5yShDRZY8jqAN4bJcS_0rtIRW_ARJIl0BilSKgSJLhlrIkrwIUZIxk_QgLRrhDH94pxqWIUcmCFA8g9r2RCbG6e9HDpUv1d7mio3ATsXdBjUxlpdS-0sLg7R2E3HbW6X_JoTKXQdKZrUmpKbS88DFmFSM-o7alwqo91gGH6TcW8LT2uKtCLXAkpZxNoVyGI7fjVD1Wy1Qd38I_Dzr5MmEjuQdaJKwpQfpCIb8vHP_VvHxJRaF2KVl41e3FHat-pDmxEHpNSWzNkTMFOT44fWz1jNZ8_QUTfJOpEyWA2Nd08xRGekDW_X0uBF2oDX7McoBfHKLO9fWKZ1U8T0XsgDrBhnZot2Z8gTR4rBvrnsmLqd9A8s-VjSsyXsCyKvhPHXRLkmDwukQqw-Zt6lDJj3AwyhRpF_5HQT7oc8xSukP09JltYipn6Slx6JRGaXUT9OoTFvELooeb1RZB364AbfM4SR-CMNdal0NWmuCtPUeXHnR12XB0TAvtQuNL31t4U0NMCuMh-sljppSRQXrIIpxMg3GXnvHHkEWPVF30h8PbJYNMbF84g-s3QpDmspy_IEYIg2vcPNbDgqQfgqXpJE5SUFdNQdiUD8LQp54afDDtf8WncdeJY8Mo6Z-pbG8nIDAyXHtOqg-Uthswzkb52yvDr6a35C6TH2fACf7YXgNLR2qAuD3x_qSbg4KUf0qIARmPoOfiOnr0ZnX5wK6_NXGHCt3ASYfEY6tp8bA8jKrlgwbo0O2W4bMgmtmsI3p-MU-cuTPS-F0Pf0VG--jM1__RrQpJsqJm4Y_OnPd-GaZG8bTAjalpAuCd5ZTFvHOCeRgI-U_2ZKGHFX_h5PuQKwlCA838t7q1wJXxB2Ick1qX0dxCbqMDXJJiRocnJcpyxE7f82fXetuAlPTSOBT7iixMfkOZBsiDZSfI00VQwK0KmQ6knu9isWJBskHBl8fF3Hnvczv0JUkznAWvOyC8mX_LgeL-6)
* Time Complexity Analysis: <br>
    * Worst Case : O(n)   -  but the above type-1 O(n^2) in all three cases<br>
    * Average Case: O(n) <br>
    * Best Case : O(n) <br>
    * Auxiliary Space: O(1) <br>

* **Advantage of Cycle sort**:  <br>
  * No additional storage is required.
  * in-place sorting algorithm.
  * A minimum number of writes to the memory.
  * Cycle sort is useful when the array is stored in EEPROM or FLASH.

* **Application  of Cycle sort:** <br>
  * This sorting algorithm is best suited for situations where memory write or swap operations are costly.
  * Useful for complex problems.   
  