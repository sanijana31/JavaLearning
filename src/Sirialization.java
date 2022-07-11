import java.io.Serializable;
class A{
    int i=7;
}
public class Sirialization{
    int i;int j;
    A obj;
    Sirialization(int i,int j){
        this.i=i;
        this.j=j;
        obj=new A();
    }
}
