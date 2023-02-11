package GurujiTask.TaskManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Business logic
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public String addTask(Tasks tasks){

         taskRepository.save(tasks);
         return "Task Added Successfully";
    }

    public Tasks getTask(int id){
        Tasks tasks = taskRepository.getById(id);
        return tasks;
    }

//    public String addTasks(Tasks tasks){
//        return taskRepository.addTask(tasks);
//    }
    public List<Tasks> getAllTasks(){
        return taskRepository.findAll();
    }


    public Tasks updateStatus(Tasks task){
        Optional<Tasks> tasks = taskRepository.findById(task.getId());
        task.setStatus("completed");
        return task;
    }

    public String deleteTask(Tasks id){
        taskRepository.delete(id);
        return "Deleted successfully";
    }


}
