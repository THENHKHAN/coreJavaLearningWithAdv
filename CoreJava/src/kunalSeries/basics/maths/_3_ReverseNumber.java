package kunalSeries.basics.maths;

public class _3_ReverseNumber {

    public static int reverseNumWithLoop(int num){
        int ans = 0;
        while (num>0){
            int dig = num%10 ;
            num /= 10;
            ans = ans*10 + dig;
        }

        return ans;
    }



    public static void main(String[] args) {
        int number = 123456 ;
        System.out.println("======= Using % and while loop  =======");
        System.out.println("Reverse Number of "+ number + " : " + reverseNumWithLoop(number) ); //Reverse Number of 123456 : 654321
  }
}
