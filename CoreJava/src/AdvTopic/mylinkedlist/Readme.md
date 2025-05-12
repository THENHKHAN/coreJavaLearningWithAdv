# 🧩 Linked List in Java (DSA Basics)

This repository contains simple examples of **singly linked lists** implemented in Java. It's designed for beginners learning how linked lists work at the memory and code level.

---

## 📚 What is a Linked List?

A **linked list** is a linear data structure where elements (nodes) are stored in **non-contiguous** memory locations.  
Each node contains:
- A `data` field (to store the value)
- A `next` pointer (reference to the next node)

Unlike arrays, linked lists **do not store elements in adjacent memory**, making them dynamic and flexible.

---

## 🔗 Node Structure

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

## 🌱 Example: Single Node Linked List

```java
public class SingleNodeList {
    public static void main(String[] args) {
        Node head = new Node(99);  // Only one node

        System.out.println("Data: " + head.data);
        System.out.println("Next: " + head.next); // should print null
    }
}
```

### ✅ Output:
```
Data: 99
Next: null
```

### 📌 Visual Representation:

```
[0xABC] +-------+-----------+
        |  99   | NULL      |
        +-------+-----------+
             0xABC
```

---

## 🌳 Example: 4-Node Linked List

```java
public class FourNodeList {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        // Linking nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Traverse and print
        Node current = node1;
        while (current != null) {
            System.out.println("Data: " + current.data);
            System.out.println("Next: " + current.next);
            current = current.next;
        }
    }
}
```

### ✅ Output (example memory references):
```
Data: 10
Next: Node@3e3abc88
Data: 20
Next: Node@6ce253f1
Data: 30
Next: Node@7c30a502
Data: 40
Next: null
```

### 📌 Memory Visualization (Non-Contiguous):

```
[0x100] +-------+-----------+
        |  10   | 0x250 .....
        +-------+-----------+
             0x100
                  |
                  v
[0x250] +-------+-----------+
        |  20   | 0x180 .....
        +-------+-----------+
             0x250
                  |
                  v
[0x180] +-------+-----------+
        |  30   | 0x3F0 .....
        +-------+-----------+
             0x180
                  |
                  v
[0x3F0] +-------+-----------+
        |  40   | NULL      |
        +-------+-----------+
             0x3F0
```

> 🧠 Dotted lines (`.....`) represent the `next` pointer connecting to a node **somewhere else in memory** — not necessarily adjacent.

---

## 🛠 How to Run

1. Save your files:
    - `Node.java`
    - `SingleNodeList.java`
    - `FourNodeList.java`

2. Compile and run:
   ```bash
   javac Node.java SingleNodeList.java FourNodeList.java
   java SingleNodeList
   java FourNodeList
   ```

---
 