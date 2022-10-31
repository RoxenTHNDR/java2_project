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

        //Part 3
        MyStack<Character> charStack = new MyStack();
        charStack.push('J');
        charStack.push('A');
        charStack.push('V');
        charStack.push('A');
        charStack.swap('J','A');
        System.out.println(charStack.toString());
        System.out.println(charStack.peek());
        ch = charStack.pop();
        System.out.println(ch);
        System.out.println(charStack.peek());
        charStack.pop();
        System.out.println(charStack.toString());
        System.out.println(charStack.search('V'));
        System.out.println(charStack.search('J'));
        System.out.println(charStack.empty());
        charStack.pop();
        charStack.pop();
        // charStack.pop();
        // System.out.println(charStack.peek());
        System.out.println(charStack.empty());
        System.out.println();

        // Part 4
        MyStack<Food> foodStack = new MyStack<>();
        Apple apple = new Apple();
        foodStack.push(apple);
        Banana banana = new Banana();
        foodStack.push(banana);
        Potato potato = new Potato();
        foodStack.push(potato);
        Gala gala = new Gala();
        foodStack.push(gala);
        foodStack.swap(apple, gala);
        System.out.println(foodStack.toString());
        System.out.println(foodStack.peek());
        Food food = foodStack.pop();
        System.out.println(food);
        System.out.println(foodStack.peek());
        foodStack.pop();
        System.out.println(foodStack.toString());
        System.out.println(foodStack.search(potato));
        System.out.println(foodStack.search(gala));
        System.out.println(foodStack.empty());
        foodStack.pop();
        foodStack.pop();
        // foodStack.pop();
        // System.out.println(foodStack.peek());
        System.out.println(foodStack.empty());
        System.out.println();
    }
}
