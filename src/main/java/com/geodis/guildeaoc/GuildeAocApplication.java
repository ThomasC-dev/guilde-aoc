package com.geodis.guildeaoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geodis.guildeaoc.y2021.day6.LanternFishExercise;

@SpringBootApplication
public class GuildeAocApplication {

	public static void main(String[] args) {
		LanternFishExercise exercise = new LanternFishExercise();
		exercise.run();
	}

}
