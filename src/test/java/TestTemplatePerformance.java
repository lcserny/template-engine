import engine.Template;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTemplatePerformance
{
    private Template template;

    @Before
    public void setUp() throws Exception {
        String text = "";
        for (int i = 1; i <= 20; i++) {
            text += "Something here for text - ${" + i + "} ";
        }
        template = new Template(text);
        template.set("1", "helloworld-one");
        template.set("2", "helloworld-two");
        template.set("3", "helloworld-three");
        template.set("4", "helloworld-four");
        template.set("5", "helloworld-five");
        template.set("6", "helloworld-six");
        template.set("7", "helloworld-seven");
        template.set("8", "helloworld-eight");
        template.set("9", "helloworld-nine");
        template.set("10", "helloworld-ten");
        template.set("11", "helloworld-eleven");
        template.set("12", "helloworld-twelve");
        template.set("13", "helloworld-thirteen");
        template.set("14", "helloworld-fourteen");
        template.set("15", "helloworld-fifteen");
        template.set("16", "helloworld-sixteen");
        template.set("17", "helloworld-seventeen");
        template.set("18", "helloworld-eighteen");
        template.set("19", "helloworld-nineteen");
        template.set("20", "helloworld-twenty");
    }

    @Test
    public void templateWith100WordsAnd20Variables() throws Exception {
        long expected = 200L;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        Assert.assertTrue("Rendering the template took " + time + "ms, while the target was " + expected + "ms",
                time <= expected);
    }
}
