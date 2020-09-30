package comspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import comspring.models.User;

public interface UserRepository extends JpaRepository<User, String>{

	List<User> findByUsernameLike(String string);

	


	

	



}
