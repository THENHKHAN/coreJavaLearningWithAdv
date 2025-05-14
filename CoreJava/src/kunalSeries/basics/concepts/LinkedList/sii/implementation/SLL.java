package kunalSeries.basics.concepts.LinkedList.sii.implementation;

// Kunal : https://www.youtube.com/watch?v=58YbpRDc4yw
// LinkedList implementation with internal Node class
public class SLL {

    private Node head;
    private Node tail;
    private int size;

    public SLL() {
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    // Node class
    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Insert at the beginning - can ask why You are using tail : read Readme.md
    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;   // New node points to old head
        head = node;        // Head now points to new node

        if (tail == null) {
            // If list was empty, tail also points to the new node
            tail = head;
        }

        size++;
        System.out.println("Node added at beginning and my linkedlist: " + data);
        display();
    }

    // Optional-
    // O(n) - Insert at end (no tail)
    public void insertAtEnd(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        size++;
    }

    // Insert at the end
    public void insertLast(int data) {
        if (head == null) {
            // If list is empty, reuse insert at beginning
            insertFirst(data);
            return;
        }

        Node node = new Node(data);
        tail.next = node;   // Link old tail to new node
        tail = node;        // Update tail to new node

        size++;
        System.out.println("Node added at end and my linkedlist: " + data);
        display();
    }

    // Display the linked list
    public void display() {
        System.out.println("Display LinkedList size: " + size);

        if (head == null) {
            System.out.println("LinkedList is empty.");
            return;
        }

        Node tempHeadForTraversal = head;
        while (tempHeadForTraversal != null) {
            System.out.print(tempHeadForTraversal.data + " -> ");
            tempHeadForTraversal = tempHeadForTraversal.next;
        }
        System.out.println("NULL");
    }


    public void insertAt(int pos, int data) { // index = position-1 --- index:0,1,2,3. and pos = 1,2,3,4
        System.out.print("Existing Linked List: ");
        display();
        System.out.println("Inserting Data In the existing Liknked list at Position : " + pos);
        /*
        Existing Linked List: LinkedList size: 4
        1 -> 2 -> 3 -> 4 -> NULL    ===> after adding at the positon 3 it should look:
                                            1 -> 2 -> 10 -> 3 -> 4 -> NULL
         */
        int index = pos-1;
        int nodeLength = getSize();
        if (index<0 || index>nodeLength){
            System.out.println("Index Out Of Bounds Exception");
            return;
        }
//        if(lst.getTail() == null && index==0){ // empty linked list - head = tail so we use either of them.
        // above can be confusing for others
        if(nodeLength==0 && index == 0){
            System.out.println("Linked List is empty so this will be the 1st Node.");
            insertFirst(data);
            return;
        }

//        inserting at the head (index == 0). For loop will fail.
        if(index==0){
            insertFirst(data);
            return;
        }

        if(index==nodeLength){
            insertLast(data);
        }


        // so basically we need to take a temp head that can get current Node index where we need to add this newly required Node.

        Node tempHead = head;
        // Traverse to the node that will be present just before the new node.
        for (int i = 0; i < index-1; i++) { // need to add at index 3
            tempHead = tempHead.next; // i=0 - give 1st node addr, i=1 - give 2nd node addr.
                                    // after i=2 loop break and tempHead pointing to current 3rd node.
        }
        Node newNode =  new Node(data); // could be like this too. new Node(data, tempHead.next); // and we can skip newNode.next = tempHead.next;
        newNode.next = tempHead.next;
        tempHead.next = newNode; // now pointing to the new Node
        size++;
    }




}
