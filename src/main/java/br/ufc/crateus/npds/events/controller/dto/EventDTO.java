package br.ufc.crateus.npds.events.controller.dto;

import br.ufc.crateus.npds.events.models.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDTO {

    private Integer id;
    private String name;
    private String description;
    private String localization;
    private Date beginDate;
    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public static EventDTO toDTO(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setBeginDate(event.getBeginDate());
        eventDTO.setLocalization(event.getLocalization());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setEndDate(event.getEndDate());
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());

        return eventDTO;

    }

    public static List<EventDTO> toDTOList(List<Event> events){
        List<EventDTO> eventDTOS = new ArrayList<>();

        for(Event event : events){
            eventDTOS.add(toDTO(event));
        }

        return eventDTOS;
    }
}
