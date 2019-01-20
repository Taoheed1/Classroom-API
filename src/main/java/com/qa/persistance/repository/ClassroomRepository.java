package com.qa.persistance.repository;

public interface ClassroomRepository {

	String getAllTrainees();

	String addNewTrainee(String trainee);

	String deleteTrainee(long id);

	String updateClassroom(long id, String trainee);
	
	String updateTrainee(long id, String trainee);
}
