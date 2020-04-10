package me.ycastor.fangurps.shared.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Singleton;

import cyclops.control.Either;
import cyclops.control.LazyEither;
import cyclops.control.Try;

@Singleton
public final class FileReader {

    private final ExecutorService executorService;

    @Inject
    public FileReader(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public LazyEither<FileReadingException, String> loadFile(Path path) {
        final var content = LazyEither.<String>either();
        executorService.execute(() -> read(path).fold(content::completeExceptionally, content::complete));
        return content.mapLeft(FileReadingException::new);
    }

    private Either<IOException, String> read(Path path) {
        return Try.withCatch(() -> {
            var content = Files.readAllBytes(path);
            return new String(content);
        }, IOException.class).asEither();
    }
}
