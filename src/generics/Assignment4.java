package generics;

import java.util.*;

public class Assignment4 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('J');
        stack.push('A');
        stack.push('V');
        stack.push('A');
        System.out.println(stack.peek());
        Character ch = stack.pop();
        System.out.println(ch);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.search('V'));
        System.out.println(stack.search('J'));
        System.out.println(stack.empty());
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        // stack.pop();
        // System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println();
    }
}
