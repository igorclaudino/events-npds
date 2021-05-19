package br.ufc.crateus.npds.events.controller;

import br.ufc.crateus.npds.events.exception.InvalidEndDateException;
import br.ufc.crateus.npds.events.exception.RecordNotFoundException;
import br.ufc.crateus.npds.events.models.Event;

import br.ufc.crateus.npds.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    private ResponseEntity<List<Event>> getAll(@RequestParam(required = false) String query) {
        List<Event> events = null;
        if(query == null) {
            events = eventService.getAll();

        }else{
            events = eventService.getByQuery(query);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Event> insert(@RequestBody Event event) throws InvalidEndDateException {
        Event createdEvent = eventService.insert(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Event> getById(@PathVariable Integer id) throws RecordNotFoundException {
        Event event = eventService.getById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
  }
}
