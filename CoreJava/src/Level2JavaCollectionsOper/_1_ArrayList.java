package Level2JavaCollectionsOper;

import java.util.*;

public class _1_ArrayList {
    public static void main(String[] args) {
        System.out.println("\n\n ########## Started ArrayList in Java ########## \n");


        ArrayList<Integer> arrList = new ArrayList<>();
                            arrList.add(20);// This will add 20 at the end of the List.
                            arrList.add(30);
                            arrList.add(40); // This will add 400 at the end of the List.

        System.out.println("Here is the List : " + arrList); // [20, 30, 40]
        System.out.println("Size  : " + arrList.size()); // 3

        List<String> lst = new ArrayList<>(); // just for understanding that List is an interface that is implemented by ArrayList
        lst.add("Noorul");
        lst.add("Huda");
        lst.add("Khan");
        System.out.println("Here is the New List : " + lst); // [Noorul, Huda, Khan]
        System.out.println("Size  : " + lst.size()); // 3

        for (int i = 0; i < lst.size(); i++) {
            System.out.println("Printing List using for loop : " + lst.get(i));
        }

        for(String ele : lst){
            System.out.println("Printing List using foreach Loop : " + ele);
        }


        Iterator<String> it = lst.iterator() ;
        while (it.hasNext()){
            System.out.println("It -> " + it.next());
        }

        // // This will add Guddu at index 1. All the other elements will be shifted to right.
        lst.add(1, "Guddu");
        System.out.println("after Added Guddu in the above list at 1st index or 2nd position : " + lst);


        ArrayList<Integer> newArrList = new ArrayList<Integer>(); // Creating a new List which will be added to original list (arrList).
        newArrList.add(400);
        newArrList.add(500);
        System.out.println("new List : " + newArrList ); // [400, 500]

        // we can add the whole new list into another List Or in other adding multiple object at once we can use addAll()
        arrList.addAll(newArrList);
        System.out.println("arrList Updated : " + arrList); // [20, 30, 40, 400, 500]

        //  This will remove the element at index 1 i.e. 30. : By Index
        arrList.remove(1);
        System.out.println("arrList Updated after removing element of 2nd : " + arrList);

        //  This will remove the element 400 in arrList : By Value/Object
        arrList.remove(Integer.valueOf(400));// we have made object of Integer from integer primitive
        System.out.println("arrList Updated after removing 400 element of above arrList : " + arrList); // [20, 40, 500]

        //This will remove all the elements from the list but not the List itself
        arrList.clear();
        System.out.println("clearing complete arrList or removing all the element from list at once: " + arrList); // []

    }

}
