package com.JavaWebLearning.FirstSpringBootCRUD.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFound extends RuntimeException{
    //private static final long seriaLVersionUID=1L;

    public RessourceNotFound(String message){
        super(message);
    }
}
