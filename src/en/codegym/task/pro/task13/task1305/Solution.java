package en.codegym.task.pro.task13.task1305;

import java.util.*;

/*
Find and neutralize
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello world!");
        words.add("Amigo");
        words.add("Elly");
        words.add("Kerry");
        words.add("Bug");
        words.add("bug");
        words.add("Easy ug");
        words.add("Risha");

        ArrayList<String> wordsFirstCopy = new ArrayList<>(words);
        ArrayList<String> wordsSecondCopy = new ArrayList<>(words);
        ArrayList<String> wordsThirdCopy = new ArrayList<>(words);

        removeBugWithFor(wordsFirstCopy);
        removeBugWithWhile(wordsSecondCopy);
        removeBugWithCopy(wordsThirdCopy);

        wordsFirstCopy.forEach(System.out::println);
        String line = "_________________________";
        System.out.println(line);
        wordsSecondCopy.forEach(System.out::println);
        System.out.println(line);
        wordsThirdCopy.forEach(System.out::println);
        System.out.println(line);
    }

    public static void removeBugWithFor(ArrayList<String> list) {
        //write your code here
        for(int i= list.size() - 1; i > 0; i--){
            if(list.get(i).equalsIgnoreCase("bug")){
                list.remove(i);
            }
        }
    }

    public static void removeBugWithWhile(ArrayList<String> list) {
        //write your code here
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            if (it.next().equalsIgnoreCase("bug")){
                it.remove();
            }
        }
    }

    public static void removeBugWithCopy(ArrayList<String> list) {
        //write your code here
        ArrayList<String> listCopy = new ArrayList<>(list);
        for(String value: listCopy) {
            if(value.equalsIgnoreCase("bug")){
                list.remove(value);
            }
        }
    }
}
