package org.sreekanth.sbsample.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sreekanth.sbsample.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);	
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionfactory.getCurrentSession();
		session.persist(p);
		logger.info("Person Saved Successfully, Person Details = "+p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionfactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, person details = "+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionfactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		return session.load(Person.class, new Integer(id));
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionfactory.getCurrentSession();
		Person p = session.load(Person.class, new Integer(id));
		if(null != p) {
			session.delete(p);
		}

	}

}
