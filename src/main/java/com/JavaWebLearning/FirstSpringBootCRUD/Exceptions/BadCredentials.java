package com.JavaWebLearning.FirstSpringBootCRUD.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)

public class BadCredentials extends RuntimeException{
    public BadCredentials(String message){
        super(message);
    }


}
