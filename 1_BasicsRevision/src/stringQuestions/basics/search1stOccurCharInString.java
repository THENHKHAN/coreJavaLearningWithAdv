package stringQuestions.basics;

// https://origin.geeksforgeeks.org/program-to-search-a-character-in-a-string/#by-traversing-the-string-on-time-and-o1-space
// TODO: Program to Search a Character in a String

public class search1stOccurCharInString {

    public static int findCharByInBuildMethod(String str, char ch){
        // If character is found, returns the index of first occurrence of ch.
        // Otherwise, returns -1
        int ind = str.indexOf(ch);
        return ind;
    }

    public  static int findCharByTraversing(String str, char ch){
        for (int i=0 ; i < str.length() ; i++){
            if(ch == str.charAt(i)){
                return i;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        String str = "noorulhudakhan";//index num: 012345678910111213
        char ch = 'a';
        int index = findCharByTraversing(str, ch);
        if(index<0){
            System.out.println("character: " + ch + " is NOT found in the string :  " + str);
        }else{
            System.out.println("character: " + ch + " is FOUND in the string :  " + str + " at INDEX : " + index ); // 9
        }

        System.out.println(" ============== By In Built Method -==================");
        if(findCharByInBuildMethod(str, ch)<0){
            System.out.println("character: " + ch + " is NOT found in the string :  " + str);
        }else{
            System.out.println("character: " + ch + " is FOUND in the string :  " + str + " at INDEX : " + findCharByInBuildMethod(str, ch) ); // 9
        }
    }
}