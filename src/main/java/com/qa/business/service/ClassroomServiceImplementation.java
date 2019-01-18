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
	public String deleteTrainee(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteTrainee(id);
	}

	@Override
	public String updateClassroom(Long id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}

	@Override
	public String updateTrainee(Long id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

}
