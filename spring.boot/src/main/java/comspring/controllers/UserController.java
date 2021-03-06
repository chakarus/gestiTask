package comspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comspring.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String users(Model model,@RequestParam(defaultValue="") String username) {
		model.addAttribute("users", userService.findByUsername(username));
		return "views/listUsers.html";
	}

}
