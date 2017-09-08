import engine.Template;
import org.junit.Assert;
import org.junit.Test;

public class TestTemplate
{
    @Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        Assert.assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void differentValue() throws Exception {
        Template template = new Template("Hi, ${name}");
        template.set("name", "someone else");
        Assert.assertEquals("Hi, someone else", template.evaluate());
    }

    @Test
    public void multipleVariables() throws Exception {
        Template template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
        Assert.assertEquals("1, 2, 3", template.evaluate());
    }
}
