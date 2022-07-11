package training.java;

import java.util.Scanner;
import java.util.TreeSet;

public class SortedByDefault {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Size");
        int n=sc.nextInt();
        TreeSet<Integer> list= new TreeSet<>();
        while(n--!=0){
            System.out.println("Element");
            list.add(sc.nextInt());
        }
        for(Integer e:list){
            System.out.print(e+"\t");
        }
    }
}
