package kunalSeries.basics.concepts.LinkedList;

public class Main {

    public static void main(String[] args) {
        LL list = new LL();
        System.out.println("linkedlist SIZE Initially: " + list.getSize());


        System.out.println("\n****************** 1-  Node Adding at 1st position      *******************************\n");

        // TODO : insert at the first position
        list.insertNodeAtFirstPosition(10);
        System.out.println("linkedlist SIZE After adding one node: " + list.getSize());

        System.out.println("\n****************** 2-  Node Adding at Last position      *******************************\n");

        // TODO : insert at the last position
        list.insertNodeAtLastPosition(20);
        System.out.println("linkedlist SIZE After adding one more node: " + list.getSize());

        System.out.println("\n****************** 3- Traverse Or Display LinkedList If Head Given     *******************************\n");

        // TODO : insert at the last position
        list.display();

    }
}
/* OUTPUT
linkedlist SIZE Initially: 0

****************** 1-  Node Adding at 1st position      *******************************

Node Added Successfully at 1st position!!!
Added Node In Beginning: 10
linkedlist SIZE After adding one node: 1

****************** 2-  Node Adding at Last position      *******************************

Before adding :
headVal--> 10
tailVal--> 10
Node Added Successfully at Last position!!!
Added Node at the end: 20
linkedlist SIZE After adding one more node: 2

****************** 3- Traverse Or Display LinkedList If Head Given     *******************************

linkedlist SIZE : 2
10 -> 20 -> NULL

 */