package org.aoc2022;

import org.aoc2022.utils.FileUtils;

import java.io.File;
import java.util.List;

class Day3 {

    private static int upperCaseDifferential = 38;
    private static int lowerCaseDifferential = 96;


    public static void main(String... args) throws Exception {
        File file = new File("src/main/resources/day3.txt");
        List<String> input = FileUtils.readFile(file);
        int score = input.stream()
                .map(Day3::game1)
                .mapToInt(Day3::getValue)
                .sum();
        System.out.printf("part 1: %d\n", score);


    }

    private static int getValue(int value) {
        return value;
    }

    static int game1(String line) {
        int value = 0;
        final int mid = line.length() / 2;
        String[] splited = {line.substring(0, mid), line.substring(mid)};
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {

                if (splited[0].charAt(i) == splited[1].charAt(j)) {
                    if (splited[0].charAt(i) < 97) {
                        value = splited[0].charAt(i) - upperCaseDifferential;
                    } else {
                        value = splited[0].charAt(i) - lowerCaseDifferential;
                    }
                }
            }
        }
        return value;
    }
}

