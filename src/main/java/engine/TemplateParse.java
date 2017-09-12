package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParse
{
    public List<Segment> parseSegments(String template) {
        List<Segment> segments = new ArrayList<>();
        List<String> strings = parse(template);
        for (String string : strings) {
            if (isVariable(string)) {
                String name = string.substring(2, string.length() - 1);
                segments.add(new Variable(name));
            } else {
                segments.add(new PlainText(string));
            }
        }
        return segments;
    }

    public List<String> parse(String template) {
        List<String> segments = new ArrayList<>();
        int index = collectSegments(segments, template);
        addTail(segments, template, index);
        addEmptyStringIfTemplateWasEmpty(segments);
        return segments;
    }

    private boolean isVariable(String segment) {
        return segment.startsWith("${") && segment.endsWith("}");
    }

    private void addEmptyStringIfTemplateWasEmpty(List<String> segments) {
        if (segments.isEmpty()) {
            segments.add("");
        }
    }

    private void addTail(List<String> segments, String template, int index) {
        if (index < template.length()) {
            segments.add(template.substring(index));
        }
    }

    private int collectSegments(List<String> segments, String source) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
        Matcher matcher = pattern.matcher(source);
        int index = 0;
        while (matcher.find()) {
            addPrecedingPlainText(segments, source, matcher, index);
            addVariable(segments, source, matcher);
            index = matcher.end();
        }
        return index;
    }

    private void addVariable(List<String> segments, String source, Matcher matcher) {
        segments.add(source.substring(matcher.start(), matcher.end()));
    }

    private void addPrecedingPlainText(List<String> segments, String source, Matcher matcher, int index) {
        if (index != matcher.start()) {
            segments.add(source.substring(index, matcher.start()));
        }
    }
}
