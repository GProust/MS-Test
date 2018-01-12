package ms.test.first.ms.services;

import ms.test.first.ms.controllers.parameters.AdressParameters;
import ms.test.first.ms.entities.Adress;

public interface IAdressService {
	
	/**
	 * Permet d'ajouter une adresse à une personne
	 * @param adressParameters
	 * @return
	 */
	public Adress addAdress(AdressParameters adressParameters);

}
