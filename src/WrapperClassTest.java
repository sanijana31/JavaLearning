import java.util.ArrayList;

public class WrapperClassTest {
    public static void main(String[] args){

        Integer a = 128; // 1st instance of Integer created
        Integer b = 128; // 2nd instance of Integer created
        Double aa=5.7;
        Double bb=5.7;

        System.out.println(Integer.toHexString(System.identityHashCode(a)));
        System.out.println(Integer.toHexString(System.identityHashCode(b)));
        a++;
        System.out.println(Integer.toHexString(System.identityHashCode(a)));
        System.out.println(Integer.toHexString(System.identityHashCode(b)));
        b++;
        System.out.println(Integer.toHexString(System.identityHashCode(a)));
        System.out.println(Integer.toHexString(System.identityHashCode(b)));
        //b=a+1-1;
        System.out.println(a==b);
    }

}

