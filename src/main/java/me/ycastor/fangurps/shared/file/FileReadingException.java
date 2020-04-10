package me.ycastor.fangurps.shared.file;

public class FileReadingException extends RuntimeException {
    public FileReadingException(Throwable cause) {
        super("Failed to open file", cause);
    }
}
