package en.codegym.task.pro.task13.task1302;

import java.util.*;

import static java.util.Arrays.asList;

/*
Verifying existence
*/

public class Solution {
    public static Set<String> languagesIKnow = new HashSet<>(asList("HTML CSS JavaScript SQL Java Python".split(" ")));

    public static void checkWords(String word) {
        //write your code here
            System.out.println(String.format("The word %s is%s in the set", word,languagesIKnow.contains(word) ? "" : " not"));
    }

    public static void main(String[] args) {
        checkWords("C#");
        checkWords("Java");
    }
}

