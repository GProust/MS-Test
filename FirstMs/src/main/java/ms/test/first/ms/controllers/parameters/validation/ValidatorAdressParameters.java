package ms.test.first.ms.controllers.parameters.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ms.test.first.ms.controllers.parameters.AdressParameters;

public class ValidatorAdressParameters implements ConstraintValidator<IsValidAdressParameters, AdressParameters>{

	@Override
	public void initialize(IsValidAdressParameters isValidAdressParameters) {
		// 
	}

	@Override
	public boolean isValid(AdressParameters adressParameters, ConstraintValidatorContext constraintValidatorContext) {
		boolean isValid = adressParameters.getZipCode() != null && adressParameters.getLastName() != null && adressParameters.getFirstName() != null;
		if(!isValid) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Les paramètres données ne sont pas correct.");
		}
		return isValid;
	}

}
