package com.qa.business.service;

public interface ClassroomService {

	String getAllTrainees();

	String addNewTrainee(String trainee);

	String deleteTrainee(Long id);

	String updateClassroom(Long id, String classroom);

	String updateTrainee(Long id, String trainee);
}
