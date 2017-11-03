package lib;

import java.util.Random;

public class Normal extends Distribution {
    private static Random randGenerator;
    private float mean;
    private float std;

    public Normal(Variable a, Variable b) {
        mean = (float) a.getValue();
        std = (float) b.getValue();
        randGenerator = new Random();
    }

    public Variable sample() {
        return  new Variable((float) randGenerator.nextGaussian() * std + mean);
    }

    public String toString() {
        return "Normal Distribution";
    }
}
