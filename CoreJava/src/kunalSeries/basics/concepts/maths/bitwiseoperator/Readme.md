## Holded this [lecture-25](https://www.youtube.com/watch?v=fzip9Aml6og&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=73): 00:47:00 
**Following this Kunal Lecture :** <br>
         - [Notes](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/tree/main/lectures/16-math) <br>
         - [Lecture](https://www.youtube.com/watch?v=fzip9Aml6og&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=46) <br>
**Are bitwise operators only applicable to integer types?**
* In Java, bitwise operators perform operations on integer data at the individual bit-level. Here, the `integer` data includes `byte`, `short`, `int`, and `long` types of data.
* Bitwise operators are available in most languages that support integer data types, but the behavior of these operators and the size of the integers they work on may vary. Most languages allow bit-level manipulation of integer types, making bitwise operations a common feature across many programming environments.
1. **Bitwise AND (&) Operator:**
      * The bitwise AND & operator returns 1 if and only if both the operands are 1. Otherwise, it returns 0.
      * **Observation:** When you `AND (&)` with 1 with any number , digits remains the same. or The bitwise AND operation keeps the bits of the original number unchanged when ANDed with 255 or any other number where all bits are 1.
     ```c
            12 = 00001100 (In Binary)
            Bitwise AND Operation of 12 and
            00001100
          & 11111111
            RESULT : 00001100 = 12 (In Decimal)
      ```
2. **Bitwise OR (|)  Operator:**
      * The bitwise `OR (|)` operator returns `1` if at _least one of the operands is 1_. Otherwise, it returns 0.
3. **Bitwise XOR (^)  Operator:**
      * Also called exclusive OR. The bitwise `XOR (^)` operator returns 1 _if and only if one of the operands is 1_. However, if both the operands are 0 or if both are 1, then the result is 0. OR It `returns 1 if the bits are different` (i.e., one is 1 and the other is 0), and 0 if the bits are the same.
      * **Observation:** When you XOR (^) a number with 1, each bit of the number will be flipped (i.e., it gets the complement of each bit). In other words, `a ^ 1 results in the complement of a (i.e., ~a)`.
      ```c
             12 = 00001100 (In Binary)  // Original number
             XOR Operation with 1:
             00001100   // a (12 in binary)
           ^ 11111111 // 255 (all bits set to 1)
             -----------
             11110011    // Result (243 in decimal)

             RESULT : 11110011  // Result (243 in decimal) 
   Some prop : 
   a^1 = ~a
   a^0 = a
   a^a = 0
      ```

4. **Shift Operators:** 
      1. **[Left Shift Operator(<<)](https://www.geeksforgeeks.org/left-shift-operator-in-java/):** The left shift operator`(<<)` shifts all bits towards the left by a certain number of specified bits. It is denoted by <<. `left shift x by n positions <=> x * 2^n`
            ```c              
                 left shift x by n positions <=> x * 2^n
                 Here,
                 x: an integer
                 n: a non-negative integer
              Observation:  if you left shif any number with 1 then it will double the number :
              Ex: a=5, n = 1 ==> 5<<1 ===> 5*2^1 => 5 * 2 => 10
              so for n=1 ==> a<<1 ==> 2a
          ```
         * **Applications of LEFT Shift Operator:** <br>
            * Multiplication by Powers of Two: Left shifting a number by n positions is equivalent to multiplying it by 2^n and is much faster than normal multiplication. <br>
            * Efficient Calculations: Used in performance-critical applications where arithmetic operations need to be fast. <br>
            * Bit Manipulation:  Common in low-level programming, such as embedded systems and hardware interfacing.
         * **Articles:** know how its working internally
            * [log2base2](https://www.log2base2.com/C/bitwise/bitwise-left-shift-operator-in-c.html)
         
      2. **[Right Shift Operator(>>)](https://www.geeksforgeeks.org/bitwise-shift-operators-in-java/):** In C/C++ there is only one right shift operator ‘>>’ which should be used only for positive integers or unsigned integers. Use of the right shift operator for negative numbers is not recommended in C/C++, 
               and when used for negative numbers, the output is compiler dependent. Unlike C++, Java supports following two right shift operators.
               <br> <br>
         * Def :  Bitwise Right shift operator >> is used to shift the binary sequence to right side by specified position.     
               Here we will be discussing both of right shift operators as listed: <br>
              1. Signed right shift “>>” <br>
              2. Unsigned right shift “>>>” <br>
              * **for more :** <br>
                   * [gfg](https://www.geeksforgeeks.org/bitwise-shift-operators-in-java/) <br>
                   * [programiz](https://www.programiz.com/java-programming/bitwise-operators) <br>
                   * [log2base2](https://www.log2base2.com/C/bitwise/bitwise-right-shift-operator-in-c.html)
         ````
         Application of Bitwise Right Shift Operator
         In the above diagram, you can notice that whenever we shift the number one position to right, the output value will be exactly number / 2.

         If I shift 14 by 1 position to the right, output will be 14 / 2 = 7. i.e 14/2 = 7
         If I shift 14 by 2 position to the right, output will be 14 / 4 = 3. i.e 14/4 =3.5 since it’s an integer, fractional part will not be considered.
      
         In general, if we shift a number by n times to right, the output will be number / (2^n) .
         ````
         * **Applications of RIGHT Shift Operator:** <br>
           * Division by Powers of Two:: Right shifting a number by n positions is equivalent to dividing it by 2^n and it is very fast. <br>
           * Efficient Calculations: Used in performance-critical applications for fast division operations. <br>
           * Bit Manipulation: Useful in extracting specific bits from data, common in data compression and cryptography.

# Important Observation:
* The mathematical relationship between uppercase and lowercase letters. In ASCII, the difference between the uppercase letters ('A' to 'Z') and their corresponding lowercase counterparts ('a' to 'z') is exactly 32. This means you can convert an uppercase letter to its lowercase equivalent by adding 32 to its ASCII value.
  * **Use case:** <br>
       * If we take any uppercase letter and add 32 to its ASCII value, we get the corresponding lowercase letter.
       * EX: The ASCII value for 'A' is 65, and for 'a' it is 97. The difference is 32. `'A'+32 = 97 ASCII ==> Char 'a'`
<br><br><br>
* All the binary Bitwise operators follow the Associative property. I.e. XOR is commutative and associative, meaning the order of operations does not matter. Ex: findUniqNumber using Bitwise operator.       