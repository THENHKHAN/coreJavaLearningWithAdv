package kunalSeries.basics.maths;

import java.util.Scanner;

// TODO : Normal Calculator project to just apply logic and simple programming syntax
public class Project1_Calculator {

    public static int calculateSum(int a, int b) {
          return a+b;
    }

    private static int calculateDiff(int a, int b) {
        return a-b;
    }

    private static int calculateProd(int a, int b) {
        return a*b;
    }

    private static double calculateDiv(int a, int b) {
        return a*1.0 /b;
    }

    public static void main(String[] args) {

        System.out.println("\n =============================== Simple Calculator START===============================");
        System.out.println("""
               \t\t     1- SUM            2- Sub  \s
               \t\t     3- Prod           4- Div   \s
               \t\t     0- Quit 
                """);

        while (true){
            System.out.print("Enter your choice please: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice){

                case 1 :
                    System.out.print("Input 1st integer value : ");
                    int a1 = new Scanner(System.in).nextInt();
                    System.out.print("Input 1st integer value : ");
                    int b1 = new Scanner(System.in).nextInt();
                    System.out.println(" Sum of " +a1 +" and " + b1 + " : " +calculateSum(a1, b1));
                    break;
                case 2 :
                    System.out.print("Input 1st integer value : ");
                    int a2 = new Scanner(System.in).nextInt();
                    System.out.print("Input 1st integer value : ");
                    int b2 = new Scanner(System.in).nextInt();
                    System.out.println(" Difference of " +a2 +" and " + b2 + " : " +calculateDiff(a2, b2));
                    break;
                case 3 :
                    System.out.print("Input 1st integer value : ");
                    int a3 = new Scanner(System.in).nextInt();
                    System.out.print("Input 1st integer value : ");
                    int b3 = new Scanner(System.in).nextInt();
                    System.out.println(" Product of " +a3 +" and " + b3 + " : " +calculateProd(a3, b3));
                    break;
                case 4 :
                    System.out.print("Input nominator : ");
                    int a4 = new Scanner(System.in).nextInt();
                    System.out.print("Input denominator but not 0 : ");
                    int b4 = new Scanner(System.in).nextInt();
                    System.out.println(" Division of " +a4 +" and " + b4 + " : " +calculateDiv(a4, b4));
                    break;
                case 0:
                    System.out.println("Thank you for using my calculator :)");
                    System.exit(1);

                default:
                    System.out.println("INVALID INPUT!!");
            }
        }
    }


}
