package com.geodis.guildeaoc.y2023.day2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public class Game {

    private int id;
    private List<Draw> draws;

    public Game(String line) {
        this.id = this.buildId(line);
        this.draws = this.buildDraws(line);
    }

    public boolean isValid() {
        return this.draws.stream()
            .allMatch(this::isDrawValid);
    }

    private boolean isDrawValid(Draw draw) {
        switch (draw.getKey()) {
            case "red":
                return draw.getValue() <= 12;
            case "green":
                return draw.getValue() <= 13;
            case "blue":
                return draw.getValue() <= 14;
            default:
                return false;
        }
    }

    private int buildId(String line) {
        Matcher matcher = Pattern.compile("(?<=Game )[0-9]+").matcher(line);
        matcher.find();
        return Integer.parseInt(matcher.group());
    }
    
    private List<Draw> buildDraws(String line) {
        String drawsStr = line.split(": ")[1];
        return Arrays.asList(drawsStr.split("(, )|(; )")).stream()
            .map(draw -> draw.split("\\s"))
            .map(draw -> new Draw(draw[1], Integer.parseInt(draw[0])))
            .toList();
    }

    public int getMinimalSetValue() {
        int red = this.getMinimalColorSet("red");
        int green = this.getMinimalColorSet("green");
        int blue = this.getMinimalColorSet("blue");
        return red * green * blue;
    }

    private int getMinimalColorSet(String color) {
        return this.draws.stream()
            .filter(draw -> draw.getKey().equals(color))
            .mapToInt(Draw::getValue)
            .max()
            .orElse(0);
    }
}
