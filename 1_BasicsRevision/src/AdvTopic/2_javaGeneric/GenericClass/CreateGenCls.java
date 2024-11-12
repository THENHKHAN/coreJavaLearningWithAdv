package javaGeneric.GenericClass;

// TODO : // To create an instance of generic class
// TODO : BaseType <Type> obj = new BaseType <Type>()

 class Test<T> {
    // An object of type T is declared
    T obj ;
    Test(T obj){
        this.obj = obj;
    }

    public T getObj (){
        return this.obj;
    }

}

 class TwoParamsGenCls <T, U>{
     T obj1 ;
     U obj2 ;

     TwoParamsGenCls(T obj1, U obj2) {
         this.obj1 = obj1;
         this.obj2 = obj2;
     }

     public void printObj(){
         System.out.println("Obj1Str Type :   " + this.obj1) ;
         System.out.println("Obj2Integer Type :   " + this.obj2) ;
     }

     @Override
     public String toString() {
         return "TwoParamsGenCls{" +
                 "obj1=" + obj1 +
                 ", obj2=" + obj2 +
                 '}';
     }
 }


public class  CreateGenCls {

    public static void main(String[] args) {

        // let's create instance of Integer type
        System.out.println("********************** let's create instance of Integer type ********************** \n" );
         Test<Integer> iObj = new Test<Integer>(2000) ;
        System.out.println("sending 2000 and getting through function: " + iObj.getObj());
        System.out.println("Generic  CLASS : " + iObj.getClass()); //class javaGeneric.GenericClass.Test

       // let's create instance of String type
        System.out.println("\n ********************** let's create instance of String type ********************** \n" );
        Test<String> strObj = new Test<>("Noorul Huda Khan");
        System.out.println("String type obj  : " + strObj.getObj());
        System.out.println("Generic  CLASS : " + iObj.getClass()); //class javaGeneric.GenericClass.Test


        // let's create instance of String as well as Integer type
        System.out.println("\n ********************** let's create instance of String as well as Integer type ********************** \n" );
        TwoParamsGenCls<String, Integer> strIntTypeObj = new TwoParamsGenCls<String, Integer>("Noorul", 900);
        strIntTypeObj.printObj();
        System.out.println("str With Int Type Obj VIA toString()  :  " + strIntTypeObj );// TwoParamsGenCls{obj1=Noorul, obj2=900}
        System.out.println("Generic  CLASS : " + strIntTypeObj.getClass()); // class javaGeneric.GenericClass.TwoParamsGenCls
    }

}
