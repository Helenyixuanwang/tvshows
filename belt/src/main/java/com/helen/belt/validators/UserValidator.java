package com.helen.belt.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;


import com.helen.belt.models.User;
import com.helen.belt.repositories.UserRepository;







@Component
public class UserValidator {
	@Autowired
	//do not need implements interface Validator here because there is a validation dependency already.
	private UserRepository userRepository;


    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    

    public void validate(Object target, Errors errors) {
        //need type cast here
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match","Password does not match!");
        }  
        
        
        if (userRepository.findByEmail(user.getEmail())!= null) {
        	errors.rejectValue("email", "Unique","Email already exists!!");
        }
        
        //the user with certain name is not allowed to register, for example
        if(user.getFirstName().equals("Matt")) {
        	errors.rejectValue("firstName", "NoMattsAllowed", "Matts are not able to register at this time");
        }
    }	

}