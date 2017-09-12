package engine;

import java.util.Map;

public class Variable implements Segment
{
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        if (!variables.containsKey(name)) {
            throw new MissingValueException(name);
        }
        return variables.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        return name != null ? name.equals(variable.name) : variable.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
