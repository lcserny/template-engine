import engine.MissingValueException;
import engine.Variable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestVariableSegment
{
    private Map<String, String> variables;

    @Before
    public void setUp() throws Exception {
        variables = new HashMap<>();
    }

    @Test
    public void variableEvaluatesToItsValue() throws Exception {
        String name = "myVar";
        String value = "myValue";
        variables.put(name, value);
        Assert.assertEquals(value, new Variable(name).evaluate(variables));
    }

    @Test
    public void missingVariablesRaisesException() throws Exception {
        String name = "myVar";
        try {
            new Variable(name).evaluate(variables);
            Assert.fail("Missing variable value should raise an exception");
        } catch (MissingValueException e) {
            Assert.assertEquals("No value for ${" + name + "}", e.getMessage());
        }
    }
}
