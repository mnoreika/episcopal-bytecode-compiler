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

    public static Variable Beta(Variable a, Variable b) {
        float aValue = (Float) a.getValue();
        float bValue = (Float) b.getValue();

        float mean = aValue / (aValue + bValue);
        float std = (float) Math.sqrt((aValue*bValue)/((Math.pow((aValue + bValue), 2)) * (aValue + bValue + 1)));

        return Normal(new Variable(mean), new Variable(std));
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

    public static Variable Normal(Variable a, Variable b) {
        float mean = (float) a.getValue();
        float std = (float) b.getValue();

        return  new Variable((float) randGenerator.nextGaussian() * std + mean);
    }
}
