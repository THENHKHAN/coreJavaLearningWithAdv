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
    public static void main(String[] args) {
//        List<Integer> ls = new ArrayList<>(Arrays.asList(1, 33, 5, 9, 15, 11, 12));// No
        List<Integer> ls = new ArrayList<>(Arrays.asList(1, 33, 5, 9, 15, 11)); // YES
        System.out.println("List : " + ls);
        if(checkListContainsOddOnly(ls))
            System.out.println("YES, It only contains ODD number in the list");
        else
            System.out.println("NO, it contains Even also");
    }
}
