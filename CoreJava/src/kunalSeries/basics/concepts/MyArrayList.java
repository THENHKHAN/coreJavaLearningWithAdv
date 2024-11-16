package kunalSeries.basics.concepts;

import java.util.ArrayList;
import java.util.Arrays;

// TODO: REf: https://www.javatpoint.com/java-arraylist OR  https://www.geeksforgeeks.org/arraylist-in-java/
public class MyArrayList { // ALSO called dynamic array
    public static void main(String[] args) {

        // lets create an arraylist of arraylist
        ArrayList< ArrayList<Integer> > arrLst2D = new ArrayList<>();
        System.out.println("arrLst2D: " + arrLst2D ); // []
//        System.out.println("arrLst2D size: " + arrLst2D.size() ); // 0
        // initially the size is zero since there is no element

        // let's we want to create any arrayList of 3 element
        for (int i = 0; i < 3; i++) {
            arrLst2D.add(new ArrayList<>());
        } // if we would skip this part and try to ad something in arrLst2D it will throuw arrayIndexOutOfBound since there will be no element so no index can see. But after doing this we have index 0,1,2
        System.out.println("arrLst2D after adding 3 empty Arrlist Obj: " + arrLst2D ); // [[], [], []]
        System.out.println("arrLst2D after adding 3 empty Arrlist Obj SIZE: " + arrLst2D.size() ); // 3

        // now can add element :

        for (int i = 0; i < arrLst2D.size(); i++) {
            int temp = 10 + i;
            for (int j = 0; j <4 ; j++) { // we want to add 4 element
                arrLst2D.get(i).add(temp+j);
            }
        }
        System.out.println("After adding element in the list of list : " + arrLst2D);// [[10, 11, 12, 13], [11, 12, 13, 14], [12, 13, 14, 15]]


    }
}
