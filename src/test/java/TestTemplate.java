import engine.MissingValueException;
import engine.Template;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestTemplate
{
    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");;
        template.set("two", "2");;
        template.set("three", "3");;
    }

    @Test
    public void multipleVariables() throws Exception {
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {
        template.set("doesnotexist", "hi");
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void missingValueRaisesException() throws Exception {
        try {
            new Template("${foo}").evaluate();
            Assert.fail("Missing variable value should raise an exception");
        } catch (MissingValueException e) {
            Assert.assertEquals("No value for ${foo}", e.getMessage());
        }
    }

    @Test
    public void variablesGetProcessedJustOnce() throws Exception {
        template.set("one", "${one}");
        template.set("two", "${three}");
        template.set("three", "${two}");
        assertTemplateEvaluatesTo("${one}, ${three}, ${two}");
    }

    private void assertTemplateEvaluatesTo(String expected) {
        Assert.assertEquals(expected, template.evaluate());
    }
}
