package com.JavaWebLearning.FirstSpringBootCRUD.Services;

import org.springframework.stereotype.Service;

@Service
public class HomeServices implements HomeServicesInterface {


    public String welcome(){
        return "Welcome to Spring Boot - Angular  TO-DO list  App";
    }
}
