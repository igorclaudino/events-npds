package br.ufc.crateus.npds.events.service;

import br.ufc.crateus.npds.events.exception.InvalidEndDateException;
import br.ufc.crateus.npds.events.exception.RecordNotFoundException;
import br.ufc.crateus.npds.events.models.Event;
import br.ufc.crateus.npds.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public List<Event> getAll(){
        List<Event> events = (List<Event>) eventRepository.findAll();
        return events;
    }

    public Event insert(Event event) throws InvalidEndDateException {
        if(event.getEndDate().before(event.getBeginDate())){
            throw new InvalidEndDateException();
        }
        return eventRepository.save(event);
    }

    public Event getById(Integer id) throws RecordNotFoundException {
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()) return event.get();
        else throw new RecordNotFoundException();
    }

    public List<Event> getByQuery(String query) {
        List<Event> events = eventRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrLocalizationContainingIgnoreCaseOrOrganizerContainingIgnoreCase(query, query, query, query);
        return events;
    }
}
