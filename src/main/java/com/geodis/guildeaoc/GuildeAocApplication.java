package com.geodis.guildeaoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geodis.guildeaoc.y2023.day3.GearRatios;

@SpringBootApplication
public class GuildeAocApplication {

	public static void main(String[] args) {
		Exercise exercise = new GearRatios();
		exercise.run();
	}

}
