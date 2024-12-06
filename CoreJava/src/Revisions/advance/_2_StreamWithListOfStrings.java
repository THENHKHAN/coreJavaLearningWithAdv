package Revisions.advance;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class _2_StreamWithListOfStrings {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("a", "b", "c");
        // forEach: Print each name
        System.out.println("Original List of Strings : " + lst); //  [a, b, c]
        List<String> lstWitUpperCase = lst.stream().map(String::toUpperCase).toList();
        System.out.println("Original List make upper case from stream map() of Strings : " + lstWitUpperCase); //  [A, B, C]


        // collect all string which starts from s:
        List<String> ls = Arrays.asList( "Reflection", "Collection", "Stream", "Structure", "Sorting", "State");
        System.out.println("Original List of Strings  NEW : " + ls); //   [Reflection, Collection, Stream, Structure, Sorting, State]

//        List<String> lstWithStartWithS = ls.stream().filter(str->str.startsWith("s")).collect(Collectors.toList());
        List<String> lstWithStartWithS = ls.stream().filter(str->str.toLowerCase().startsWith("s")).toList();
        System.out.println("Original List  collect all string which starts from s : " + lstWithStartWithS); // [Stream, Structure, Sorting, State]

    }
}
