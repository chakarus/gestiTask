package comspring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import comspring.models.User;
import comspring.services.UserService;


@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("user", new User());
		return "views/registerForm";
		
	}
	
	
	@PostMapping("/register")
	public String RegisterUser(@Valid User user,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "views/registerForm";
		}
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exists", true);
			return "views/registerForm";
		}
		userService.createUser(user);
		return "views/success";
	}
	
	

}
