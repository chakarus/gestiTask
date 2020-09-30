package comspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import comspring.models.User;
import comspring.services.UserService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User newAdmin = new User("admin@mail.com","admin","123456");
		userService.createAdmin(newAdmin);
	}

}
