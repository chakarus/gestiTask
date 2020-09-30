package comspring.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comspring.models.Task;
import comspring.models.User;
import comspring.repository.TasksRepository;

@Service
public class TasksService {
	
	@Autowired
	TasksRepository taskRepo;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepo.save(task);	
	}
	public List<Task> findUserTask(User user){
		
	
		return taskRepo.findByUser(user);
		
		
		
	}

}
