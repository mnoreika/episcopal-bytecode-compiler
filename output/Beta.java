import java.util.Random;

public class Beta extends Distribution {
    private Normal normal;

    public Beta(Variable varA, Variable varB) {
        float a = (float) varA.getValue();
        float b = (float) varB.getValue();

        float mean = a / (a + b);
        float std = (float) Math.sqrt((a*b)/((Math.pow((a + b), 2)) * (a + b + 1)));

        this.normal = new Normal(new Variable(mean), new Variable(std));
    }

    public Variable sample() {
        return normal.sample();
    }

    public String toString() {
        return "Flip Distribution";
    }
}
