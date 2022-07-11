package training.java;

import java.util.*;
import java.io.*;

public class SortPersonByAgeUsingArray{
    String persons[][];
    int n;
    SortPersonByAgeUsingArray(){
        persons=null;
        n=0;
    }
    SortPersonByAgeUsingArray(String [][] a, int n){
        persons=a;
        this.n=n;
    }
    public static void main(String[] args)throws IOException{
        String a[][];
        int n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of Person");
        n=Integer.parseInt(br.readLine());
        a=new String[n][2];
        System.out.println("Enter the persons");
        for(int i=0;i<n;i++){
            System.out.println("Enter Name");
            a[i][0]= br.readLine();
            System.out.println("Enter age");
            a[i][1]=br.readLine();
        }
        SortPersonByAgeUsingArray list=new SortPersonByAgeUsingArray(a,n);
        list.mergeSort(0,(list.n)-1);
        System.out.println(list);
    }
    public void merge(int beg, int mid, int end){
        int n1,n2,i=0,j=0,k=beg;
        n1=mid-beg+1;
        n2=end-mid;
        String temp1[][]=new String[n1][2];
        String temp2[][]=new String[n2][2];
        for(i=0;i<n1;i++){
            temp1[i][0]=persons[beg+i][0];
            temp1[i][1]=persons[beg+i][1];
        }
        for(i=0;i<n2;i++){
            temp2[i][0]=persons[mid+1+i][0];
            temp2[i][1]=persons[mid+1+i][1];
        }
        i=j=0;
        while(i<n1&&j<n2){
            if(Integer.parseInt(temp1[i][1])<Integer.parseInt(temp2[j][1])){
                persons[k][0]=temp1[i][0];
                persons[k][1]=temp1[i++][1];
            }
            else{
                persons[k][0]=temp2[j][0];
                persons[k][1]=temp2[j++][1];
            }
            k++;
        }
        while(i<n1){
            persons[k][0]=temp1[i][0];
            persons[k++][1]=temp1[i++][1];
        }
        while(j<n2){
            persons[k][0]=temp2[j][0];
            persons[k++][1]=temp2[j++][1];
        }
    }
    public void mergeSort(int beg, int end){
        if(beg<end){
            int mid=(beg+end)/2;
            mergeSort(beg,mid);
            mergeSort(mid+1,end);
            merge(beg,mid,end);
        }
    }
    public String toString(){
        String str=new String();
        for(int i=0;i<n;i++){
            str+="name: "+persons[i][0]+". age: "+persons[i][1]+"\n";
        }
        return str;
    }
}
