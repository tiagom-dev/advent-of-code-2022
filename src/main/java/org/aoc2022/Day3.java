package org.aoc2022;

import org.aoc2022.utils.FileUtils;

import java.io.File;
import java.util.List;

class Day3 {

    private static final int upperCaseDifferential = 38;
    private static final int lowerCaseDifferential = 96;


    public static void main(String... args) throws Exception {
        File file = new File("src/main/resources/day3.txt");
        List<String> input = FileUtils.readFile(file);
        int score = input.stream()
                .map(Day3::game1)
                .mapToInt(Day3::getValue)
                .sum();
        System.out.printf("part 1: %d\n", score);
        System.out.printf("part 2: %d\n", game2(input));


    }

    private static int getValue(int value) {
        return value;
    }

    static int game1(String line) {
        int value = 0;
        boolean found = false;
        final int mid = line.length() / 2;
        String[] splited = {line.substring(0, mid), line.substring(mid)};
        for (int i = 0; i < mid; i++) {
            if (!found) {
                for (int j = 0; j < mid; j++) {

                    if (splited[0].charAt(i) == splited[1].charAt(j)) {
                        value = getCharValue(splited[0].charAt(i));
                        found = true;
                    }
                }
            }
        }
        return value;
    }

    private static int getCharValue(char charInput) {
        int value;
        if (charInput < 97) {
            value = charInput - upperCaseDifferential;
        } else {
            value = charInput - lowerCaseDifferential;
        }
        return value;
    }

    private static int game2(List<String> data) {
        int result = 0;

        for (int i = 0; i < data.size() - 2; i += 3) {
            boolean found = false;

            char[] currentLine = data.get(i).toCharArray();
            char[] secondLine = data.get(i + 1).toCharArray();
            char[] thirdLine = data.get(i + 2).toCharArray();

            for (char firstChar :
                    currentLine) {
                if (!found)
                    for (char secondChar :
                            secondLine) {
                        if (firstChar == secondChar && !found) {
                            for (char thirdChar :
                                    thirdLine) {
                                if (firstChar == thirdChar && !found) {
                                    result += getCharValue(firstChar);
                                    found = true;
                                }
                            }
                        }
                    }
            }
        }
        return result;
    }

}