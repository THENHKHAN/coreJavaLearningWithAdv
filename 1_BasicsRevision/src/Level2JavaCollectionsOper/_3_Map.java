package Level2JavaCollectionsOper;
/*
In Java, elements of Map are stored in key/value pairs. Keys are unique values associated with individual Values.

A map cannot contain duplicate keys. And, each key is associated with a single value.
-> We can access and modify values using the keys associated with them.

Note: The Map interface maintains 3 different sets:

the set of keys
the set of values
the set of key/value associations (mapping).

Since Map is an interface, we cannot create objects from it.

In order to use the functionalities of the Map interface, we can use these classes:

HashMap
EnumMap
LinkedHashMap
WeakHashMap
TreeMap

In Java, we must import the java.util.Map package in order to use Map. Once we import the package, here's how we can create a map.

// Map implementation using HashMap
Map<Key, Value> numbers = new HashMap<>();
In the above code, we have created a Map named numbers. We have used the HashMap class to implement the Map interface.

Here,

Key - a unique identifier used to associate each element (value) in a map
Value - elements associated by keys in a map

 */

import java.util.HashMap;
import java.util.Map;

public class _3_Map {

    public static void main(String[] args) {
        System.out.println("\n\n ########## Started Map in Java using HashMap ########## \n");

        Map<String, Integer> numbers = new HashMap<>();

        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("Four", 4);

        System.out.println("My Map: " + numbers); // {One=1, Four=4, Two=2, Three=3}

        // let's  access the keys of above map
        System.out.println("Map KeysSet : " + numbers.keySet()); // [One, Four, Two, Three]
        // let's  access the values of above map
        System.out.println("Map Values : " + numbers.values());// [1, 4, 2, 3]

        // Access entries of the map
        System.out.println("Entries: " + numbers.entrySet()); // [One=1, Four=4, Two=2, Three=3]
//        System.out.println("Class => : " + numbers.entrySet().getClass()); // class java.util.HashMap$EntrySet


        // access value through Key
        System.out.println("Two : " + numbers.get("Two")); // Two : 2

        // Remove Elements from the map
        int value = numbers.remove("Two");
        System.out.println("Removed Value: " + value); // 2

        // changing element with key "Four"
        numbers.replace("Four", 444); // or numbers.put("Four", 444);
        System.out.println("My Map: " + numbers); // My Map: {One=1, Four=444, Three=3}


        // iterate through Key
        System.out.print("Keys::::::::: ");
        for(String key: numbers.keySet()){
            System.out.print(key);
            System.out.print(", ");
        } // One, Four, Three,

        // iterate through values
        System.out.println("\nValues:::::::: ");
        for (Integer val : numbers.values()){
            System.out.print(val);
            System.out.print(", ");
        } // 1, 444, 3,

        // iterate through key/value entries
        System.out.println("\nEntries::::::: ");

        for (Map.Entry<String, Integer> entry : numbers.entrySet() ) {
            System.out.print(entry);
            System.out.print(", ");
        } //  One=1, Four=444, Three=3,


    }

}
