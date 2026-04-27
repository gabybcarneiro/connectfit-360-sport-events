package com.br.sportsevents.controller;

import com.br.sportsevents.dto.EventosDTO;
import com.br.sportsevents.dto.ModalidadeDTO;
import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.service.EventosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @Tag(name = "Consulta eventos", description = "API responsavel por buscar eventos por filtro.")
    public List<EventosDTO> getEvents(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam(required = false) String cidade,
            @RequestParam(required = false) Integer idTipo,
            @RequestParam(required = false) Integer idModalidade) {
        return eventService.searchEvents(date, cidade, idTipo, idModalidade);
    }

    @GetMapping("/modalities")
    @Tag(name = "Modalidade", description = "API responsavel por buscar tipo de modalidade.")
    public List<ModalidadeDTO> getModality() {
        return eventService.getAllModality();
    }

    @PostMapping
    @Tag(name = "Cadastrar eventos", description = "API responsavel por cadastrar eventos.")
    public ResponseEntity<EventosDTO> createEvent(@RequestBody Eventos evento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(evento));
    }

    @PutMapping("/{id}")
    @Tag(name = "Atualizar eventos", description = "API responsavel por atualizar eventos.")
    public ResponseEntity<EventosDTO> updateEvent(@PathVariable Long id, @RequestBody Eventos evento) {
        return ResponseEntity.ok(eventService.updateEvent(id, evento));
    }
}
