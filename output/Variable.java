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

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }


}
