package org.aoc2022.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileUtils {

    public static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }
}
