package lib;
import java.util.Random;

public class Bernouilli extends Distribution {
    private static Random randGenerator;
    private float p;

    public Bernouilli(Variable var) {
        randGenerator = new Random();
        p = (float) var.getValue();
    }

    public Variable sample() {
        int result;

        float genValue = randGenerator.nextFloat();

        if (genValue <= p)
            result = 1;
        else
            result = 0;

        return new Variable(result);
    }

    public String toString() {
        return "Bernouilli Distribution";
    }
}
