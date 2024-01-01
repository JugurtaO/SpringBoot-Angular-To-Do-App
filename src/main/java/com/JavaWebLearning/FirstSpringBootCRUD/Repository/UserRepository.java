package com.JavaWebLearning.FirstSpringBootCRUD.Repository;

import com.JavaWebLearning.FirstSpringBootCRUD.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {

    public Optional<User> findUserByEmailAndPassword(String Email,String password);
}
