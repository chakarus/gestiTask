package comspring.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import comspring.models.Role;
import comspring.models.User;
import comspring.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void createUser(User user) {
		//cryptage du mot de passe avec la classe BcryptPasswordEncoder
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		//attribution d'un role à notre user
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		
		userRepo.save(user);
	}
	public void createAdmin(User user) {
		//cryptage du mot de passe avec la classe BcryptPasswordEncoder
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		//attribution d'un role à notre user
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		
		userRepo.save(user);
	}
	public User findOne(String email) {
		return userRepo.findById(email).orElse(null);
	}
	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		User u =userRepo.findById(email).orElse(null);
		if(u!=null) 
			return true;
	
		return false;
	}
	public List<User> findAll() {
		
		return userRepo.findAll();
	}
	public List<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameLike("%"+username+"%");
	}

	
}
