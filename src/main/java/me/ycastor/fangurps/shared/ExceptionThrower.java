package me.ycastor.fangurps.shared;

import java.util.function.Function;

public class ExceptionThrower {
    public static <T extends RuntimeException, O> Function<T, O> rethrow() {
        return exception -> {
            throw exception;
        };
    }
}
