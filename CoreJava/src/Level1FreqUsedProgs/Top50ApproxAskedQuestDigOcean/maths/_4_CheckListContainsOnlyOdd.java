package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: 6. How do you check if a list of integers contains only odd numbers in Java?
public class _4_CheckListContainsOnlyOdd {
    public  static boolean checkListContainsOddOnly(List<Integer> ls){
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i)%2==0)
                return false;
        }
        return true;
    }

    // with stream  : will allmatch() function
    public static boolean checkListContainsOddOnlyWithStream(List<Integer>lst){
              return lst.stream().allMatch(ele->ele%2 != 0);
              // This checks if every number in the list is odd. If all numbers are odd, it returns true; otherwise, it returns false.
    }

    // with parallelStream  : will allmatch() function
    // Use parallelStream() for large datasets otherwise stream is best
    public static boolean checkListContainsOddOnlyWithParallelStream(List<Integer>lst){
        return lst.parallelStream().allMatch(ele->ele%2 != 0);
                        // return AS SOON AS any elements match the condition
    }

    public static void main(String[] args) {
//        List<Integer> ls = new ArrayList<>(Arrays.asList(1, 33, 5, 9, 15, 11, 12));// No
        List<Integer> ls = new ArrayList<>(Arrays.asList(1, 33, 5, 9, 15, 11)); // YES
        System.out.println("List : " + ls);
        System.out.println("#################### Using usual way by traversing ####################");
        if(checkListContainsOddOnly(ls))
            System.out.println("YES, It only contains ODD number in the list");
        else
            System.out.println("NO, it contains Even also");

        System.out.println("#################### Using Java stream api allmatch() ####################");

        if(checkListContainsOddOnlyWithStream(ls))
            System.out.println("YES, It only contains ODD number in the list");
        else
            System.out.println("NO, it contains Even also");

    }
}

/*
    Conclusion::::::::::::::::

    For small to medium-sized datasets and performance-critical applications, a traditional for-loop is likely to be more efficient.
    For more readable, maintainable, and parallelizable code, especially on larger datasets, streams are a better choice.

In most modern Java applications, streams are preferred due to their readability and ease of use. However, if maximum performance is your goal,
especially with smaller lists, the traditional for-loop may be the way to go.
 */
