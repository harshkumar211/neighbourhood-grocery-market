package org.sreekanth.sbsample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sreekanth.sbsample.dao.PersonDAO;
import org.sreekanth.sbsample.model.Person;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override	
	public void addPerson(Person p) {
		personDAO.addPerson(p);

	}

	@Override
	public void updatePerson(Person p) {
		personDAO.updatePerson(p);

	}

	@Override
	public List<Person> listPersons() {		
		return this.personDAO.listPersons();
	}

	@Override
	public Person getPersonById(int id) {
		return personDAO.getPersonById(id);
	}

	@Override
	public void removePerson(int id) {
		personDAO.removePerson(id);

	}

}
