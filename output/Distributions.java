import java.util.Random;

public class Distributions {
    private static Random randGenerator = new Random();

    public static Variable Bernoulli(Variable p) {
        float pValue = (Float) p.getValue();
        int result;

        float genValue = randGenerator.nextFloat();

        if (genValue <= pValue)
            result = 1;
        else
            result = 0;

        return new Variable(result);
    }

    public static Variable Beta(int a, int b) {
        float mean = a / (a + b);
        float std = (float) Math.sqrt((a*b)/((Math.pow((a + b), 2)) * (a + b + 1)));

        return Normal(mean, std);
    }

    public static Variable Flip(Variable p) {
        float pValue = (Float) p.getValue();
        boolean result;

        double genValue = randGenerator.nextDouble();

        if (genValue <= pValue)
            result = true;
        else
            result = false;

        return new Variable(result);
    }

    public static Variable Normal(float mean, float standardDeviation) {
        return  new Variable((float) randGenerator.nextGaussian() * standardDeviation + mean);
    }
}
