package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.youtube.com/watch?v=DYyhFLC2eJ0      -- 30Min explained very well
public class _2_WaysToConvertToStream {
    public static void main(String[] args) {
// it worked on Collections : List , LinkedList, ArrayList etc.
        // it is used to perform operation on the provide collection

        // WAY - 1 : from array
        String[] array = {"apple", "banana", "cherry"};
        Stream<String> arrStream = Arrays.stream(array); // from array
//        System.out.println("arrStream RAW : " + arrStream);

        // WAY - 2 : from List or any collection object
        List<String> lst = Arrays.asList("apple", "banana", "cherry", "mango");
        Stream<String> lstStream = lst.stream(); // from List
        System.out.println("lstStream RAW : " + lstStream);// it will give object which is why we perform operation on the stream to get the desired result

        // WAY - 3 : from directly Stream Class with .of()
       Stream<Integer> integerStream =Stream.of(1, 2, 3);

        // WAY - 4 : from iterate (a kind of loop) with Stream CLass

        // iterate(T seed, final UnaryOperator<T> f) ==> seed: from which it starts ,  UnaryOperator: lambda function
       Stream<Integer> zeroToTenNumberGen = Stream.iterate(0, n -> n + 1).limit(11) ; // it will create stream of 0 to 10 number
        // in order to see the data we have collect in some collection like List
        List<Integer> collectedLst = zeroToTenNumberGen.toList(); // earlier using zeroToTenNumberGen.collect(Collectors.toList())
        System.out.println("collectedLst 0-10 number : " + collectedLst);// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // WAY - 5 : from generate (a kind of loop but produce same thing) with Stream CLass
        Stream<String> generate4TimesHello = Stream.generate(() -> "hello").limit(4);// it will generate 4 hello string
        // use CASE : Generate 100 random numbers



        // in lecture-3 we'll do some basic operations on stream

    }
}
