package ms.test.first.ms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ms.test.first.ms.controllers.parameters.PersonParameters;
import ms.test.first.ms.entities.Person;
import ms.test.first.ms.repositories.PersonRepository;
import ms.test.first.ms.services.IPersonService;

@Service
public class PersonService implements IPersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> findAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public Person addPerson(PersonParameters personParameters) {
		return personRepository.save(new Person(personParameters.getFirstName(), personParameters.getLastName()));
	}

	@Override
	public List<Person> find(PersonParameters personParameters) {
		List<Person> list = null;
		if(personParameters.getFirstName() != null) {
			Person person = personRepository.findByLastNameAndFirstName(personParameters.getLastName(), personParameters.getFirstName());
			if(person != null) {
				list = new ArrayList<Person>();
				list.add(person);
			}
		}else if(personParameters.getLastName() != null){
			list = personRepository.findByLastName(personParameters.getLastName());
		}
		return list;
	}

	@Override
	public ResponseEntity<String> removePerson(PersonParameters personParameters) {
		List<Person> persons = this.find(personParameters);
		ResponseEntity<String> response = null;
		if(persons.size() == 1) {
			personRepository.delete(persons.get(0));
			personRepository.flush();
			response = ResponseEntity.ok(personParameters.getFirstName() + " " + personParameters.getLastName() + " à été correctement supprimé !");
		}else if(persons.isEmpty()){
			response = ResponseEntity.badRequest().body("La personne n'existe pas !");
		}else {
			response = ResponseEntity.badRequest().body("Merci de remplir le nom et prénom de la personne !");
		}
		
		return response;
	}

}
