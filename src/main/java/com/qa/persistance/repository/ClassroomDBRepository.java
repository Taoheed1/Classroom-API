package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	// JOIN REQUIRED
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Trainee> traineeJSON = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(traineeJSON);
	}

	@Override
	@Transactional(REQUIRED)
	public String addNewTrainee(String trainee) {

		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(long traineeID) {
		Trainee traineeInDB = findTrainee(traineeID);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
			return "{\"message\": \"classroom sucessfully deleted\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClassroom(long classroomID, String trainee) {
		Classroom classroomInDB = findClassroom(classroomID);
		if (classroomInDB != null) {
			manager.persist(classroomInDB);
			manager.remove(classroomInDB);
			return "{\"message\": \"classroom details sucessfully updated\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(long traineeID, String trainee) {
		Trainee traineeInDB = findTrainee(traineeID);
		if (traineeInDB != null) {
			manager.persist(traineeInDB);
			manager.remove(traineeInDB);
			return "{\"message\": \"trainee details sucessfully updated\"}";
		}
		return "{\"message\": \"trainee does not exist\"}";
	}

	private Classroom findClassroom(Long classroomID) {
		return manager.find(Classroom.class, classroomID);
	}
	private Trainee findTrainee(long traineeID) {
		return manager.find(Trainee.class, traineeID);
	}

}
