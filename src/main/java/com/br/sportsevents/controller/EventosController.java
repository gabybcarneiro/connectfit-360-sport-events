package com.br.sportsevents.controller;

import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.service.EventosService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventosController {

    private final EventosService eventService;

    public EventosController(EventosService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Eventos> getEvents(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String eventType,
            @RequestParam(required = false) String modality) {
        return eventService.searchEvents(date, location, eventType, modality);
    }
}
