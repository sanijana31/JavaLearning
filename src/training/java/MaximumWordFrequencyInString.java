package training.java;

import java.util.*;

public class MaximumWordFrequencyInString {
    String sentence;
    int maxCount;
    String maxCountWord;
    HashMap<String,Integer> countWordFrequency;
    MaximumWordFrequencyInString(){
        sentence=new String();
        maxCount=-1;
        maxCountWord=new String();
        countWordFrequency=new HashMap<>();
    }
    MaximumWordFrequencyInString(String  sentence){
        this.sentence=sentence;
        maxCount=-1;
        maxCountWord=new String();
        countWordFrequency=new HashMap<>();
    }
    public void findWordFrequency(){
        String words[]=sentence.split(" ");
        for(String word: words){
            if(countWordFrequency.containsKey(word)){
                countWordFrequency.put(word,countWordFrequency.get(word)+1);
            }
            else{
                countWordFrequency.put(word,1);
            }
        }
    }
    public void findMaxFrequency(){
        countWordFrequency.forEach((k,v)->{
           if (v>maxCount){
               maxCount=v;
               maxCountWord=k;
           }
        });
    }
    public String toString(){
        return "sentence->"+sentence+"\nmaximum word ->"+maxCountWord+" - "+maxCount;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        MaximumWordFrequencyInString obj=new MaximumWordFrequencyInString(sentence);
        obj.findWordFrequency();
        obj.findMaxFrequency();
        System.out.println(obj);
    }
}
