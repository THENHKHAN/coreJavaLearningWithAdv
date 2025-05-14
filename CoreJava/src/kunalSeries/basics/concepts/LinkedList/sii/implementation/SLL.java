package kunalSeries.basics.concepts.LinkedList.sii.implementation;

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
        System.out.println("Node added at end and my linkedlist:: " + data);
        display();
    }

    // Display the linked list
    public void display() {
        System.out.println("LinkedList size: " + size);

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





    }




}
