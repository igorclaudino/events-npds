package br.ufc.crateus.npds.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {
    public RecordNotFoundException(){
        super("Registro com esse ID não foi encontrado");
    }
}
