package me.ycastor.fangurps.parsers;

import cyclops.control.Either;

public interface Parser<S, D> {
    Either<ParsingException, D> parse(S source);
}
