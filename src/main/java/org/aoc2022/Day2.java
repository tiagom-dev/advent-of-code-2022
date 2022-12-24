package org.aoc2022;

import org.aoc2022.utils.FileUtils;

import java.io.File;
import java.util.List;

class Day2 {

    static int[] toWin = {1, 2, 0};  // For  0/Rock -> 1/Paper,    1/Paper -> 2/Scissors, 2/Scissors -> 0/Rock
    static int[] toLose = {2, 0, 1}; // For  0/Rock -> 2/Scissors, 1/Paper -> 0/Rock    , 2/Scissors -> 1/Paper

    public static void main(String... args) throws Exception {
        File file = new File("src/main/resources/day2.txt");
        List<String> input = FileUtils.readFile(file);
        int score = input.stream()
                .map(Day2::game1)
                .mapToInt(Day2::score).sum();
        System.out.printf("part 1: %d\n", score);

        int score2 = input.stream()
                .map(Day2::game2)
                .mapToInt(Day2::score).sum();
        System.out.printf("part 2: %d\n", score2);
    }

    static int[] game1(String line) {
        return new int[]{line.charAt(0) - 'A', line.charAt(2) - 'X'};
    }

    static int[] game2(String line) {
        int shape1 = line.charAt(0) - 'A';
        int shape2 = shape1;
        if (line.charAt(2) == 'X') {
            shape2 = toLose[shape1];
        } else if (line.charAt(2) == 'Z') {
            shape2 = toWin[shape1];
        }

        return new int[]{shape1, shape2};
    }

    static int score(int[] game) {
        int shapeScore = game[1] + 1;
        return shapeScore + gameScore(game[0], game[1]);
    }

    static int gameScore(int shape1, int shape2) {
        if (toWin[shape1] == shape2) return 6;
        if (toLose[shape1] == shape2) return 0;
        else return 3;
    }
}

