import java.util.Random;

public class Distributions {
    private static Random randGenerator = new Random();

    public static int Bernoulli(float p) {
        int result;

        float genValue = randGenerator.nextFloat();

        if (genValue <= p)
            result =  1;
        else
            result = 0;

        return result;
    }

    public static float Beta(int a, int b) {
        int normConstant = gamma(a + b) / (gamma(a) * gamma(b));
        double genValue = randGenerator.nextFloat();

        double result = Math.pow(genValue, (a - 1)) * Math.pow((1 - genValue), (b - 1)) * normConstant;

        return (float) result;
    }

    public static boolean Flip(float p) {
        boolean result;

        double genValue = randGenerator.nextDouble();

        if (genValue <= p)
            result = true;
        else
            result = false;

        return result;
    }

    public static float Normal(float mean, float standardDeviation) {
        return  (float) randGenerator.nextGaussian() * standardDeviation + mean;
    }

    private static int gamma(int n) {
        int result = 1;

        for (int i = 1; i < n; i++) {
            result *= i;
        }

        return result;
    }


}
