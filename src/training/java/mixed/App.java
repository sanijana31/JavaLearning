package training.java.mixed;

import java.io.*;

 abstract class Shape {
    double area;
    public abstract void areaCalculate();
}

 class Circle extends Shape{
    double radius;
    Circle(){
        radius=0;
    }
    Circle(double r){
        radius=r;
    }
    @Override
    public void areaCalculate() {
        area=Math.PI*radius*radius;
    }
    public String toString(){
        return "Radius: "+radius+"  Area: "+area;
    }
}

 class Square extends Shape{
    double side;
    Square(){
        side=0;
    }
    Square(double s){
        side=s;
    }
    @Override
    public void areaCalculate() {
        area=side*side;
    }
    public String toString(){
        return "Side: "+side+"  Area: "+area;
    }
}


 class Rectangle extends Shape{
    double len,bre;
    Rectangle(){
        len=bre=0;
    }
    Rectangle(double l,double b){
        len=l;
        bre=b;
    }
    @Override
    public void areaCalculate() {
        area=len*bre;
    }
    public String toString(){
        return "Length: "+len+"  Breadth: "+bre+"  Area: "+area;
    }
}



public class App {
    public static void main(String[] args) throws Exception{
        BufferedReader br=null;
        FileReader fr=null;
        FileWriter fw=null;
        File fileReader=new File("x.txt");
        //File file=new File("y.txt");
        File fileWriter=new File("y.txt");
        Shape circle = null,rectangle=null,square=null;
        Circle c=null;
        Square s=null;
        Rectangle r=null;
        try {
            fr=new FileReader(fileReader);
            fw=new FileWriter(fileWriter,false);
            br=new BufferedReader(fr);
            System.out.println("Enter the Radius");
            circle=new Circle(Double.parseDouble(br.readLine()));
            c=(Circle) circle;
            System.out.println("Enter the Length and Breadth");
            rectangle=new Rectangle(Double.parseDouble(br.readLine()),Double.parseDouble(br.readLine()));
            r=(Rectangle)rectangle;
            System.out.println("Enter the Side");
            square=new Square(Double.parseDouble(br.readLine()));
            s=(Square)square;
            circle.areaCalculate();
            square.areaCalculate();
            rectangle.areaCalculate();
            System.out.println(circle);
            System.out.println(rectangle);
            System.out.println(square);

            fw.write("Radius: "+c.radius+"  Area: "+c.area);
            fw.write("\nlength: "+r.len+"Breadth: "+r.bre+"  Area: "+r.area);
            fw.write("\nSide: "+s.side+"  Area: "+s.area);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fr.close();
            fw.close();
        }
    }
}
