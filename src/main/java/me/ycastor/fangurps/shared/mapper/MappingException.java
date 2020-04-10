package me.ycastor.fangurps.shared.mapper;

public class MappingException extends RuntimeException {

    public MappingException(Throwable cause) {
        super(cause);
    }

    public MappingException(Class<?> type, Throwable cause) {
        super(cause);
    }
}
