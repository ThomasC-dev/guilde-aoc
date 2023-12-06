package com.geodis.guildeaoc.y2023.day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.geodis.guildeaoc.Exercise;

public class Scratchcards extends Exercise {

    public Scratchcards() {
        super("src/main/java/com/geodis/guildeaoc/y2023/day4/input.txt");
    }

    @Override
    protected void part1(List<String> lines) {
        int sum = lines.stream()
            .mapToInt(this::getDrawResult)
            .sum();
        System.out.println("part1=" + sum);
    }

    @Override
    protected void part2(List<String> lines) {
        Integer sum = 0;
        Map<Integer, Integer> nbCopyCard = new HashMap<>();

        for (String line : lines) {
            Matcher matcher = Pattern.compile("Card\\s+(\\d+(?:\\s+\\d+)*)").matcher(line);
            matcher.find();
            int cardNumber = Integer.parseInt(matcher.group(1));
            String[] draws = line.split(":")[1].split("[|]");
            List<String> secondDraw = Arrays.asList(draws[1].split("\\s"));
            double count = Arrays.stream(draws[0].split("\\s"))
                .filter(Predicate.not(String::isBlank))
                .filter(secondDraw::contains)
                .count();

            for(int i = cardNumber + 1; i <= cardNumber + (int) count; i++) {
                if (nbCopyCard.containsKey(i)) {
                    nbCopyCard.put(i , nbCopyCard.get(i) + 1);
                } else {
                    nbCopyCard.put(i, 1);
                }
            }

            if(nbCopyCard.containsKey(cardNumber)) {
                sum += ((int) Math.pow(2, count - 1) * (nbCopyCard.get(cardNumber) + 1));
            } else {
                sum += (int) Math.pow(2, count - 1);
            }
        }
        System.out.println("part2=" + sum);
    }
    
    private int getDrawResult(String line) {
            String[] draws = line.split(":")[1].split("[|]");
            List<String> secondDraw = Arrays.asList(draws[1].split("\\s"));
            double count = Arrays.stream(draws[0].split("\\s"))
                .filter(Predicate.not(String::isBlank))
                .filter(secondDraw::contains)
                .count();
            return (int) Math.pow(2, count - 1);
    }
}
