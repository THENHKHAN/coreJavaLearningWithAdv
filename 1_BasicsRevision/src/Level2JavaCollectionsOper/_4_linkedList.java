package Level2JavaCollectionsOper;

import java.util.LinkedList;

public class _4_linkedList {

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
        System.out.println("After removing last element : " + ll); // [is, a, List]

        // remove at any index element
        ll.remove(1);
        System.out.println("After removing 1st index element of above list : " + ll); // [is, List]
    }
}
