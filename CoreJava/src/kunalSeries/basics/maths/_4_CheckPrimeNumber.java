package kunalSeries.basics.maths;

// TODO: 4. Write a Java program to check if the given number is a prime number.
public class _4_CheckPrimeNumber {
    public  static boolean isPrime(int number){
            if ( number == 0 || number == 1)
                return false ;
            // TODO: we can make sqrt(n)/2  --- will see later
            for (int i=2; i<number/2; i++){ // middle of the number since if i is greater than the middle then I can't divide number completely
                if(number%i == 0 ) return false;
            }
        return true;
    }
    public static void main(String[] args) {
        int number = 6;
        if(isPrime(number))
            System.out.println(number + " is a prime Number");
        else
            System.out.println(number + " is NOT a prime Number");


    }
}
