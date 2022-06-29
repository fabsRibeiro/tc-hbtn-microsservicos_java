package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CPFException extends RuntimeException{

    public ResponseEntity handelerCpf(Exception e){
        return new ResponseEntity("You have entered invalid CPF", HttpStatus.BAD_GATEWAY);
    }
}
