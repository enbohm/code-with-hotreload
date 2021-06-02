package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.inject.Inject;

public class CustomAgeValidator implements ConstraintValidator<Age, Integer> {

    @Inject
    @RestClient
    AgeLookupService ageLookupService;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return ageLookupService.getAge().getStatus() > 199;
    }
}
