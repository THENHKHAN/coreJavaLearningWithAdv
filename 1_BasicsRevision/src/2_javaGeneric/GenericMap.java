package javaGeneric;
// The Mappings in a HashMap are from Key → Value
/*
What is Generic Map and how is it different from the term HashMap?

The term generic simply is the idea of allowing the type (Integer, Double, String, etc. or any user-defined type) to be the parameter to methods, class, or interface.
For eg, all the inbuilt collections in java like ArrayList, HashSet, HashMap, etc. use generics.

Generic Map in simple language can be generalized as:

Map< K, V > map = new HashMap< K, V >();
Where K and V are used to specify the generic type parameter passed in the declaration of a HashMap.
We can add any type be it Integer, String, Float, Character, or any user-defined type in place of K and V in the above syntax
 to specify that we can initialize the HashMap of our wish.
 */


import java.util.HashMap;
import java.util.Map;

public class GenericMap {


    // TODO : to count the frequency of a string and store it in the map
   public static  Map<String, Integer> countFreqOfString(String []arr ){

       Map<String, Integer> map = new HashMap<>();

       for ( int ind = 0 ; ind < arr.length  ;  ind++){
           if (map.containsKey(arr[ind])){
              int count = map.get(arr[ind]);
              map.put(arr[ind], count+1);

           } else {
               map.put(arr[ind], 1);
           }
       }

       return map;
    }


    public static void main(String[] args) {

       String []arrOfStr =  {"gfg",  "code",    "quiz",   "program",
                                "code", "website", "quiz",   "gfg",
                                "java", "gfg",     "program" };

        System.out.println("Map with String and there occurence : " + countFreqOfString(arrOfStr));
        // Map with String and there occurence : {quiz=2, website=1, code=2, java=1, gfg=3, program=2}
        System.exit(1);

        Map <String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b",2);
        map.put("c", 3);
        System.out.println("MAP : " + map); // MAP : {a=1, b=2, c=3}

        System.out.println("Map keySet : " + map.keySet()); // [a, b, c]
        System.out.println("Map keySet TYPE: " + map.keySet().getClass().getName()); // java.util.HashMap$KeySet
        System.out.println("Map values : " + map.values()); // [1, 2, 3]
        System.out.println("Map Values TYPE : " + map.values().getClass().getName()); // java.util.HashMap$Values


        System.out.println("value of map key (a):" + map.get("a") ); // 1
        System.out.println("value of map key (b):" + map.get("b") ); // 2
        System.out.println("value of map key (c):" + map.get("c") );// 3

        // using loop
        System.out.println("----- Using for-each LOOP ------ ");
        for (String key  : map.keySet()){
            System.out.println("value of map key "+ key + "-> " + map.get(key) );
        }
    }
}
