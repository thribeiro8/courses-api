package br.com.thomasribeiro.coursesapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(CourseNotFoundException.class)
    public String handleNotFoundException(CourseNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(CourseExistsException.class)
    public String handleExistsException(CourseExistsException e) {
        return e.getMessage();
    }

}
