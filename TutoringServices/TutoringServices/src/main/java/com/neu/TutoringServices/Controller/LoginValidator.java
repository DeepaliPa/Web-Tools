package com.neu.TutoringServices.Controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.TutoringServices.Pojo.User;

public class LoginValidator implements Validator {

	 public boolean supports(Class aClass)
	    {
	        return aClass.equals(User.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	        User user = (User) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
	       
	        
	    }

}
