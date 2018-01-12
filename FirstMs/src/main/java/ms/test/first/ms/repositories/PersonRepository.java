package ms.test.first.ms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ms.test.first.ms.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	public List<Person> findByLastName(String lastName);
	
	public Person findByLastNameAndFirstName(String lastName, String firstName);
	
}
