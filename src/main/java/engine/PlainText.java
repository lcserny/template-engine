package engine;

import java.util.Map;

public class PlainText implements Segment
{
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlainText plainText = (PlainText) o;

        return text != null ? text.equals(plainText.text) : plainText.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }
}
