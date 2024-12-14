### <div style="text-align: left;"> [Time Complexity](https://www.youtube.com/watch?v=mV3wrLBbuuE&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24) </div>
* It is a function that gives us the relationship about how the time will grow as the input grows. Ex: Linear Search for target in an array (y=mx+c) straight line.
* We always look for worst case means from beyond that we can go.
* Always ignore less dominating terms: `N^3 + logN ===> N^3`. You can check with n=1 million seconds. It will give (1 million)^3+ log(1mCube) => 1mCube+6=== 1mCube.  Since 6 is insignificant as compared to 1mCube.
* Why we ignore the lower and constant values while calculating the space & time complexity?
    * Because we need a relationship between the time and input size. Want more detail [check](https://www.youtube.com/watch?v=mV3wrLBbuuE&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24) at 00:25:00
    * We don't care about the actual time , we just need relationship.


### <div style="text-align: left;"> [Space Complexity](https://www.youtube.com/watch?v=mV3wrLBbuuE&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24):00:55:00 </div>
* Auxiliary Space is the extra space or temporary sued by an algorithm.
* Space Complexity of an algorithm is total space taken by the algorithm with respect to the input size. Space Complexity includes both Auxiliary space and space used by input.
* For example, if we want to compare standard sorting algorithms on the basis of space, then **Auxiliary Space** would be a better criteria than **Space Complexity**.
  - **Merge Sort** uses **O(n)** auxiliary space.
  - **Insertion Sort** and **Heap Sort** use **O(1)** auxiliary space.

  Space complexity of all these sorting algorithms is **O(n)** though.

### <div style="text-align: left;"> [Akra-Bazzi Theorem](https://www.youtube.com/watch?v=mV3wrLBbuuE&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=24): 01:14:00 </div>
* To find Complex given statement and asked to find the time complexity  (ex- merge sort)
```T(N) = 2T(N/2) + (N-1) , Binary search - T(N) = T(N/2) + O(1)```
* We use **Akra-Bazzi Theorem**. It uses a little integration as well. But make very easy to find _time complexity of a **Divide and Conquer recurrence** relation_.
* Some Articles other than the YT:
  * [GFG](https://www.geeksforgeeks.org/akra-bazzi-method-for-finding-the-time-complexities/)
  * [Wikipedia](https://en.wikipedia.org/wiki/Akra%E2%80%93Bazzi_method)
  * [baeldung that green type](https://www.baeldung.com/cs/akra-bazzi)
  * [Paper MIT](https://courses.csail.mit.edu/6.046/fall02/handouts/akrabazzi.pdf)