package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean.stringType;

// TODO: 9. How do you remove leading and trailing spaces from a string in Java?
public class _5_RemoveLeadingTraillingSpaces {
    public static void main(String[] args) {
        String inpStr = "   kaizen noor sfsfs wdwssffs    "; //

        System.out.println("Original String1 Val : " + inpStr); //     kaizen noor sfsfs wdwssffs
        System.out.println("Original String length: " + inpStr.length()); // 33
        System.out.println("Removed leading & trailing space String Length: " + inpStr.trim().length()); // 26

// strip() method recommended
        String inpStr2 = "    kaizen sfsfs  ";
        StringBuilder out = new StringBuilder();
        System.out.println("Original String2 value: " + inpStr2); //      kaizen sfsfs
        System.out.println("Original String lenght: " + inpStr2.length()); //  18
        System.out.println("Removed leading & trailing space String Length: " + inpStr2.strip().length()); // 12


    }
}
