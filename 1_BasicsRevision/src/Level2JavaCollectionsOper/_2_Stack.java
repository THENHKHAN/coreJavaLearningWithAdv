package Level2JavaCollectionsOper;

import java.util.Stack;

/*
In stack, elements are stored and accessed in Last In First Out manner. That is, elements are added to the top of the stack and removed from the top of the stack.
 */

public class _2_Stack {
    public static void main(String[] args) {
        System.out.println("\n\n ########## Started Stack in Java ########## \n");

        // Used property - FIFO - First In Last Out  - OR LIFO : Last In First Out

        Stack<String> animals = new Stack<>();
        animals.push("Lion");
        animals.push("Tiger");
        animals.push("Cat");

        System.out.println("My Animals Stacks : " + animals); // [Lion, Tiger, Cat]
        // to see which element you see in the stack USE peek ()method -peek ==== glance it will tell you which element is at the top of stack
        System.out.println("Top Element of stack : " + animals.peek()); // Cat
//        The peek() method returns an object from the top of the stack.
        // remove the last/top element from the stack
        animals.pop(); // Remove element stacks and return the removed element
        System.out.println("My Animals Stacks after removing top element: " + animals); // [Lion, Tiger]
        System.out.println("Top Element of stack : " + animals.peek()); // Tiger


        // search() Method : To search an element in the stack, we use the search() method. It returns the position of the element from the top of the stack.
        animals.push("Horse");
        int searchElemPosition = animals.search("Tiger"); // it gives position and not index - position = index+1
        System.out.println("stack : " + animals);//  [Lion, Tiger, Horse]
        System.out.println("Position of Tiger: " + searchElemPosition); // Position of Tiger: 2

//        isEmpty() Method : To check whether a stack is empty or not, we use the isEmpty() method.
        if(animals.isEmpty()){ // return true if empty  and false if not empty
            System.out.println("Yes , Animal stack is empty !");
        }else {
            System.out.println("No , Animal stack is Not empty !");
        }

    }
}
