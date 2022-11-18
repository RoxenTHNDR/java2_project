package lambda;

public class ContainsAnalyzer implements MyAnalyzer<String> {
    @Override
    public boolean analyze(String search, String target) {
        return target.contains(search);
    }
}
