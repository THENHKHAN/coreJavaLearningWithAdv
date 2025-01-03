# Important Observation:
* The mathematical relationship between uppercase and lowercase letters. In ASCII, the difference between the uppercase letters ('A' to 'Z') and their corresponding lowercase counterparts ('a' to 'z') is exactly 32. This means you can convert an uppercase letter to its lowercase equivalent by adding 32 to its ASCII value.
    * **Use case:** <br>
        * If we take any uppercase letter and add 32 to its ASCII value, we get the corresponding lowercase letter.
        * EX: The ASCII value for 'A' is 65, and for 'a' it is 97. The difference is 32. `'A'+32 = 97 ASCII ==> Char 'a'`
       