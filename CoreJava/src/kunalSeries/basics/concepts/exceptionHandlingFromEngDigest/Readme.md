## <div style="text-align: center;"> Exception Handling in Depth </div>
* **Reference YT:** [YT-EngDigest](https://www.youtube.com/watch?v=fzip9Aml6og&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=73)
* **Articles:** 
    * GFG: [Link](https://www.geeksforgeeks.org/exceptions-in-java/)
    * W3School: [Link](https://www.w3schools.com/java/java_try_catch.asp)
    * JavaTPoint: [Link](https://www.javatpoint.com/exception-handling-in-java)
    * DigiOcean: [Link](https://www.digitalocean.com/community/tutorials/exception-handling-in-java)
    * Programiz: [Link](https://www.programiz.com/java-programming/exception-handling)
    * Baeldung: [Link](https://www.baeldung.com/java-exceptions)
      <br><br>
* The _Exception Handling in Java_ is one of the powerful mechanism to handle the runtime errors so that the normal flow of the application can be maintained. **OR** Exception Handling is a `mechanism to handle runtime errors` such as ClassNotFoundException, IOException, SQLException, RemoteException, etc.
* **Exception in Java:** 
     * In Java, an **exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions**. These exceptions can occur for various reasons, such as invalid user input, file not found, or division by zero. When an exception occurs, it is typically represented by an object of a subclass of the java.lang.Exception class.
     * An Exception is an unwanted or unexpected event that occurs during the execution of a program (i.e., at runtime) and disrupts the normal flow of the program’s instructions. It occurs when something unexpected things happen, like accessing an invalid index, dividing by zero, or trying to open a file that does not exist.
* **Checked exceptions**: Checked exceptions are exceptions that the **Java compiler requires us to handle (Means checked at the compile-time).** We have to either declaratively throw the exception up the call stack, or we have to handle it ourselves. More on both of these in a moment. 
    * IOException: An exception is thrown when an input/output operation fails, such as when reading from or writing to a file.
    * SQLException: It is thrown when an error occurs while accessing a database.
    * ParseException:  Indicates a problem while parsing a string into another data type, such as parsing a date.
    * ClassNotFoundException: It is thrown when an application tries to load a class through its string name using methods like Class.forName(), but the class with the specified name cannot be found in the classpath.
  <br> <br>
* **Unchecked exceptions / Runtime exceptions:** Unchecked exceptions, also known as runtime exceptions, are not checked at compile-time. These exceptions usually occur due to programming errors, such as logic errors or incorrect assumptions in the code. They do not need to be declared in the method signature using the throws keyword, making it optional to handle them. Examples of unchecked exceptions include:
    * NullPointerException: It is thrown when trying to access or call a method on an object reference that is null.
    * ArithmeticException:  It is thrown when an arithmetic operation fails, such as division by zero.
    * ArrayIndexOutOfBoundsException: It occurs when we try to access an array element with an invalid index.
  <br><br>
* **try and catch:**
  * The `try` statement allows you to define a block of code to be tested for errors while it is being executed.
  * The `catch` statement allows you to define a block of code to be executed, if an error occurs in the try block.

* **throw and throws in Java:** [ref-GFG](https://www.geeksforgeeks.org/throw-throws-java/?ref=lbp)
     * The Java `throw` keyword is used to explicitly `throw a single exception`.
     * When we throw an exception, the flow of the program moves from the try block to the catch block.
``` 
throw new exception_class("error message");
ex- throw new IOException("sorry device error");   
```
