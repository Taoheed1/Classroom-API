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

	//all the methods dealing with the trainee entity will need to explicitly call trainee objects as they are the owners of their own data (take control off your own future trainee san)
	@Override
	@Transactional(REQUIRED)
	// JOIN REQUIRED
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classroom = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classroom);
	}

	@Override
	@Transactional(REQUIRED)
	public String addNewTrainee(String trainee) {

		Classroom aClassroom = util.getObjectForJSON(trainee, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
			return "{\"message\": \"classroom sucessfully deleted\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String trainee) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.persist(classroomInDB);
			manager.remove(classroomInDB);
			return "{\"message\": \"classroom details sucessfully updated\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String trainee) {
		Trainee traineeInDB = findTrainee(id);
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
	private Trainee findTrainee(Long traineeID) {
		return manager.find(Trainee.class, traineeID);
	}

}
