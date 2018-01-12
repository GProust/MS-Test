package ms.test.first.ms.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ms.test.first.ms.controllers.parameters.PersonParameters;
import ms.test.first.ms.entities.Person;

public interface IPersonService {
	
	/**
	 * Récupère toutes les personnes
	 * @return
	 */
	public List<Person> findAllPerson();
	
	/**
	 * Ajoute une nouvelle personne en base
	 * @param person
	 * @return
	 */
	public Person addPerson(PersonParameters personParameters);
	
	/**
	 * Ajoute une nouvelle personne en base
	 * @param person
	 * @return
	 */
	public ResponseEntity<String> removePerson(PersonParameters personParameters);
	
	/**
	 * Trouve soit une personne en particulier ou toute les personnes avec le même nom de famille
	 * @param person
	 * @return
	 */
	public List<Person> find(PersonParameters personParameters);

}
