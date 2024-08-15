import java.util.function.Function;

public class PrintOnConsole implements Function<String, Void> {

    @Override
    public Void apply(String s) {
        System.out.println(s);
        return null;
    }
}
