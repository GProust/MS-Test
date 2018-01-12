package ms.test.first.ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ms.test.first.ms.controllers.parameters.PersonParameters;
import ms.test.first.ms.entities.Person;
import ms.test.first.ms.services.IPersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private IPersonService personService;
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Person> getPersons() {
		return this.personService.findAllPerson();
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public List<Person> findPersons(PersonParameters personParameter) {
		return this.personService.find(personParameter);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<String> addPerson(PersonParameters personParameter) {
		if(this.personService.find(personParameter) != null) {
			return ResponseEntity.badRequest().body("La personne existe déjà !");
		}
		
		try {
			this.personService.addPerson(personParameter);
		}catch(Exception ex) {
			return ResponseEntity.badRequest().body("Erreur lors de l'ajout.");
		}
		return ResponseEntity.ok("Nouvelle personne ajouté !");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<String> removePerson(PersonParameters personParameter) {
		try {
			return this.personService.removePerson(personParameter);
		}catch(Exception ex) {
			return ResponseEntity.badRequest().body("Erreur lors de la suppression.");
		}
	}
}
