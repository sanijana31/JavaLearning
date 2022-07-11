package training.java;

import java.util.Scanner;

public class ArrayManipulation {
    int a[][];
    int m,n;
    ArrayManipulation(){
        a=null;
        n=m=0;
    }
    ArrayManipulation(int m,int n){
        a=new int[m][n];
        this.m=m;
        this.n=n;
    }
    public static long factorial(int n){
        long f=1;
        while(n>1){
            f*=n--;
        }
        return f;
    }
    public boolean checkPrime(int i,int j){
        if(a[i][j]<=0){
            return false;
        }
        else if(a[i][j]<=2){
            return true;
        }
        else{
            if(a[i][j]%2!=0){
                for(int check=3;check<Math.sqrt(a[i][j]);check+=2){
                    if(a[i][j]%check==0){
                        return false;
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void merge(int beg, int mid, int end){
        int n1,n2,i=0,j=0,k=beg;
        n1=mid-beg+1;
        n2=end-mid;
        int temp1[]=new int[n1];
        int temp2[]=new int[n2];
        for(i=0;i<n1;i++){
            temp1[i]=a[beg+i][beg+i];
        }
        for(i=0;i<n2;i++){
            temp2[i]=a[mid+1+i][mid+1+i];
        }
        i=j=0;
        while(i<n1&&j<n2){
            if(temp1[i]<temp2[j]){
                a[k][k]=temp1[i++];
            }
            else{
                a[k][k]=temp2[j++];
            }
            k++;
        }
        while(i<n1){
            a[k][k++]=temp1[i++];
        }
        while(j<n2){
            a[k][k++]=temp2[j++];
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
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int countprime=0,n,countOdd=0,countEven=0;
        System.out.println("enter size of array");
        n=sc.nextInt();
        long factoArray[][]=new long[n*n][2];
        int odd[]=new int[n*n];
        int even[]=new int[n*n];
        ArrayManipulation obj=new ArrayManipulation(n,n);
        System.out.println("Enter the array");
        for(int i=0;i<obj.m;i++){
            for (int j=0;j<n;j++){
                obj.a[i][j]=sc.nextInt();
            }
        }

        System.out.println("Array");
        for(int i=0;i<obj.m;i++){
            for (int j=0;j<n;j++){
                System.out.print(obj.a[i][j]+"\t");
            }
            System.out.println();
        }


        obj.mergeSort(0,n-1);

        for(int i=0;i<obj.m;i++){
            for (int j=0;j<n;j++){
                if(obj.checkPrime(i,j)){
                    factoArray[countprime][0]=obj.a[i][j];
                    factoArray[countprime++][1]=factorial(obj.a[i][j]);
                }
                if(obj.a[i][j]%2==0){
                    even[countEven++]=obj.a[i][j];
                }
                else{
                    odd[countOdd++]=obj.a[i][j];
                }
            }
        }

        System.out.println("Diagonal sort");
        for(int i=0;i<obj.m;i++){
            for (int j=0;j<n;j++){
                System.out.print(obj.a[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("Odd Array");
        for (int j=0;j<countOdd;j++){
            System.out.print(odd[j]+"\t");
        }

        System.out.println("\nEven Array");
        for (int j=0;j<countEven;j++){
            System.out.print(even[j]+"\t");
        }

        System.out.println("\nfactorial array");
        for (int j=0;j<countprime;j++){
            System.out.println(factoArray[j][0]+"->"+factoArray[j][1]);
        }
    }
}
