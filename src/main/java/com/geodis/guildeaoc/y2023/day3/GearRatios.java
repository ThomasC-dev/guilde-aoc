package com.geodis.guildeaoc.y2023.day3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.geodis.guildeaoc.Exercise;

public class GearRatios extends Exercise {

    public GearRatios() {
        super("src/main/java/com/geodis/guildeaoc/y2023/day3/input.txt");
    }

    protected void part1(List<String> lines) {
        Integer sum = 0;
        for(int i = 0; i < lines.size(); i++) {
            Matcher matcher = Pattern.compile("[0-9]+").matcher(lines.get(i));
            while (matcher.find()) {
                if (isNumberValid(matcher, lines, i)) {
                    sum += Integer.parseInt(matcher.group());
                }
            }
        }
        System.out.println("part1=" + sum);
    }

    protected void part2(List<String> lines) {
        
    }

    private boolean isNumberValid(Matcher matcher, List<String> lines, Integer currentIndex) {
        boolean formerLine = hasSymbol(lines.get(getLowerIndex(currentIndex - 1)), getLowerIndex(matcher.start() - 1), getUpperIndex(matcher.end(), 139));
        boolean currentLine = hasSymbol(lines.get(currentIndex), getLowerIndex(matcher.start() - 1), getUpperIndex(matcher.end(), 139));
        boolean nextLine = hasSymbol(lines.get(getUpperIndex(currentIndex + 1, lines.size() - 1)), getLowerIndex(matcher.start() - 1), getUpperIndex(matcher.end(), 139));
        return formerLine || currentLine || nextLine;
    }

    private boolean hasSymbol(String line, Integer startingIndex, Integer endingIndex) {
        for(int i = startingIndex; i <= endingIndex; i++) {
            if(String.valueOf(line.charAt(i)).matches("[^.\\d]")) {
                return true;
            }
        }
        return false;
    }

    private int getLowerIndex(int index) {
        return index >= 0 ? index : 0;
    }

    private int getUpperIndex(int index, int limit) {
        return index > limit ? limit : index;
    }
}
