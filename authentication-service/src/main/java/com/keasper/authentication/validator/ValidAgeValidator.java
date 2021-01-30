package com.keasper.authentication.validator;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidAgeValidator implements ConstraintValidator<ValidAge, LocalDate>{

	private int min;
	private int max;
	
	
	  @Override
	  public void initialize(ValidAge validAge) {
	    min = validAge.min();
	    max = validAge.max();
	  }
	  
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		LocalDate now = LocalDate.now(); //gets localDate
		Period diff = Period.between(value, now); //difference between the dates is calculated
		
		if (diff.getYears()>min && diff.getYears()<max) {
			return true;
		}
		return false;
	}

}
