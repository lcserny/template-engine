import engine.PlainText;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestPlainTextSegment
{
    @Test
    public void plainTextEvaluatesAsIs() throws Exception {
        Map<String, String> variables = new HashMap<>();
        String text = "abc def";
        Assert.assertEquals(text, new PlainText(text).evaluate(variables));
    }
}
