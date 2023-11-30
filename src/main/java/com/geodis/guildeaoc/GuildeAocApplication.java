package com.geodis.guildeaoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geodis.guildeaoc.y2022.day6.CommunicationSystemExercise;

@SpringBootApplication
public class GuildeAocApplication {

	public static void main(String[] args) {
		CommunicationSystemExercise exercise = new CommunicationSystemExercise();
		exercise.run();
	}

}
