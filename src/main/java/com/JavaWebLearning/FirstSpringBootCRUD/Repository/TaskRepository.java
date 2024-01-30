package com.JavaWebLearning.FirstSpringBootCRUD.Repository;

import com.JavaWebLearning.FirstSpringBootCRUD.Models.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository <Task,Integer>{
    @Transactional
    @Modifying
    @Query(value="SELECT * FROM task WHERE author_id = ?1",nativeQuery = true)
    public Optional<Task[]> findTasksByAuthorId(int author_id);


}
