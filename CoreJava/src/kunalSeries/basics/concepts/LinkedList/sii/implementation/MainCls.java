package kunalSeries.basics.concepts.LinkedList.sii.implementation;

import java.util.LinkedList;

public class MainCls {

    private static void insertNodeFirstAndLast() {

        SLL lst = new SLL();
        lst.insertFirst(10);
        lst.insertFirst(20);
        lst.insertFirst(30);
        // 30->20->10

        lst.insertLast(40);
        lst.insertLast(50);
        // 40->50

        lst.display(); // 30->20->10->40->50

    }

    public static void insertAtAnyPosition() {
        int data = 10;
        int pos = 3;
        SLL lst = new SLL();
//        lst.insertLast(1);
//        lst.insertLast(2);
//        lst.insertLast(3); // at this position
//        lst.insertLast(4);
        // added in this function so that it preserve until this function end.

        /**
         Given a singly linked list, a position pos, and data, the task is to insert that data into a linked list at the given position.
         Examples:
         Input: 3->5->8->10, data = 2, pos = 2
         Output: 3->2->5->8->10

         Input: 3->5->8->10, data = 11, pos = 5
         Output: 3->5->8->10->11
         **/
       lst.insertAt(pos, data);
       lst.display();






    }

    public static void main(String[] args) {
        System.out.println("Using my implemented linked list...............");
//        insertNodeFirstAndLast(); // will have two functions inside. I added both call in this function.

        // TODO: https://www.geeksforgeeks.org/insert-a-node-at-a-specific-position-in-a-linked-list/

        insertAtAnyPosition();
//        LinkedList<Integer> lst;
//        lst.add();



    }


}
/* insertAtAnyPosition();


Using my implemented linked list...............
Node added at beginning and my linkedlist: 1
Display LinkedList size: 1
1 -> NULL
Node added at end and my linkedlist:: 2
Display LinkedList size: 2
1 -> 2 -> NULL
Node added at end and my linkedlist:: 3
Display LinkedList size: 3
1 -> 2 -> 3 -> NULL
Node added at end and my linkedlist:: 4
Display LinkedList size: 4
1 -> 2 -> 3 -> 4 -> NULL
Existing Linked List: Display LinkedList size: 4
1 -> 2 -> 3 -> 4 -> NULL
Display LinkedList size: 5
1 -> 2 -> 10 -> 3 -> 4 -> NULL


 */