package kunalSeries.stringassignment.easy;

// TODO: 1678. Goal Parser Interpretation : we can directly use replace method -One Solution
// https://leetcode.com/problems/goal-parser-interpretation/description/
// https://algo.monster/liteproblems/1678
public class _6_GoalParserInterpretation {


    public String interpretPreDefindMethod(String command) {
        return command.replace("()","o").replace("(al)", "al");
    }


    public String interpretOurLogic(String command) {

        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G')
                strB.append("G");
            if (command.charAt(i) == '(' ){
                if (command.charAt(i+1) == ')') // i+1 wont be outOfBound bcz if ( is there  this means ) or all means once character at least should be there at i+1.
                    strB.append("o");
                else  // al)
                    strB.append("al");
            }

        }

        return strB.toString();
    }



    public static void main(String[] args) {
        _6_GoalParserInterpretation obj = new _6_GoalParserInterpretation();
//        String str =  "G()(al)"; // Goal
        String str = "G()()()()(al)"; //  Gooooal



        System.out.println(" Original String : " + str);

        String interpretedHelper = obj.interpretPreDefindMethod(str);
        String interpreted = obj.interpretOurLogic(str);
        System.out.println(" Interpreted String by PreDefined replace method: " + interpretedHelper);
        System.out.println(" Interpreted String by logic: " + interpreted);
        // time complexity is: O(n)
        // space complexity is: O(n)
    }
}
/*
Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".
Example 2:

Input: command = "G()()()()(al)"
Output: "Gooooal"
Example 3:

Input: command = "(al)G(al)()()G"
Output: "alGalooG"

 */
// todo: other way to less comparison:
/*
 int i = 0;

    while (i < command.length()) {
        if (command.charAt(i) == 'G') {
            strB.append("G");
            i++; // Move to the next character
        } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
            strB.append("o");
            i += 2; // Skip both '(' and ')'
        } else if (command.charAt(i) == '(' && command.startsWith("al", i + 1)) {
            strB.append("al");
            i += 4; // Skip "(al)"
        }
    }
 */
// TODO : approach:
/*
Approach
        Initialize a StringBuilder to build the result.
        Iterate through the string using an index i.
        If the current character is 'G', append 'G' to the result and move the index by 1.
        If the current character is '(' followed by ')', append 'o' and move the index by 2.
        Otherwise, append 'al' and move the index by 4.
        Continue until the end of the string.
Complexity
  Time complexity:
    The time complexity is O(n), where n is the length of the input string command. We traverse the string once.

  Space complexity:
    The space complexity is O(n) for storing the result in the StringBuilder
 */