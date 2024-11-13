package Level1FreqUsedProgs.Top50ApproxAskedQuestDigOcean;

// TODO: swap two numbers without using a third variable in Java
public class _1_swap2NumWithout3rdVar {

    public static void main(String[] args) {
        int a = 10,  b = 20 ;
        System.out.println("Original ===> a = " + a + " and b = " + b); //a = 10 and b = 20
        a = a+b; // 10+20 -> 30
        b = a-b; // 30-20 -> 10(b is swapped) : reverse approach (how to get b as 10 so we have 30. 30-x = 20 => x==>10 so x == b)
        a = a-b;    //  30 - 10 -> 20 : reverse approach (how to get a as 20 so we have 30 as and b 10 . 30-10 ==> 20 )
        System.out.println("After Swapping ===> a = " + a + " and b = " + b);// a = 20 and b = 10
    }
}
