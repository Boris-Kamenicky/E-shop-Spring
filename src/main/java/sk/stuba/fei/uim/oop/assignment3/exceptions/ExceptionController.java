package sk.stuba.fei.uim.oop.assignment3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {NoSuchElementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(){}

    @ExceptionHandler(value = {CartException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleCartException(){}
}
