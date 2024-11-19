### Avoiding Integer Overflow in Binary Search resolve((start+end)/2)

When calculating the middle index in binary search, using `(start + end) / 2` can cause integer overflow for large values of `start` and `end`. To resolve this, we use a safer approach.

## Problematic Code:
```java
int middleIndex = (s + e) / 2; // might exceed the integer limit that's y we got a new way to do the same.
int middleIndex = s + (e - s) / 2; 
// Explanation:
// (s + e + s - s) / 2 => (2s + e - s) / 2 => 2s / 2 + (e - s) / 2
// => s + (e - s) / 2
// This avoids exceeding the integer range. Now this won't exceed integer range
```
This ensures that the calculation stays within the bounds of the integer range, preventing potential overflow errors.