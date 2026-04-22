package com.br.sportsevents.service;

import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.repository.EventosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventosService {

    private final EventosRepository eventosRepository;

    public EventosService(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    public List<Eventos> searchEvents(LocalDateTime date, String location, String eventType, String modality) {
        return eventosRepository.searchEvents(date, location, eventType, modality);
    }
}
