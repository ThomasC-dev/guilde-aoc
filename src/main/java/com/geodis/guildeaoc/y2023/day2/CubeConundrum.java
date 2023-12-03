package com.geodis.guildeaoc.y2023.day2;

import java.util.List;

import com.geodis.guildeaoc.Exercise;

public class CubeConundrum extends Exercise {

    public CubeConundrum() {
        super("src/main/java/com/geodis/guildeaoc/y2023/day2/input.txt");
    }

    protected void part1(List<String> lines) {
        int sum = lines.stream()
            .map(Game::new)
            .filter(Game::isValid)
            .mapToInt(Game::getId)
            .sum();
        System.out.println("part1=" + sum);
    }

    protected void part2(List<String> lines) {
        int sum = lines.stream()
            .map(Game::new)
            .mapToInt(Game::getMinimalSetValue)
            .sum();
        System.out.println("part2=" + sum);
    }
}
