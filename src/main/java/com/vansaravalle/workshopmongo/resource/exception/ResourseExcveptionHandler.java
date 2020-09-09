package com.vansaravalle.workshopmongo.resource.exception;

import com.vansaravalle.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourseExcveptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFond(ObjectNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(System.currentTimeMillis(), status.value(), "Não encontrado",
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
