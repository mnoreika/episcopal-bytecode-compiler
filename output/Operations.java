public class Operations {

    public static Variable add(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Integer && valueB instanceof Integer) {
            result = new Variable((Integer) valueA + (Integer) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Float) {
            result = new Variable((Float) valueA + (Float) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Integer) {
            result = new Variable((Float) valueA + (Integer) valueB);
        }
        else if (valueA instanceof Integer && valueB instanceof Float) {
            result = new Variable((Integer) valueA + (Float) valueB);
        }

        return result;
    }

    public static Variable equals(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = new Variable(valueA.equals(valueB));

        return result;
    }

    public static int getObservResult(Variable bool) {
        return (Boolean) bool.getValue() ? 0 : 1;
    }

    public static Variable makeFailObject() {
        return new Variable("Observation failed.");
    }
}
