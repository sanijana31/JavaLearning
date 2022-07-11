package training.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortListIncreasingAndDecreasing {
    public static void main(String args[]){
        ArrayList<Integer> list =new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Size");
        int n=sc.nextInt();
        while (n--!=0){
            System.out.println("Element");
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
