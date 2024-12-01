## <div style="text-align: center;"> Interview Or Depth Concepts link and 1-2 line </div>

### <div style="text-align: left;"> Reference variable & Object: [read more](https://www.youtube.com/watch?v=wn49bJOYAZM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=5) </div>
ts:27:000  
Reference stored in Stack and _Object stored in Heap_. Let see an example:
`Int a= 10 ` => Here `a` is a reference and `10` is the object
Objects are known by their reference and if the referencing variable pointing (i.e. referencing) to any other object then the earlier object will be removed by the Garbage collector.
* Reference Link: <br>
   * [kunal](https://www.youtube.com/watch?v=wn49bJOYAZM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=5):YT <br>
   * [Pointers in Java](https://www.youtube.com/watch?v=X0b2kp-WSMM) : Pointers in Java, Data, and References

### <div style="text-align: left;"> Strings and StringBuilder: [Learn more](https://www.youtube.com/watch?v=zL1DPZ0Ovlo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=21) </div>
* ### String :
  * **String Pool** : _ts:00:01:30_ <br>
      It's a separate portion(memory) or place inside the Heap. Why Separate?
      So that it does not recreate in the pool.
  * **String Immutability**: ts: 00:09:00 <br> 
      For security reason String are immutable. Ex: just remember name changing example, if one person change then that will affect other ref variable as well na.
  * **String Comparison(==)**: ts: 00:16:05 <br> 
      It `compares the references of variables `and not with value of variable (in this case we can use equals() function). It returns true of both reference variable pointing to the same object otherwise false. `Ex:` a="noor" , b="noor" => will give true since object is same for both reference variable.
  * **New keyword:**  If You want to create two same object(2 or more) that are getting point by two different reference variable then you can use `new` keyword I mean constructor based string object creation. It creates object `outside the pool` but still inside the Heap.
  * **String Performance**: Why we should use StringBuilder when comes to mutability?? Whenever we add something with existing string it will `always create a new string object` and copy the existing and new object into a new string [kunal](https://www.youtube.com/watch?v=zL1DPZ0Ovlo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=21)

* ### StringBuilder : [ts: 01:00:00](https://www.youtube.com/watch?v=zL1DPZ0Ovlo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=21)
  *  **What ??** It allows you to modify the content of the string without creating a new object. This improves performance for repeated modifications.
  * **When to Use** : We can use this when we need any modification in the string. We convert it the string obj to this and after doing our work we can return string using .toString().
  * Faster : modifies the content in-place, making it much faster for operations like concatenation in loops. Mostly use .append(), setChar. 