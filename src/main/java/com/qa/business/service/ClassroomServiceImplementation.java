package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.repository.ClassroomRepository;

public class ClassroomServiceImplementation implements ClassroomService {

	@Inject
	private ClassroomRepository repo;

	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	@Override
	public String addNewTrainee(String trainee) {
		return repo.addNewTrainee(trainee);
	}

	@Override
	public String deleteTrainee(long traineeID) {
		return repo.deleteTrainee(traineeID);
	}

	@Override
	public String updateClassroom(long classroomID, String classroom) {
		return repo.updateClassroom(classroomID, classroom);
	}

	@Override
	public String updateTrainee(long traineeID, String trainee) {
		return repo.updateTrainee(traineeID, trainee);
	}

}
