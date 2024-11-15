package kunalSeries.basics.maths;

public class _2_CountNumOfOccurenceInNDigNumber {

    public static int countNumOccurence(int num,int checkingFor){
        int count=0;
        while (num>0){
            int lastDig = num%10; // extracting last digit
            num = num/10;// Or n/=10 //removing last dig
            if(lastDig == checkingFor)
                    count +=1;

        }
        return count;
    }

    public static int countNumOccurence(String str,char checkingFor){

        int count=0;
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == checkingFor){  // checkingFor now as character. if directly cast into Int oc ch  then it would COMPARE with ascii VALUE OF CH
                count+=1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 245324242 ; //
        int countOccNum = 2 ;  // ans = 4 // 2 time 3 occurred
        System.out.println("======= Using % and while loop =======");
        System.out.println(" Occurrence of "+ countOccNum+ ": " + countNumOccurence(number, countOccNum) ); // Occurrence of 2: 4

        System.out.println("\n ======= Using converting number in STR and then counting character =======");
        System.out.println(" Occurrence of "+ countOccNum+ ": " + countNumOccurence(String.valueOf(number), (char)(countOccNum+'0') ) ); // Occurrence of 2: 4
    }
}
