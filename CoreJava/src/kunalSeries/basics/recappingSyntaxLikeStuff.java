package kunalSeries.basics;

public class recappingSyntaxLikeStuff {

    public static void main(String[] args) {


        System.out.println(" ***************************** 1. String *****************************" );

        String str = "Noorul Huda Khan"; //  String literal way
        System.out.println(str.length());
        String strClsObj = new String("Guddu"); // other way : Using new keyword
        System.out.println("My String : " + str); // My String : Noorul Huda Khan
        System.out.println("My String at index 3 : " + str.charAt(3)); // r

        System.out.println(" ***************************** 2. StringBuffer *****************************" );
// 2. StringBuffer : it is mutable in nature and it is thread safe class

        StringBuffer strBfr = new StringBuffer("Hey Noor");
        System.out.println(strBfr.length());
        System.out.println("FrmStr buffer : " + strBfr); // Hey Noor
        strBfr.append(" updated strBfr" ); // MUTABLE

        System.out.println(" Updated str bfr : " + strBfr); // Hey Noor updated strBfr

    }
}
