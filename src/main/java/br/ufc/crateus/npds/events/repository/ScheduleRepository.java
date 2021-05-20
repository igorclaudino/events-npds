package br.ufc.crateus.npds.events.repository;

import br.ufc.crateus.npds.events.models.Event;
import br.ufc.crateus.npds.events.models.Schedule;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    List<Schedule> findByEvent(Event event, Pageable pageable);
}
