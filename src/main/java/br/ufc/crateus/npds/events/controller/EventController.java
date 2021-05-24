package br.ufc.crateus.npds.events.controller;

import br.ufc.crateus.npds.events.controller.dto.EventDTO;
import br.ufc.crateus.npds.events.exception.InvalidDateException;
import br.ufc.crateus.npds.events.exception.InvalidEndDateException;
import br.ufc.crateus.npds.events.exception.RecordNotFoundException;
import br.ufc.crateus.npds.events.models.Event;

import br.ufc.crateus.npds.events.models.Schedule;
import br.ufc.crateus.npds.events.service.EventService;
import br.ufc.crateus.npds.events.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    private ResponseEntity<List<EventDTO>> getAll(@RequestParam(required = false) String query,
                                                  @RequestParam(required = false) int pageNumber,
                                                  @RequestParam(required = false) int pageSize) {
        List<Event> events = null;
        if (query == null) {
            events = eventService.getAll(pageNumber, pageSize);
        } else {
            events = eventService.getByQuery(query, pageNumber, pageSize);
        }
        return new ResponseEntity<>(EventDTO.toDTOList(events), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<EventDTO> insert(@RequestBody Event event) throws InvalidEndDateException {
        Event createdEvent = eventService.insert(event);
        return new ResponseEntity<>(EventDTO.toDTO(createdEvent), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<EventDTO> getById(@PathVariable Integer id) throws RecordNotFoundException {
        Event event = eventService.getById(id);
        return new ResponseEntity<>(EventDTO.toDTO(event), HttpStatus.OK);
    }
    @PostMapping("/{id}/schedule")
    private ResponseEntity<Schedule> insertSchedule(@RequestBody Schedule schedule, @PathVariable Integer id) throws RecordNotFoundException, InvalidDateException, InvalidEndDateException {
        return new ResponseEntity<>(scheduleService.insert(schedule, id), HttpStatus.OK);
    }

    @GetMapping("/{id}/schedule")
    private ResponseEntity<List<Schedule>> getScheduleByEvent(@PathVariable(name = "id") Integer eventId,
                                                       @RequestParam(required = false) int pageNumber,
                                                       @RequestParam(required = false) int pageSize) throws RecordNotFoundException {
        return new ResponseEntity<>(scheduleService.getByEvent(eventId, pageNumber, pageSize), HttpStatus.OK);
    }
}
