package com.helen.belt.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.helen.belt.models.User;
import com.helen.belt.services.UserService;
import com.helen.belt.validators.UserValidator;










@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String registerForm(@ModelAttribute("user") User user, Model viewModel) {
	
		return "index.jsp";
	}
	
	@PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);

        //if result has error, return the registration page
		if(result.hasErrors()) {
			return "index.jsp";
		}
        //else, save the user in the database, save the user id in the session, return to the home route
		User newUser = userService.registerUser(user);
		session.setAttribute("userId", newUser.getId());
		session.setAttribute("userName", newUser.getFirstName());
        return "redirect:/shows";
    }
    
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, 
			HttpSession session, RedirectAttributes redirectAttribute) {
		//if the user is authenticated, save the user ID in the session
		//else, add error message and return the login page
		if (userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/shows";
		}
		redirectAttribute.addFlashAttribute("error","Invalid email/password");
		return "redirect:/";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
		session.invalidate();
        // redirect to login page
		return "redirect:/";
    }
	
	
	//need change to other dashboard when you have known models and designated landing page

}

