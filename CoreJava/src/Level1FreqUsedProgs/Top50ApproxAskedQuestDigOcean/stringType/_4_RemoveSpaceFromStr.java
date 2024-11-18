package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.stringType;

// TODO: 8. How do you remove spaces from a string in Java?
public class _4_RemoveSpaceFromStr {
    public static void main(String[] args) {
        String inpStr = "kaizen     noor sfsfs wdwssffs"; //

        System.out.println("Original String : " + inpStr); // noor sfsfs wdwssffs
        String remSpaceSr = inpStr.replace(" ", "");
        System.out.println("Removed spaces  String : " + remSpaceSr); // kaizennoorsfsfswdwssffs

        String inpStr2 = "kaizen   Huddd noor sfsfs ";
       StringBuilder out = new StringBuilder();
        System.out.println("Original String : " + inpStr2); //  kaizen   Huddd noor sfsfs
        char[] charArr = inpStr2.toCharArray();
        for (int i = 0; i < inpStr2.length(); i++) {
            if(!Character.isWhitespace(charArr[i]))
                out.append(charArr[i]);
        }
        System.out.println("Removed spaces  String : " + out.toString()); // kaizenHudddnoorsfsfs

    }
}

