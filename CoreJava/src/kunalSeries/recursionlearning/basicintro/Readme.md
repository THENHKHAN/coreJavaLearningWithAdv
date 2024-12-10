### <div style="text-align: center;"> [Recursion](https://www.youtube.com/watch?v=M2uO2nMT0Bk&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=23&pp=iAQB) </div>


### <div style="text-align: left;"> Why Recursion: </div>
* It helps us in solving bigger/complex problem in a simpler way.
* We can convert recursion solution into iteration and vice versa.
* Space Complexity won't be constant because of RECURSIVE CALLS.
* It helps us in `BREAKING DOWN a Bigger problems into SMALLER` problem.
* Try to see whether you can break it down bigger to smaller problem. **EX:** `fib(n) = fib(n-1)+fib(n-2)`

### <div style="text-align: left;"> How to understand & Approach a problem: </div>
1. Identify if you can break down problem into smaller problem.
2. Write the recurrence relation(the formula that make the bigger to smaller problem) if needed.
3. Draw the recursive Tree.
4. About the Tree: <br>
    *  See the flow of function, how they are getting in STACK.
    * Identify and focus on LEFT tree calls` ( fib(n-1) )` and RIGHT tree calls `( fib(n-2) )` for ex: **fibo example**.
    * How? Draw the tree and pointer again and again using PEN and Paper **(MUST)**.
    * Use a DEBUGGER to see the flow.

5. See how values and what type of value(int, str, e.t.c) are returned at each step. See where the function call will come out. In the end, you'll come out of the main() function. 
6. Most Important after above - This is where I was used to get confused most of the time:
    * **Working with variables:**
      1. **return type:** if return type is mention in the function then always return after recurrence call just do it DON'T OverThink. When see a return type then in recurrence call must be return.
      2. **params:** variable on which **dependency** is there then take them in the params (**for ex:** In BS- search space is relying on `l` and `r` hence take them as well in the args).  The **variable you'll need in recurrence call, put in the function Params without thinking twice**.
      3. **introduced in the body or function Body** : 

* **Ex**: Binary Search if you want to search in size of array N. `f(N) = O(1) + O(N/2)`. O(1) for comparison with mid element and remaining N/2 search i.e. N/2 (half of array)  in each step reduced, it will be divided into  N/2 in each step. 

* **Tips**: Make sure to return the result of a function call of  the return type(we are talking about function definition 1st line where that function is returning anything or not).  

### <div style="text-align: left;"> Types of Recurrence Relation: </div>
1. **Linear recurrence relation:** ex- **fibo** : `fibo(n) = f(n-1) +f(n-2)`. Linearly
2. **Divide and Conquer relation:** ex: **Binary** : `F(N) = O(1) + F(N/2)`. Diving with `some factor` (Here in BS factor is 2). so it will be more faster than adding/subtracting one by one or linearly.

**Tips (vvv):**  DON'T Overthink.




### <div style="text-align: left;"> Tail Recursion: </div>
In this type of recursion, the `recursive call is the last operation in the function`. The result of the recursive call is directly returned without any further computation. Tail recursion is generally more memory-efficient because the compiler or interpreter can optimize the recursive calls to avoid using extra stack space.
### <div style="text-align: left;"> Non-Tail Recursion: </div>
In this type, the `recursive call is followed by additional computation after the call`. It requires more memory, as the function’s state must be saved until the recursive calls are completed.

#### Tail Recursion Example:
```java
public class TailRecursionExample {

    public static int factorialTail(int n, int accumulator) {
        System.out.println("Factorial tail: n = " + n + ", accumulator = " + accumulator);
        if (n == 0) {
            return accumulator;
        } else {
            return factorialTail(n - 1, n * accumulator);
        }
    }

    public static void main(String[] args) {
        int result = factorialTail(4, 1); // Start with accumulator = 1
        System.out.println("Factorial (tail recursion) of 4: " + result);
    }
}
// OUTPUT:
/*
Factorial tail: n = 4, accumulator = 1
Factorial tail: n = 3, accumulator = 4
Factorial tail: n = 2, accumulator = 12
Factorial tail: n = 1, accumulator = 24
Factorial tail: n = 0, accumulator = 24
Factorial (tail recursion) of 4: 24
*/
```
NOTE: for more check [printNum1To5](_2_RecursionFunctionExecutionPrint1To5.java) example.

#### Non-Tail Recursion in Java:

```java
public class NonTailRecursionExample {

    public static int factorialNonTail(int n) {
        System.out.println("Factorial non-tail: n = " + n);
        if (n == 0) {
            return 1;
        } else {
            return n * factorialNonTail(n - 1); // here after computation we are multiplying by n (this extra computation)
        }
    }

    public static void main(String[] args) {
        int result = factorialNonTail(4); // No accumulator used
        System.out.println("Factorial (non-tail recursion) of 4: " + result);
    }
}


/* OUTPUT: 
Factorial non-tail: n = 4
Factorial non-tail: n = 3
Factorial non-tail: n = 2
Factorial non-tail: n = 1
Factorial non-tail: n = 0
Factorial (non-tail recursion) of 4: 24

*/
```
NOTE: for more check [find nth Fibo Number](_3_FibonacciNthFiboNumber.java) example.
