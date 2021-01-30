package com.keasper.authentication.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = com.keasper.authentication.validator.ValidAgeValidator.class)
@Documented
public @interface ValidAge {
	
	 
	  String message() default "The age must be valid.";
	 
	  Class<?>[] groups() default {};
	 
	  Class<? extends Payload>[] payload() default {};
	 
	  int min() default 12;
	  int max() default 100;
	
}
