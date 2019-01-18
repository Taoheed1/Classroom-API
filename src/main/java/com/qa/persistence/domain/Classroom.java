package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long classroomID;
	@Size(min = 2, max = 40)
	private String trainerName;
	private String trainees;

	public Classroom() {
	}

	public Classroom(long classroomID, String trainerName, String trainees) {
		this.classroomID = classroomID;
		this.trainerName = trainerName;
		this.trainees = trainees;
	}

	public long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainees() {
		return trainees;
	}

	public void setTrainees(String trainees) {
		this.trainees = trainees;
	}
}
