package Level3JavaGeneric;

public class _2_MyGenericCls<T> {

    T container;

    public _2_MyGenericCls (){
        System.out.println("This is default constructor ... " );
    }

    public _2_MyGenericCls (T data){
        this.container = data;
    }

   public T getData (){
        return this.container;
    }

    public void performFindLengthOfAttrIfStringTask (){
        if (container instanceof String){
            System.out.println("Container of " + container  +   " Length : " + ( (String) this.container).length());
        } else {
            System.out.println("provided data is not string type ");
        }

    }

}


// TODO : this is how it will map if we parameterize with type
/*
public class _2_MyGenericCls<Integer> {

    Integer container;

    public _2_MyGenericCls (){
        System.out.println("This is default constructor ... " );
    }

    public _2_MyGenericCls (Integer data){
        this.container = data;
    }

   public Integer getData (){
        return this.container;
    }
}
 */
