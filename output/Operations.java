public class Operations {
    public static Result add(int a, float b) {
        float sum = a + b;

        return new Result(sum);
    }

    public static Result add(float a, int b) {
        float sum = a + b;

        return new Result(sum);
    }

}
