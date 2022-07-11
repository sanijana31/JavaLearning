
import java.io.*;

public class App {
    public static void main(String[] args)throws Exception{
        FileOutputStream fo=new FileOutputStream("test.bin");
        ObjectOutputStream os=new ObjectOutputStream(fo);
        Serialize1 s1=new Serialize2();
        s1.i=15;
        System.out.println(s1.i+"     "+((Serialize2)s1).j);
        os.writeObject(s1);
        //System.out.println(s1.obj);

        FileInputStream fi=new FileInputStream("test.bin");
        ObjectInputStream is=new ObjectInputStream(fi);
        Serialize2 s2=(Serialize2) is.readObject();
        //Serialize2 s3=s2;
        //System.out.println(Integer.toHexString(System.identityHashCode(s2.obj)));
        //System.out.println(Integer.toHexString(System.identityHashCode(s3.obj)));
        //Sirialization obj=new Sirialization(5,6);
        //Sirialization obj2=obj;
        System.out.println(s2.i+"     "+s2.j);
    }
}
