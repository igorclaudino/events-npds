package br.ufc.crateus.npds.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEndDateException extends Exception {

    public InvalidEndDateException(){
        super("Data final inválida");
    }
}
