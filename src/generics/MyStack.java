package generics;

import java.util.*;

public class MyStack<T> implements PushPop {
    private ArrayList<T> stack;

    // Creates an empty Stack
    public MyStack() {
        stack = new ArrayList<>();
    }

    // Tests if this stack is empty.
    public boolean empty() {
        return stack.size() == 0;
    }

    // Looks at the object at the top of this stack without removing it from the stack.
    public T peek() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

     //Removes the object at the top of this stack and returns that object as the value of this function.
    public T pop() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    // Pushes an item onto the top of this stack.
    public T push(Object item) {
        stack.add((T) item);
        return (T) item;
    }

    // Returns the 1-based position where an object is on this stack.
    public int search(T o) {
        int i = stack.lastIndexOf(o);
        if (i >= 0) {
            return stack.size() - i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public void swap(T obj1, T obj2) {
        int loc1 = stack.size() - search(obj1);
        int loc2 = stack.size() - search(obj2);
        // Your code goes here
        T temp = stack.get(loc1);
        stack.set(loc1, stack.get(loc2));
        stack.set(loc2, temp);
    }
}
