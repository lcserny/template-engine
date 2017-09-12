import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearningTest
{
    @Test
    public void testHowGroupCountWorks() throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "(nee)(dle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        Assert.assertEquals(2, matcher.groupCount());
    }

    @Test
    public void testFindStartAndEnd() throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "needle";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);

        Assert.assertTrue(matcher.find());
        Assert.assertEquals("Wrong start index of first match", 4, matcher.start());
        Assert.assertEquals("Wrong end index of first match", 10, matcher.end());

        Assert.assertTrue(matcher.find());
        Assert.assertEquals("Wrong start index of second match", 22, matcher.start());
        Assert.assertEquals("Wrong end index of second match", 28, matcher.end());

        Assert.assertFalse("Should not have any more matches", matcher.find());
    }
}
