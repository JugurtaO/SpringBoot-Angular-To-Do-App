package com.JavaWebLearning.FirstSpringBootCRUD.Repository;

import com.JavaWebLearning.FirstSpringBootCRUD.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository {
    public Optional<Task[]> findTasksByAuthorId(int author_id);

}
