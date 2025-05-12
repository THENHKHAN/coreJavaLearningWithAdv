package AdvTopic.mylinkedlist;

//Explained With Pic N Code:  https://docs.google.com/document/d/1dveOAWkyqF37fyNLMBCxOpZaegr94CLKKZwlzUWKDYw/edit?tab=t.0#heading=h.p4xdklizelis

class Node {
    public int data;
    public Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    } // currently without adding in linkedlist list it will be our Head. Since default value of data of class variable is 0 and Class Node next varibale is null.
}

public class  _2_4NodeLinkledList {
    public static void main(String[] args) {
        System.out.println("Hello LinkedList!!!!!!!!!!!!!");
//        System.out.println("Callinggggggggggggggg Linkedlist Class Node.....");
//
//        Node myLinkedlist = new Node(0);
//        System.out.println("My linkedList Class Without adding anything in it==> " + myLinkedlist);//  AdvTopic.mylinkedlist.Node@119d7047
//        System.out.println("myLinkedlist data : " + myLinkedlist.data);
//        System.out.println("myLinkedlist next : " + myLinkedlist.next);
        /*
        myLinkedlist data : 0
        myLinkedlist next : null
         */

        // Above myLinkedlist node is just for text.

        /** The above will work as a Head since initially it has Null in its next Ptr **/
        // creating Head Node
                    // need to create Constructor as since need to add and manipulate data.


        // Node Linked List (10 → 20 → 30 → 40) will create like this
        // 1st will create 4 node then will link
        Node node1 = new Node(10); // this will make Head and have 10 as value
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        // Later will create setter/setter to add and get and perform other operations.


        System.out.println("Head or Node1 : " + node1); //Node1 : Node{data=10, next=null}  - Since used toString

        // now will link with next Ptr :  Linking nodes

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // lets print whether node created or not
        Node head = node1; // node1 is the head
        Node current = head; // using to traverse and head remain safe.
        // this current is going be a Ptr as well like head
        int count = 1;
        System.out.println("Node_1 Address : " + node1);
        System.out.println("Node_2 Address : " + node2);
        System.out.println("Node_3 Address : " + node3);
        System.out.println("Node_4 Address : " + node4);

        while(current!=null){
            System.out.println("Processing Node_"+count);

            System.out.println("Data: " + current.data);
            System.out.println("Next Ptr: " + current.next); // prints address-like object or null
            current = current.next;
            count++;
        }

        // Here you can visualize that it linked all the nodes. Just see the addresses.
/* OUTPUT:

Hello LinkedList!!!!!!!!!!!!!
Head or Node1 : AdvTopic.mylinkedlist.Node@119d7047
Node_1 Address : AdvTopic.mylinkedlist.Node@119d7047
Node_2 Address : AdvTopic.mylinkedlist.Node@776ec8df
Node_3 Address : AdvTopic.mylinkedlist.Node@4eec7777
Node_4 Address : AdvTopic.mylinkedlist.Node@3b07d329
Processing Node_1
Data: 10
Next Ptr: AdvTopic.mylinkedlist.Node@776ec8df
Processing Node_2
Data: 20
Next Ptr: AdvTopic.mylinkedlist.Node@4eec7777
Processing Node_3
Data: 30
Next Ptr: AdvTopic.mylinkedlist.Node@3b07d329
Processing Node_4
Data: 40
Next Ptr: null

 */




    }
}
