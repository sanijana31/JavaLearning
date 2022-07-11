package training.java;

import java.util.*;

public class WordOccurrencesInListOfStrings {
    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        HashMap<String,HashMap<String,Integer>> wordCount=new HashMap<String,HashMap<String,Integer>>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Size");
        int n=Integer.parseInt(sc.nextLine());
        while(n--!=0){
            System.out.println("String");
            list.add(sc.nextLine().toUpperCase());
        }
        for(String senetnce: list){
            wordCountMethod(senetnce,wordCount);
        }
        wordCount.forEach((k,v)->{
            System.out.println(k+"\n____________________\n");
            v.forEach((key,value)->{
                System.out.println(key+" -> "+value);
            });
        });

    }
    public static void wordCountMethod(String sentence, HashMap<String, HashMap<String, Integer>> wordcount){
        HashMap<String,Integer> wordsHash=new HashMap<>();
        String [] words=sentence.split("[\\s,.?!]+");
        for(String word: words){
            if(wordsHash.containsKey(word)){
                wordsHash.put(word,wordsHash.get(word)+1);
            }
            else{
                wordsHash.put(word,1);
            }
        }
        wordcount.put(sentence,wordsHash);
    }
}
