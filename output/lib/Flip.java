package lib;

import java.util.Random;

public class Flip extends Distribution {
    private static Random randGenerator;
    private float p;

    public Flip(Variable var) {
        randGenerator = new Random();
        p = (float) var.getValue();
    }

    public Variable sample() {
        boolean result;

        double genValue = randGenerator.nextDouble();

        if (genValue <= p)
            result = true;
        else
            result = false;

        return new Variable(result);
    }

    public String toString() {
        return "Flip Distribution";
    }
}
