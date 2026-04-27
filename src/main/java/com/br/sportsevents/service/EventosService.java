package com.br.sportsevents.service;

import com.br.sportsevents.dto.ModalidadeDTO;
import com.br.sportsevents.mapper.ModalidadeMapper;
import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.repository.EventosRepository;
import com.br.sportsevents.repository.ModalidadeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventosService {

    private final EventosRepository eventosRepository;
    private final ModalidadeRepository modalidadeRepository;
    private final ModalidadeMapper modalidadeMapper;

    public EventosService(EventosRepository eventosRepository,
                          ModalidadeRepository modalidadeRepository,
                          ModalidadeMapper modalidadeMapper) {
        this.eventosRepository = eventosRepository;
        this.modalidadeRepository = modalidadeRepository;
        this.modalidadeMapper = modalidadeMapper;
    }

    public List<Eventos> searchEvents(LocalDateTime date, String location, String eventType, Integer modality) {
        return eventosRepository.searchEvents(date, location, eventType, modality);
    }

    public List<ModalidadeDTO> getAllModality() {
        return modalidadeMapper.toDTOList(modalidadeRepository.findAll());
    }

    public Eventos createEvent(Eventos evento) {
        LocalDateTime now = LocalDateTime.now();
        evento.setDataInclusao(now);
        evento.setDataAlteracao(now);
        return eventosRepository.save(evento);
    }
}
