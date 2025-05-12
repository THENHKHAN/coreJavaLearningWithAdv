package AdvTopic.mylinkedlist;

//Explained With Pic N Code:  https://docs.google.com/document/d/1dveOAWkyqF37fyNLMBCxOpZaegr94CLKKZwlzUWKDYw/edit?tab=t.0#heading=h.p4xdklizelis
// In knhkhan ID
class TestNode {
    public int data;
    public Node next;

//    @Override
//    public String toString() {
//        return "Node{" +
//                "data=" + data +
//                ", next=" + next +
//                '}';
//    }

    TestNode (int data){
        this.data = data;
        this.next = null;
    } // currently without adding in linkedlist list it will be our Head. Since default value of data of class variable is 0 and Class Node next varibale is null.
}

public class _1_Intro {
    public static void main(String[] args) {
        System.out.println("Hello LinkedList!!!!!!!!!!!!!");
        System.out.println("Callinggggggggggggggg Linkedlist Class Node.....");

        Node myLinkedlist = new Node(0);
        System.out.println("My linkedList Class Without adding anything in it==> " + myLinkedlist);//  AdvTopic.mylinkedlist.Node@119d7047
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
        while(current!=null){
            System.out.println("Processing Node_"+count);
            System.out.println("Data: " + current.data);
            System.out.println("Next Ptr: " + current.next); // prints address-like object or null
            current = current.next;
            count++;
        }






    }
}
