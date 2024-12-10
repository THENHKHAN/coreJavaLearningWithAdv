package kunalSeries.stringassignment.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
// TODO: 1773. Count Items Matching a Rule
// https://leetcode.com/problems/count-items-matching-a-rule/description/
public class _7_CountItemsMatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        System.out.println("ruleKey : " + ruleKey);
        System.out.println("ruleValue : " + ruleValue);

        int matchCount = 0;
        for(List<String> lstStr: items){

            if (ruleKey.equals("type")){
                if(ruleValue.equals(lstStr.get(0)) )
                    matchCount++;

            } else if (ruleKey.equals("color")){
                if(ruleValue.equals(lstStr.get(1)) )
                    matchCount++;

            } else{ // name
                if(ruleValue.equals(lstStr.get(2)) )
                    matchCount++;

            }

        }

        return matchCount;
    }

    public int countMatchesOptimized1(List<List<String>> items, String ruleKey, String ruleValue) {
        // more readable and less condtions
        System.out.println("ruleKey : " + ruleKey);
        System.out.println("ruleValue : " + ruleValue);
        int matchCount = 0;
        for(List<String> lstStr: items){

            if(ruleKey.equals("type") && lstStr.get(0).equals(ruleValue)) matchCount++;
            if(ruleKey.equals("color") && lstStr.get(1).equals(ruleValue)) matchCount++;
            if(ruleKey.equals("name") && lstStr.get(2).equals(ruleValue)) matchCount++;

        }

        return matchCount;
    }

    public int countMatchesOptimized2(List<List<String>> items, String ruleKey, String ruleValue) {
        System.out.println("ruleKey : " + ruleKey);
        System.out.println("ruleValue : " + ruleValue);
        int matchCount = 0;
        // Map the ruleKey to the corresponding index in the list
        int keyIndex = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> -1; // Invalid key, though this shouldn't happen
        };

        if (keyIndex == -1) {
            return 0; // Return 0 if the ruleKey is invalid
        }
        // Use a stream or a simple loop to count matches
        for (List<String> lstStr : items) {
            if (ruleValue.equals(lstStr.get(keyIndex))) {
                matchCount++;
            }
        }

        return matchCount;
    }

    // Even Shorter Version (Using Streams)
    public int countMatchesOptimized3(List<List<String>> items, String ruleKey, String ruleValue) {

        System.out.println("ruleKey : " + ruleKey);
        System.out.println("ruleValue : " + ruleValue);
        int keyIndex = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> -1;
        };

        if (keyIndex == -1) return 0;

        // Count using streams
        return (int) items.stream()
                .filter(lstStr -> ruleValue.equals(lstStr.get(keyIndex)))
                .count();
    }

    public static void main(String[] args) {

        _7_CountItemsMatchingRule obj = new _7_CountItemsMatchingRule();

        List<List<String> > lstOfLstOfString1 = new ArrayList<> ( Arrays.asList(
                                    Arrays.asList("phone", "blue", "pixel"),
                                    Arrays.asList("computer", "silver", "lenovo"),
                                    Arrays.asList("phone", "gold", "iphone")
                                 )
                             );

        List<List<String> > lstOfLstOfString2 = new ArrayList<>( Arrays.asList(
                                    Arrays.asList("phone", "blue", "pixel"),
                                    Arrays.asList("computer", "silver", "lenovo"),
                                    Arrays.asList("phone", "gold", "iphone")
                                 )
                            );

        // Print the Lists
        System.out.println("First List of Lists:");
        System.out.println(lstOfLstOfString1);

        System.out.println("\t\t TESSSSSSSSSSSSSSSSTtttttttttttttt CASE -1");

        String ruleKey =  "color";
        String ruleValue = "silver";
        System.out.println("Count Matches  : " + obj.countMatches(lstOfLstOfString1, ruleKey, ruleValue));
        System.out.println("Count Matches countMatchesOptimized1 : " + obj.countMatchesOptimized1(lstOfLstOfString1, ruleKey, ruleValue));
        System.out.println("Count Matches countMatchesOptimized2 : " + obj.countMatchesOptimized2(lstOfLstOfString1, ruleKey, ruleValue));
        System.out.println("Count Matches countMatchesOptimized3  with STREAM: " + obj.countMatchesOptimized3(lstOfLstOfString1, ruleKey, ruleValue));

        System.out.println("\n\t\t  TESSSSSSSSSSSSSSSSTtttttttttttttt CASE -2");
        String ruleKey2 =  "type";
        String ruleValue2 = "phone";
        System.out.println("Second List of Lists:");
        System.out.println(lstOfLstOfString2);

        System.out.println("Count Matches  : " + obj.countMatches(lstOfLstOfString2, ruleKey2, ruleValue2));
        System.out.println("Count Matches countMatchesOptimized1 : " + obj.countMatchesOptimized1(lstOfLstOfString2, ruleKey2, ruleValue2));
        System.out.println("Count Matches countMatchesOptimized2 : " + obj.countMatchesOptimized2(lstOfLstOfString2, ruleKey2, ruleValue2));
        System.out.println("Count Matches countMatchesOptimized3  with STREAM: " + obj.countMatchesOptimized3(lstOfLstOfString2, ruleKey2, ruleValue2));



    }
}
