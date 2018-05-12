
/**
 * 
 */
/**
 * @author biraj
 *
 */
module dataaccess {
	exports com.dataaccess.entities;
	exports  com.dataaccess.repository.api;
	provides com.dataaccess.repository.api.AppointmentRepository with com.dataaccess.repository.impl.AppointmentRepositoryImpl;
	provides com.dataaccess.repository.api.StudentRepository with com.dataaccess.repository.impl.StudentRepositoryImpl;
	provides com.dataaccess.repository.api.CounselorRepository with com.dataaccess.repository.impl.CounselorRepositoryImpl;

	
	requires hibernate.jpa;
	requires spring.tx;
	requires jackson.annotations;
	requires spring.context;

}