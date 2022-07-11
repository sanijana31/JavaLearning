import java.io.Serializable;

public class Serialize2 extends Serialize1 implements Serializable {
    public int j=10;
    Serialize2(){
        System.out.println("Serialization2");
    }
}
