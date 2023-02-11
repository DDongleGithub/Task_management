package GurujiTask.TaskManagement;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//All APIs written in controller layer

@RestController
@RequestMapping
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity addTask(@RequestBody Tasks tasks){

        return new ResponseEntity<>(taskService.addTask(tasks), HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getTasks(@RequestParam int id){
        Tasks task = taskService.getTask(id);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity getAllTasks(){
        return new ResponseEntity(taskService.getAllTasks(),HttpStatus.FOUND);
    }



    @PutMapping("tasks/{id}")
    public ResponseEntity updateTasks(@PathVariable Tasks id){
        Tasks task = taskService.updateStatus(id);
        if(task == null){
            return new ResponseEntity<>(task, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.FOUND);
    }


    @DeleteMapping("tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable Tasks id){
        String s = taskService.deleteTask(id);
        return new ResponseEntity<>(s, HttpStatus.FOUND);
    }



}
