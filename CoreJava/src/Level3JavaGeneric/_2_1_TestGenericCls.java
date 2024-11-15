package Level3JavaGeneric;

public class _2_1_TestGenericCls {

    public static void main(String[] args) {

        _2_MyGenericCls <String> d = new _2_MyGenericCls<>();
        _2_MyGenericCls <String> obj1 = new _2_MyGenericCls<>("Noorul");
        _2_MyGenericCls <Integer> obj2 = new _2_MyGenericCls<>(25);

        System.out.println("Data string result : " + obj1.getData()); // Noorul
        System.out.println("Data Integer result : " + obj2.getData()); // 25
        System.out.println("myGenCls : " + obj1.getClass()); // class Level3JavaGeneric._2_MyGenericCls
        System.out.println("myGenCls from 2nd obj: " + obj2.getClass()); // class Level3JavaGeneric._2_MyGenericCls
        System.out.println("myGenCls from 2nd obj CLS Attr Type : " + obj2.container.getClass().getName()); //  java.lang.Integer

        // getting container data length if string
        System.out.println("******************* Sending String in generic ******************* ");
        _2_MyGenericCls  <String> obj3 = new _2_MyGenericCls<>("Noorul2");
        obj3.performFindLengthOfAttrIfStringTask();

        // getting container data length if string
        System.out.println("******************* Sending Double in generic ******************* ");
        _2_MyGenericCls <Double> obj4 = new _2_MyGenericCls<>(444.77) ;
        obj4.performFindLengthOfAttrIfStringTask();
    }
}

