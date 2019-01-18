package com.qa.persistance.repository;

public interface ClassroomRepository {

	String getAllTrainees();

	String addNewTrainee(String trainee);

	String deleteTrainee(Long id);

	String updateClassroom(Long id, String trainee);
	
	String updateTrainee(Long id, String trainee);
}
