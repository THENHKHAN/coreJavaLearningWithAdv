package kunalSeries.basics.concepts;

public class variableArgs {

    public static void funcTakeAgrsNormally(int a, int b){
        System.out.println("Sum of " + a + " and " + b + ":  " + (a+b)); ;
    }


    public static void funcTakeVarAgrs(int ...args){ //OR  int... args    OR int ... args
        System.out.println("TYPE OF Args : " + args.getClass().getTypeName()); // array of int
        System.out.println("Total Args passed : " + args.length);
        int sumOf2Num = args[0]+args[1];
        System.out.println("Sum of " + args[0] + " and " + args[1] + ":  " + sumOf2Num);

        if (args.length >2 ){
            int sumOf3Num = args[0]+args[1]+args[2];
            System.out.println("Sum of " + args[0] + ", "+ args[1]+ " and " + args[2] + ":  " + sumOf3Num );
        }

        System.out.println("#### Args printing forEach and Normal loop #### ");
        // lets print all in using foreach
        for (int arg : args){
            System.out.print(" "+arg);
        }
        System.out.println();
        // with for loop
        for (int i = 0; i < args.length; i++) {
            System.out.print(" " + args[i]);
        }

    }

    public static void main(String[] args) {
        int a = 10;
        int b = 12;
        int c = 5;

        System.out.println("************** Normal Args Passed in function for calculating sum ************** " );
        funcTakeAgrsNormally(a, b);
        System.out.println("************** Var Args 2 params Passed in function for calculating sum ************** " );
        funcTakeVarAgrs(a, b);
        System.out.println("\n************** Var Args 3 params Passed in function for calculating sum ************** " );
        funcTakeVarAgrs(a, b, c);
    }
}

/*
************** Normal Args Passed in function for calculating sum **************
Sum of 10 and 12:  22
************** Var Args 2 params Passed in function for calculating sum **************
TYPE OF Args : int[]
Total Args passed : 2
Sum of 10 and 12:  22
#### Args printing forEach and Normal loop ####
 10 12
 10 12
************** Var Args 3 params Passed in function for calculating sum **************
TYPE OF Args : int[]
Total Args passed : 3
Sum of 10 and 12:  22
Sum of 10, 12 and 5:  27
#### Args printing forEach and Normal loop ####
 10 12 5
 10 12 5

 */
