package comspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
	
	@GetMapping("/")
	public String accueil() {
		 return "accueil";
	}
	@GetMapping("/login")
	public String showLoginForm() {
		
		return "views/loginForm";
	}

}
