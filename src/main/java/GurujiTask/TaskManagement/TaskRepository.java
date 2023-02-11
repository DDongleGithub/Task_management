package GurujiTask.TaskManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Interaction with DB
@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer> {

    //Instead of DB we are using HashMap to store data



}





