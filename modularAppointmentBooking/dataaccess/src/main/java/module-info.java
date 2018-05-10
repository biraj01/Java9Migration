/**
 * 
 */
/**
 * @author biraj
 *
 */
module dataaccess {
	exports com.dataaccess.entities;
	exports com.dataaccess.repository;
	requires hibernate.jpa;
	requires jackson.annotations;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
}