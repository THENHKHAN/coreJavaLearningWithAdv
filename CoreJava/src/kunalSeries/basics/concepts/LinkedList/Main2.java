package kunalSeries.basics.concepts.LinkedList;

public class Main2 {

    public static void main(String[] args) {
        LL list = new LL();
        System.out.println("linkedlist SIZE Initially: " + list.getSize());


        System.out.println("\n****************** 1-  Node Adding at 1st position      *******************************\n");

        // TODO : insert at the first position
        list.insertNodeAtFirstPosition(10);
        list.insertNodeAtFirstPosition(50);
        list.insertNodeAtFirstPosition(14); // 14->50->10
        System.out.println("linkedlist SIZE After adding 3 node : " + list.getSize());

        System.out.println("\n****************** 2-  Node Adding at Last position      *******************************\n");

        // TODO : insert at the last position
        list.insertNodeAtLastPosition(20);
        list.insertNodeAtLastPosition(100);
        list.insertNodeAtLastPosition(40); // 20->100->40
        System.out.println("linkedlist SIZE After adding 3+ 3 more node: " + list.getSize());

        System.out.println("\n****************** 3- Traverse Or Display LinkedList If Head Given     *******************************\n");

        // TODO : insert at the last position
        list.display();

    }
}
/* OUTPUTTTTTTTTTTTTTTTTTTTTTTTTTT:::::::::::::::::

linkedlist SIZE Initially: 0

****************** 1-  Node Adding at 1st position      *******************************

Node Added Successfully at 1st position!!!
Added Node In Beginning: 10
linkedlist SIZE : 1
10 -> NULL
Node Added Successfully at 1st position!!!
Added Node In Beginning: 50
linkedlist SIZE : 2
50 -> 10 -> NULL
Node Added Successfully at 1st position!!!
Added Node In Beginning: 14
linkedlist SIZE : 3
14 -> 50 -> 10 -> NULL
linkedlist SIZE After adding 3 node : 3

****************** 2-  Node Adding at Last position      *******************************

Node Added Successfully at Last position!!!
Added Node at the end: 20
linkedlist SIZE : 4
14 -> 50 -> 10 -> 20 -> NULL
Node Added Successfully at Last position!!!
Added Node at the end: 100
linkedlist SIZE : 5
14 -> 50 -> 10 -> 20 -> 100 -> NULL
Node Added Successfully at Last position!!!
Added Node at the end: 40
linkedlist SIZE : 6
14 -> 50 -> 10 -> 20 -> 100 -> 40 -> NULL
linkedlist SIZE After adding 3+ 3 more node: 6

****************** 3- Traverse Or Display LinkedList If Head Given     *******************************

linkedlist SIZE : 6
14 -> 50 -> 10 -> 20 -> 100 -> 40 -> NULL


 */