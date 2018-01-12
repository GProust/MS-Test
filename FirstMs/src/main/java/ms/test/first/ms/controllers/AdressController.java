package ms.test.first.ms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ms.test.first.ms.controllers.parameters.AdressParameters;
import ms.test.first.ms.entities.Adress;
import ms.test.first.ms.services.IAdressService;

@RestController
@RequestMapping("/adress")
public class AdressController {

	@Autowired
	private IAdressService adressService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<String> addAdress(@Valid AdressParameters adressParameter) {
		
		try {
			final Adress adress = this.adressService.addAdress(adressParameter);
			if(adress == null) {
				return ResponseEntity.badRequest().body("La ville ou la personne n'existe pas !");
			}
		}catch(Exception ex) {
			return ResponseEntity.badRequest().body("Erreur lors de l'ajout.");
		}
		return ResponseEntity.ok("Nouvelle adresse ajouté à "+ adressParameter.getFirstName() + " " + adressParameter.getLastName() + " !");
	}
}
