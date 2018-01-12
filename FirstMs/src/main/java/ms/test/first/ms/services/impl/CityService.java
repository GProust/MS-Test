package ms.test.first.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.test.first.ms.controllers.parameters.CityParameters;
import ms.test.first.ms.entities.City;
import ms.test.first.ms.repositories.CityRepository;
import ms.test.first.ms.services.ICityService;

@Service
public class CityService implements ICityService{

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public void addCity(CityParameters cityParameters) {
		City newCity = new City();
		newCity.setName(cityParameters.getName());
		newCity.setZipCode(cityParameters.getZipCode());
		cityRepository.save(newCity);
	}

}
