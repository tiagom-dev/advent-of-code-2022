package org.aoc2022;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {
    private static final List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        final File file = new File("src/main/resources/day1.txt");
        final List<String> data = Files.readAllLines(file.toPath());
        System.out.println(part1(data));
        System.out.println(part2());
    }

    private static int part1(List<String> lines) {
        int current = 0;

        for (String line : lines) {
            if (line.trim().isEmpty()) {
                results.add(current);
                current = 0;
            } else {
                current += Integer.parseInt(line.trim());
            }
        }
        Collections.sort(results);
        return Collections.max(results);
    }

    private static int part2() {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            result += Collections.max(results);
            results.remove(Collections.max(results));
        }
        return result;
    }
}
