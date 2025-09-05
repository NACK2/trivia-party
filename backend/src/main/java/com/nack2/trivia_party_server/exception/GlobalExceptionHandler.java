package com.nack2.trivia_party_server.exception;

import com.nack2.trivia_party_server.Common.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PlayerNotFoundException.class)
    ResponseEntity<Response<Void>> handlePlayerNotFound(PlayerNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new Response<>(new Date(), HttpStatus.NOT_FOUND.value(), e.getMessage())
        );
    }
}
