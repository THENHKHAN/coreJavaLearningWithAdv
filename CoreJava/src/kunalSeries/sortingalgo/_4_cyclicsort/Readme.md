### <div style="text-align: left;"> Pattern of Cyclic SOrt algo use (type-2 [0 n] or [1 n]) </div>
The **cyclic sort concept** is particularly well-suited for problems that involve finding the smallest missing positive
integer because it _`allows us to place each element in its correct position in the array without needing extra space`_
or additional sorting algorithms. The **intuition behind using cyclic sort** here is to `leverage the index-based mapping`
and `directly place each element in its "correct" index`, which corresponds to the number itself.

### <div style="text-align: left;"> When and why to use cyclic sort?? </div>

Cyclic sort is especially useful when dealing with arrays that `contain consecutive integers within a fixed range.` <br>
**It is effective in the following cases:**<br>
* **Detecting missing numbers:** In arrays where one or more elements are missing, cyclic sorting helps efficiently identify those missing numbers.
* **Finding duplicates:** It can also be used to find duplicate numbers in an array, as it quickly places elements where they belong and identifies those that are out of place.
* [Readmore](https://www.educative.io/answers/what-is-a-cyclic-sort-algorithm) | [educative](https://www.educative.io/answers/when-and-why-do-we-use-cyclic-sort)