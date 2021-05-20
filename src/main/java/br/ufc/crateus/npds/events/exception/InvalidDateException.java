package br.ufc.crateus.npds.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDateException extends Exception {

    public InvalidDateException(){
        super("Data inválida");
    }
}
