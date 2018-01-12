package ms.test.first.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.test.first.ms.controllers.parameters.AdressParameters;
import ms.test.first.ms.entities.Adress;
import ms.test.first.ms.entities.City;
import ms.test.first.ms.entities.Person;
import ms.test.first.ms.repositories.CityRepository;
import ms.test.first.ms.repositories.PersonRepository;
import ms.test.first.ms.services.IAdressService;

@Service
public class AdressService implements IAdressService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public Adress addAdress(AdressParameters adressParameters) {
		Person person = personRepository.findByLastNameAndFirstName(adressParameters.getLastName(), adressParameters.getFirstName());
		Adress adress = null;
		if(person != null) {
			City city = cityRepository.findByZipCode(adressParameters.getZipCode());
			if(city != null) {
				adress = new Adress();
				adress.setCity(city);
				adress.setLabel(adressParameters.getLabel());
				person.getAdresses().add(adress);
				personRepository.save(person);
			}
		}
		return adress;
	}

}
