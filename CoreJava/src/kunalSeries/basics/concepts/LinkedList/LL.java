package kunalSeries.basics.concepts.LinkedList;

// Making Node inside LL so that we can get through only LL class
public class LL {

      private Node head;
      private Node tail;

      private int size;

      public Node getHead() {
            return head;
        }

      public Node getTail() {
            return tail;
        }

      public LL(){
              this.size = 0;
          }

      public int getSize(){
              return size;
          }

    // Creating Node
      private class Node {
           private int data ;
           private Node next ;

            Node (int data){
                this.data = data;
                this.next = null;
            }
        }
        public void insertNodeAtFirstPosition(int data){
          // 1st will create Node then we thought about how to perform required action.
            Node node = new Node(data);
            node.next = head ; //  head is null  then node' next Ptr will be nll OR
                                //if non-empty linkedList: current node next Ptr has now, the initial head value.
                                // current next Ptr is linked with initial head's node

            // Move head to the new node
            head = node; // now head should contain the current node. means now head is pointing to the current added node.


            // if no node is created OR linkedlist is Empty then head and tail should equal.
           //TODO: IMP - tail points to the last node and not point to null. Last Node's Ptr contains null so don't confuse.
            if(tail == null){
                tail = head ; // pointing to last node. here in this case 1st node is the last node that's  y head and tail should be same.
            }
            // and if tail not contains null means linkedlist is non-empty. so if condition not executed and we dont need to touch tail becasue we dont need to push forward unlike Array insertion at the beginning.
            size += 1;

            System.out.println("Node Added Successfully at 1st position!!! ");
            System.out.println("Added Node In Beginning: " + data);
            display();
        }

        public void insertNodeAtLastPosition(int data){
//            Node node = new Node(data);
//            tail = node; // now is pointing to this current last added node.
//            tail.next = null; // handled tail now new tail will be this.
//            // if empty
//            if(head == null){
//                head = tail;
//            }
//            size += 1;
//            System.out.println("Node Added Successfully at Last position!!! ");
//            System.out.println("Added Node at the end: " + data);
            /**
            ❌ What's wrong:
                You're not linking the previous tail node's next to the new node before assigning tail = node. That breaks
                                the chain of your linked list.

                This causes the new node to become the tail, but it's not attached to the rest of the list when the
                                    list is non-empty.
             **/
//            System.out.println("Before adding : ");
//            System.out.println("headVal--> " + head.data );
//            System.out.println("tailVal--> " + tail.data );
            /*
            Before adding :
                    headVal--> 10
                    tailVal--> 10
             */
            Node node = new Node(data);
                        // if empty head n tail will equal
            if(head == null){
                insertNodeAtFirstPosition(data);
                return;
            }
            tail.next = node;  // now tail's next pointer is pointing to this current (last) added node.
//            node.next = null;  // ← Optional line
            tail = node;
            /*
            Key Concepts:
                    tail should always point to the last node in the list.
                    Every node's next should point to the next node, or be null if it's the last one.
             */
            /**
             * ❌ Comment out tail = node; and only use node.next = null;:
             * You're manually setting the new node's next to null (which is good), but you're not updating the tail pointer. So, tail still points to the previous last node — this breaks the integrity of the tail pointer,
               though you may not immediately see a problem unless you:
             -> Add another node after that.
             -> Try to access or display tail.
             **/
            size += 1;
            System.out.println("Node Added Successfully at Last position!!! ");
            System.out.println("Added Node at the end: " + data);
            display();
        }

        public void display(){
          System.out.println("linkedlist SIZE : " + getSize());
          // edge case if LL empty
          if(head == null){
              System.out.println("linkedlist is Empty!! ");
          }
          Node currentHead = head;
          while (currentHead != null){
              System.out.print(currentHead.data+" -> ");
              currentHead = currentHead.next; // moving current Pointer to next node
          }
            System.out.println("NULL");
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