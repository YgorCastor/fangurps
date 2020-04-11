package me.ycastor.fangurps.parsers;

public class ParsingException extends RuntimeException {

    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParsingException(Class<?> source, Class<?> destination, Throwable cause) {
        super("Failed to parse '" + source + "' to '" + destination, cause);
    }

    public ParsingException(Class<?> source, Class<?> destination) {
        this(source, destination, null);
    }

}
