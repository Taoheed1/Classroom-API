package com.qa.business.service;

public interface ClassroomService {

	String getAllTrainees();

	String addNewTrainee(String trainee);

	String deleteTrainee(long id);

	String updateClassroom(long id, String classroom);

	String updateTrainee(long id, String trainee);
}
