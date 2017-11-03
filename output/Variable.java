public class Variable {
    private Object value;

    public Variable(int value) {
        this.value = new Integer(value);
    }

    public Variable(float value) {
        this.value = new Float(value);
    }

    public Variable(boolean value) {
        this.value = new Boolean(value);
    }

    public Variable(String value) { this.value = value; }

    public Variable(Distribution dist) { this.value = dist; }

    public Variable sample() {
        Variable result = null;

        if (value instanceof Distribution) {
            result = ((Distribution) value).sample();
        } else {
            result = new Variable("Error: Only distributions can be samplied.");
        }

        return result;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
