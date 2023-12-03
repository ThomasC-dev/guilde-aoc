package com.geodis.guildeaoc.y2023.day1;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.geodis.guildeaoc.Exercise;

public class Trebuchet extends Exercise {

    List<String> numbers = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public Trebuchet() {
        super("src/main/java/com/geodis/guildeaoc/y2023/day1/input.txt");
    }

    protected void part1(List<String> lines) {
        int sum = lines.stream()
            .mapToInt(this::getCalibrationValuesFromStr)
            .sum();
        System.out.println("part1=" + sum);
    }

    protected void part2(List<String> lines) {
        int sum = lines.stream()
            .map(this::insertNumbers)
            .mapToInt(this::getCalibrationValuesFromStr)
            .sum();
        System.out.println("part2=" + sum);
    }

    private int getCalibrationValuesFromStr(String line) {
        Matcher matcher = Pattern.compile("\\d").matcher(line);
        List<String> digits = matcher.results()
            .map(MatchResult::group)
            .toList();
        return Integer.parseInt(digits.get(0) + digits.get(digits.size() - 1));
    }

    private String insertNumbers(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        numbers.forEach(number -> {
            int index = stringBuilder.indexOf(number);
            while (index != -1) {
                stringBuilder.replace(index, index + number.length(), getMixedValue(number));
                index = stringBuilder.indexOf(number, index + getMixedValue(number).length());
            }
        });
        return stringBuilder.toString();
    }

    private String getMixedValue(String number) {
        return number.substring(0, number.length() - 1) + Integer.toString(numbers.indexOf(number) + 1) + number.substring(number.length() - 1);
    }
}