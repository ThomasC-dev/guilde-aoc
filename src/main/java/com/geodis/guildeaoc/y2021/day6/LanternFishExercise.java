package com.geodis.guildeaoc.y2021.day6;

import java.util.Arrays;
import java.util.List;

import com.geodis.guildeaoc.utils.FileUtils;

public class LanternFishExercise {

	public void run() {
		List<String> lines = FileUtils.parseFile("src/main/java/com/geodis/guildeaoc/y2021/day6/input.txt");
		List<String> inputs = Arrays.asList(lines.get(0).split(","));
		this.part1(inputs);
	}

	private void part1(List<String> inputs) {
		List<LanternFish> lanternFishs = inputs.stream()
			.map(Integer::parseInt)
			.map(LanternFish::new)
			.toList();

		for(int i = 0; i < 256; i++) {
			lanternFishs.forEach(LanternFish::iterate);
		}

		long count = lanternFishs.stream()
			.mapToInt(LanternFish::getLineageCount)
			.sum();

		System.out.println("count=" + count);
	}

}