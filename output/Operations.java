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

    public static Variable mult(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Integer && valueB instanceof Integer) {
            result = new Variable((Integer) valueA * (Integer) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Float) {
            result = new Variable((Float) valueA * (Float) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Integer) {
            result = new Variable((Float) valueA * (Integer) valueB);
        }
        else if (valueA instanceof Integer && valueB instanceof Float) {
            result = new Variable((Integer) valueA * (Float) valueB);
        }

        return result;
    }

    public static Variable sub(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Integer && valueB instanceof Integer) {
            result = new Variable((Integer) valueA - (Integer) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Float) {
            result = new Variable((Float) valueA - (Float) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Integer) {
            result = new Variable((Float) valueA - (Integer) valueB);
        }
        else if (valueA instanceof Integer && valueB instanceof Float) {
            result = new Variable((Integer) valueA - (Float) valueB);
        }

        return result;
    }

    public static Variable div(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Integer && valueB instanceof Integer) {
            result = new Variable((Integer) valueA / (Integer) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Float) {
            result = new Variable((Float) valueA / (Float) valueB);
        }
        else if (valueA instanceof Float && valueB instanceof Integer) {
            result = new Variable((Float) valueA / (Integer) valueB);
        }
        else if (valueA instanceof Integer && valueB instanceof Float) {
            result = new Variable((Integer) valueA / (Float) valueB);
        }

        return result;
    }

    public static Variable greater(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Number && valueB instanceof Number) {
            result = new Variable(((Number) valueA).doubleValue() > ((Number) valueB).doubleValue());
        }

        return result;
    }

    public static Variable less(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Number && valueB instanceof Number) {
            result = new Variable(((Number) valueA).doubleValue() < ((Number) valueB).doubleValue());
        }

        return result;
    }

    public static Variable and(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Boolean && valueB instanceof Boolean) {
            result = new Variable(((Boolean) valueA) && ((Boolean) valueB));
        }

        return result;
    }

    public static Variable or(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        Variable result = null;

        if (valueA instanceof Boolean && valueB instanceof Boolean) {
            result = new Variable(((Boolean) valueA) || ((Boolean) valueB));
        }

        return result;
    }


    public static Variable equals(Variable a, Variable b) {
        Object valueA = a.getValue();
        Object valueB = b.getValue();

        return new Variable(valueA.equals(valueB));
    }

    public static int getObservResult(Variable bool) {
        return (Boolean) bool.getValue() ? 0 : 1;
    }

    public static Variable makeFailObject() {
        return new Variable("Observation failed.");
    }
}
