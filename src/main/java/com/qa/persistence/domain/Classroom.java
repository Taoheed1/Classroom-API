package com.qa.persistence.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Classroom {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long classroomID;
	@Size(min = 2, max = 40)
	private String trainerName;
	//@OneToMany(fetch=FetchType.EAGER) List<Trainee> traineeName;
	@OneToMany(mappedBy = "classroom") Set <Trainee> trainees;
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
