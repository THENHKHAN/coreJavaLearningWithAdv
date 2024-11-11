package Level2JavaCollectionsOper;

import java.util.LinkedList;

class Node {
    int data;
    Node next ;

    // Constructor to initialize a new node with data
    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

public class _4_linkedList {
    Node head;
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addFirst("a");
        ll.addFirst("is");
        ll.addFirst("This");
        System.out.println(ll); // [This, is, a]

        ll.addLast("List");
        System.out.println(ll); // [This, is, a, List]

        ll.add("LinkedList"); // add() by default add in last position Or same as addLast
        System.out.println(ll); // [This, is, a, List, LinkedList]

        System.out.println("linkedList Size: " + ll.size());

        System.out.println("---- Using foreach Loop ---- ");

        for (String data : ll){
            System.out.print(data);
            System.out.print("-> ");
        }
        System.out.println("null");
        // This-> is-> a-> List-> LinkedList-> null

        System.out.println("---- Using for Loop ---- ");
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + "-> ");
        }
        System.out.println("null");
//        This-> is-> a-> List-> LinkedList-> null

        System.out.println("---- Removing element ---- ");

        // remove last element
        ll.removeLast();
        System.out.println("After removing last element : " + ll); // [This, is, a, List]

        // remove first element
        ll.removeFirst();
        System.out.println("After removing first element : " + ll); // [is, a, List]

        // remove at any index element
        ll.remove(1);
        System.out.println("After removing 1st index element of above list : " + ll); // [is, List]


        /*
        Input: Linked List = 1 -> 2 -> 3 -> 4 -> NULL
        Output: Reversed Linked List = 4 -> 3 -> 2 -> 1 -> NULL
         */

        // let's make a new list of numbers
        LinkedList<Integer> myNumll = new LinkedList<>();
        myNumll.addFirst(1);
        myNumll.addLast(2);
        myNumll.addLast(3);
        myNumll.addLast(4);
        myNumll.addLast(5);
        System.out.println("Original LL : " + myNumll );
        System.out.print("head->");
        for (Integer num : myNumll){
            System.out.print(num);
            System.out.print("-> ");
        }
        System.out.println("null");
        reverseLinkedlistInConstantSpaceInIterativeApproach();

    }

    public static void reverseLinkedlistInConstantSpaceInIterativeApproach() {

        Node head = new Node(1);
        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode ;

            // update
            currNode = nextNode;

        }

        System.out.println("----- started reversing linkedlist using Iterative Approach ----- ");

    }
}
