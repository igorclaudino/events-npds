package br.ufc.crateus.npds.events.repository;

import br.ufc.crateus.npds.events.models.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
