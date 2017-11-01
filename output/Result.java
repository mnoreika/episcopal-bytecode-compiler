import java.util.Random;

public class Result {
    private Object value;

    public Result(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}