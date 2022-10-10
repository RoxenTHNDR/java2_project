package en.codegym.task.pro.task13.task1313;

/*
StringLinkedList
*/

public class Solution {

    public static void main(String[] args) {
        StringsLinkedList stringsLinkedList = new StringsLinkedList();
        stringsLinkedList.add("Pizza");
        stringsLinkedList.add("Chicken Wings");
        stringsLinkedList.add("French Fries");
        stringsLinkedList.add(1, "Sushi");
        stringsLinkedList.printAll();
    }
}