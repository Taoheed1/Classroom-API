package com.qa.business.service;

public interface ClassroomService {

	String getAllTrainees();

	String addNewTrainee(String trainee);

	String deleteTrainee(long traineeID);

	String updateClassroom(long classroomID, String classroom);

	String updateTrainee(long traineeID, String trainee);
}
