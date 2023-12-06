package com.geodis.guildeaoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geodis.guildeaoc.y2023.day4.Scratchcards;
import com.geodis.guildeaoc.y2023.day5.SeedFertilizer;

@SpringBootApplication
public class GuildeAocApplication {

	public static void main(String[] args) {
		Exercise exercise = new SeedFertilizer();
		exercise.run();
	}

}
