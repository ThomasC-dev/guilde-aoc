package com.geodis.guildeaoc.y2023.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.geodis.guildeaoc.Exercise;

public class SeedFertilizer extends Exercise {

    private List<String> lines;

    public SeedFertilizer() {
        super("src/main/java/com/geodis/guildeaoc/y2023/day5/input.txt");
    }

    @Override
    protected void part1(List<String> lines) {
        this.lines = lines;

        List<Long> seeds = getSeeds();
        List<Mapper> mappers = getMappers();

        Long min = seeds.stream()
            .map(seed -> new Seed(seed, mappers))
            .mapToLong(Seed::processLifeCycle)
            .min()
            .orElse(-1);
        System.out.println("part1=" + min);
    }

    @Override
    protected void part2(List<String> lines) {
        this.lines = lines;

        List<Long> seeds = getSeeds();
        List<Mapper> mappers = getMappers();

        Long min = Long.MAX_VALUE;

        for(int i = 0; i < seeds.size(); i+=2) {
            for (int j = 0; j < seeds.get(i + 1); j++) {
                Seed seed = new Seed(seeds.get(i) + j, mappers);
                Long locationValue = seed.processLifeCycle();
                if (locationValue < min) {
                    min = locationValue;
                }
            }
        }
       
        System.out.println("part2=" + min);
    }

    private List<Long> getSeeds() {
        List<Long> seeds = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            Matcher matcher = Pattern.compile("\\d+").matcher(currentLine);
            List<Long> matchs = matcher.results()
                .map(t -> t.group())
                .map(Long::parseLong)
                .toList();
            seeds.addAll(matchs);

            if (lines.get(i+1).isBlank()) {
                for (int j = i+1; j >= 0; j--) {
                    lines.remove(j);
                }
                return seeds;
            }
        }
        return seeds;
    }

    private List<Mapper> getMappers() {
        List<String> currentLines = new ArrayList<>();
        List<Mapper> mappers = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (!Pattern.matches("[^\\d\\s]", lines.get(i))) {
                currentLines.add(lines.get(i));
                if ((i + 1) == lines.size() || lines.get(i+1).isBlank()) {
                    mappers.add(new Mapper(currentLines));
                    currentLines = new ArrayList<>();
                }
            }
        }
        return mappers;
    }

    
}