package com.br.sportsevents.controller;

import com.br.sportsevents.model.SportsEvent;
import com.br.sportsevents.service.SportsEventService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class SportsEventController {

    private final SportsEventService eventService;

    public SportsEventController(SportsEventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<SportsEvent> getEvents(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String eventType,
            @RequestParam(required = false) String modality) {
        return eventService.searchEvents(date, location, eventType, modality);
    }
}
