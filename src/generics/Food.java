package generics;

public abstract class Food {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
