package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="trainee")
public class Trainee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	
	private long traineeID;
	@Size(min=2, max=40)
	//@ManyToOne Classroom classroom;
	@JoinColumn(name="traineeName")
	private String traineeName;

	public Trainee() {
	}

	public Trainee(long traineeID, String traineeName) {
		
		this.traineeID = traineeID;
		this.traineeName = traineeName;

	}

	public long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
}
