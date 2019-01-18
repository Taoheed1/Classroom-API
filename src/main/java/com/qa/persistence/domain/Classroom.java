package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long classroomID;
	@Size(min = 2, max = 40)
	private String trainerName;
	private String trainee;

	public Classroom() {
	}

	public Classroom(long classroomID, String trainerName, String traineeName) {
		this.classroomID = classroomID;
		this.trainerName = trainerName;
		this.trainee = traineeName;
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

	public String getTrainee() {
		return trainee;
	}

	public void setTrainee(String traineeName) {
		this.trainee = traineeName;
	}
}
