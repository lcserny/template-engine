package engine;

public class MissingValueException extends RuntimeException
{
    public MissingValueException(String missingValue) {
        super("No value for ${" + missingValue + "}");
    }
}
