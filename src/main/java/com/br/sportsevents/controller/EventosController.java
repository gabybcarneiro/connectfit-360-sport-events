package com.br.sportsevents.controller;

import com.br.sportsevents.dto.ModalidadeDTO;
import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.service.EventosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventosController {

    @Autowired
    private EventosService eventService;

    @GetMapping
    @Tag(name = "Consulta eventos", description = "API responsavel por buscar eventos por filtro.")
    public List<Eventos> getEvents(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String eventType,
            @RequestParam(required = false) Integer modality) {
        return eventService.searchEvents(date, location, eventType, modality);
    }

    @GetMapping("/modalities")
    @Tag(name = "Modalidade", description = "API responsavel por buscar tipo de modalidade.")
    public List<ModalidadeDTO> getModality() {
        return eventService.getAllModality();
    }

    @PostMapping
    @Tag(name = "Cadastrar eventos", description = "API responsavel por cadastrar eventos.")
    public ResponseEntity<Eventos> createEvent(@RequestBody Eventos evento) {
        Eventos saved = eventService.createEvent(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
