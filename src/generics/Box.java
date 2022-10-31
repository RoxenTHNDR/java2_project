package generics;

public class Box<T> {
    private T contents;

    public Box() {
    }

    public Box(T contents) {
        this.contents = contents;
    }

    public T get() {
        return contents;
    }

    public void add(T contents) {
        if(this.contents != null) {
            System.out.println("Cannot add " + contents.getClass().getSimpleName() + ". Box already contains " + this.contents.getClass().getSimpleName());
        } else {
            this.contents = contents;
            System.out.println(contents.getClass().getSimpleName() + " added.");
        }
    }

    public T remove() {
        if(this.contents == null) {
            System.out.println("There's nothing to remove");
            return null;
        } else {
            System.out.println(this.contents.getClass().getSimpleName() + " removed.");
            T temp = this.contents;
            this.contents = null;
            return temp;
        }
    }
}
