package comspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import comspring.models.Task;
import comspring.models.User;

public interface TasksRepository extends JpaRepository<Task, Integer> {

	List<Task> findByUser(User user);

}
