import engine.PlainText;
import engine.Segment;
import engine.TemplateParse;
import engine.Variable;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestTemplateParse
{
    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        List<String> segments = parse("");
        assertSegments(segments, "");
    }

    @Test
    public void templateWithOnlyPlainText() throws Exception {
        List<String> segments = parse("only plain text");
        assertSegments(segments, "only plain text");
    }

    @Test
    public void parsingMultipleVariables() throws Exception {
        List<String> segments = parse("${a}:${b}:${c}");
        assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
    }

    @Test
    public void parsingTemplateIntoSegmentObjects() throws Exception {
        TemplateParse parser = new TemplateParse();
        List<Segment> segments = parser.parseSegments("a ${b} c ${d}");
        assertSegments(segments, new PlainText("a "), new Variable("b"),
                new PlainText(" c "), new Variable("d"));
    }

    private void assertSegments(List<?> actual, Object... expected) {
        Assert.assertEquals("Number of segments doesn't match", expected.length, actual.size());
        Assert.assertEquals(Arrays.asList(expected), actual);
    }

    private List<String> parse(String template) {
        return new TemplateParse().parse(template);
    }
}
