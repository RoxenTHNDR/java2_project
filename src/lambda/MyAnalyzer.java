package lambda;

public interface MyAnalyzer<T> {
    boolean analyze(T search, T target);
}
