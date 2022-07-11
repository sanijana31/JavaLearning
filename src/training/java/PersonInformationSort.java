package training.java;

import java.util.*;

public class PersonInformationSort {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,Integer> persons=new HashMap<>();
        while(n-->0){
            System.out.println("enter name and age");
            String name=sc.next();
            int age=sc.nextInt();
            persons.put(name,age);
        }
        TreeMap treeMap = new TreeMap<>((o1, o2) -> {
                return Integer.compare( persons.get(o1) , persons.get(o2) );
        });
        treeMap.putAll(persons);
        display(treeMap);
    }
    public static void display(Map<String,Integer> h){
        for(Map.Entry e: h.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}
