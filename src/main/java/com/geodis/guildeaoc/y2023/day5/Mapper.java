package com.geodis.guildeaoc.y2023.day5;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mapper {
    
    private List<List<Long>> map;

    public Mapper(List<String> lines) {
        this.map = lines.stream()
            .filter(line -> line.matches("[\\d\\s]+"))
            .map(this::parseLine)
            .toList();
    }

    private List<Long> parseLine(String line) {
        Matcher matcher = Pattern.compile("\\d+").matcher(line);
        return matcher.results()
            .map(MatchResult::group)
            .map(Long::parseLong)
            .toList();
    }

    public Long processSeed(Long seed) {
        for(List<Long> line : this.map) {
            if (seed >= line.get(1) && seed < line.get(1) + line.get(2)) {
                return line.get(0) + (seed - line.get(1));
            }
        }
        return seed;
    }
}
