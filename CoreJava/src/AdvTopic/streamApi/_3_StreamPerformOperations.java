package AdvTopic.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// https://www.youtube.com/watch?v=DYyhFLC2eJ0      -- 30Min explained very well
public class _3_StreamPerformOperations {
    public static void main(String[] args) {
// it worked on Collections : List , LinkedList, ArrayList etc.
        // it is used to perform operation on the provide collection

              // operation : filter
         List<String> lst = Arrays.asList("apple", "banana", "cherry", "mango", "aabbcc", "appaaattee");
         // TODO: filtering string which starts with prefix 'a'
         List<String> strStartsWith_a_letter = lst.stream().filter( str -> str.startsWith("a")).toList();
         System.out.println("string StartsWith letter 'a' : " + strStartsWith_a_letter);// [apple, aabbcc, appaaattee]

        // operation : filter and then map in the chaining form
         List<Integer> listOfInteger =  Arrays.asList(0, 2, 3, 5, 6, 10, 33, 60, 100, 222 );
         // TODO: square of all the odd number using stream API
         List<Integer> oddNumberSquareList = listOfInteger.stream().filter(num->num%2 != 0).map(oddNum-> oddNum*oddNum).toList();
         System.out.println("All Odd number square List using filter and map function : " + oddNumberSquareList);// [9, 25, 1089]


        // operation : filter , distinct, skip
        List<Integer> lstOfRepeatedNum = Arrays.asList(1, 3, 1, 44, 5, 3, 55, 100, 100, 2, 7, 10);
        // TODO: filter - filter to get each element only once OR get distinct element from the above list
        System.out.println("Distinct element from list : " + lstOfRepeatedNum +" ==> " + lstOfRepeatedNum.stream().distinct().toList());// [1, 3, 44, 5, 55, 100, 2, 7, 10]
        System.out.println("Distinct element from list : " + lstOfRepeatedNum +" and Skipped 1st 2 elem ==> " + lstOfRepeatedNum.stream().distinct().skip(2).toList());// [44, 5, 55, 100, 2, 7, 10]

        // sorted in ASC order - by default
        System.out.println("Distinct element from list In sorted(ASC) Order : " + lstOfRepeatedNum +" ==> " +
                lstOfRepeatedNum.stream().distinct()
                        .sorted()
                        .toList());// [1, 2, 3, 5, 7, 10, 44, 55, 100]

        // sorted in DSC order -
        System.out.println("Distinct element from list In sorted(DSC) Order : " + lstOfRepeatedNum +" ==> " +
                lstOfRepeatedNum.stream().distinct()
                        .sorted( (a, b) -> b - a ) // by default (a, b) -> a - b  means sorted in ASC
                        .toList()
                    );// [100, 55, 44, 10, 7, 5, 3, 2, 1]


        // lets use peek() function - it is used to print during the functional chaining
       List<Integer> lstOfEvenInteger =  listOfInteger.stream()
                .filter( num -> num % 2 == 0) // below will print each evn number one by one
                .peek( evenNum -> System.out.print(evenNum + " ")) // equivalent to .peek(System.out::println)
                .toList();

       System.out.println("\n List of EVEN element from list : " + lstOfRepeatedNum +" ==> " + lstOfEvenInteger);// [0, 2, 6, 10, 60, 100, 222]


        // WAY - 5 : from generate (a kind of loop but produce same thing) with Stream CLass
        List<String> generate4TimesHello = Stream.generate(() -> "hello").limit(4).toList();// it will generate 4 hello string
        System.out.println("4 time hello with generateFUN : " + generate4TimesHello); // [hello, hello, hello, hello]

        // TODO:  list of 10 random double values between 0 (inclusive) and 100 (exclusive).
        List<Double> tenRandomNumberGen = Stream.generate( ()-> Math.random()*100) // Math.random() generates a random double value between 0.0 (inclusive) and 1.0 (exclusive).
                .limit(10)  // Multiplying by 100 scales the value to be between 0.0 and 100.0.
                .toList(); // WARING - below java 16 we were using collect(Collectors.toList());
        System.out.println("10 random number generated  :  "+ tenRandomNumberGen);// [2.3075267417747125, 95.31279310966471, 57.33469262941927, 72.47392189433114, 75.51608047271898, 89.6537371226308, 85.4381426480943, 57.87829993073179, 63.30124923820873, 82.05312071913797]
        //  ()-> Double.parseDouble(String.format("%.2f", Math.random() * 100)) this will make only 2 decimal point

    }
}
