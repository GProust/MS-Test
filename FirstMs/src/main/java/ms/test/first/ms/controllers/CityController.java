package ms.test.first.ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ms.test.first.ms.controllers.parameters.CityParameters;
import ms.test.first.ms.services.ICityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private ICityService cityService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<String> addAdress(CityParameters cityParameter) {
		
		try {
			this.cityService.addCity(cityParameter);
		}catch(Exception ex) {
			return ResponseEntity.badRequest().body("Erreur lors de l'ajout.");
		}
		return ResponseEntity.ok("Nouvelle ville ajouté : "+ cityParameter.getName() + " " + cityParameter.getZipCode() + " !");
	}
}
