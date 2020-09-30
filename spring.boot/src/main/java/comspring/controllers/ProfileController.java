package comspring.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comspring.models.User;
import comspring.services.TasksService;
import comspring.services.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TasksService taskService;
	
	
	@GetMapping("/profile")
	public String showProfilPage(Model model,Principal principal) {
		
		String email=principal.getName();
		
		User user = userService.findOne(email);
		System.out.print(user);
		model.addAttribute("tasks", taskService.findUserTask(user));
		
		return "views/profile";
	}

}
