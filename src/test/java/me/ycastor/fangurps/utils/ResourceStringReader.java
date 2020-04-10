package me.ycastor.fangurps.utils;

import java.io.File;
import java.nio.file.Files;

public class ResourceStringReader {

    public String read(String fileName) {
        try {
            var url = this.getClass().getResource(fileName);
            var file = new File(url.getFile());
            return new String(Files.readAllBytes(file.toPath()));
        } catch (Exception ex) {
            throw new RuntimeException("Failed to read the resource " + fileName, ex);
        }
    }

}
