package com.br.sportsevents.service;

import com.br.sportsevents.dto.EventosDTO;
import com.br.sportsevents.dto.ModalidadeDTO;
import com.br.sportsevents.mapper.EventosMapper;
import com.br.sportsevents.mapper.ModalidadeMapper;
import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.repository.EventosRepository;
import com.br.sportsevents.repository.ModalidadeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventosService {

    private final EventosRepository eventosRepository;
    private final ModalidadeRepository modalidadeRepository;
    private final EventosMapper eventosMapper;
    private final ModalidadeMapper modalidadeMapper;

    public EventosService(EventosRepository eventosRepository,
                          ModalidadeRepository modalidadeRepository,
                          EventosMapper eventosMapper,
                          ModalidadeMapper modalidadeMapper) {
        this.eventosRepository = eventosRepository;
        this.modalidadeRepository = modalidadeRepository;
        this.eventosMapper = eventosMapper;
        this.modalidadeMapper = modalidadeMapper;
    }

    public List<EventosDTO> searchEvents(LocalDateTime date, String cidade, Integer idTipo, Integer idModalidade) {
        return eventosMapper.toDTOList(eventosRepository.searchEvents(date, cidade, idTipo, idModalidade));
    }

    public List<ModalidadeDTO> getAllModality() {
        return modalidadeMapper.toDTOList(modalidadeRepository.findAll());
    }

    public EventosDTO createEvent(Eventos evento) {
        LocalDateTime now = LocalDateTime.now();
        evento.setDataInclusao(now);
        evento.setDataAlteracao(now);
        return eventosMapper.toDTO(eventosRepository.save(evento));
    }

    public EventosDTO updateEvent(Long id, Eventos evento) {
        Eventos existing = eventosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Evento não encontrado: " + id));
        existing.setNome(evento.getNome());
        existing.setDataEvento(evento.getDataEvento());
        existing.setCidade(evento.getCidade());
        existing.setEstado(evento.getEstado());
        existing.setPais(evento.getPais());
        existing.setIdTipo(evento.getIdTipo());
        existing.setIdModalidade(evento.getIdModalidade());
        existing.setIdOrganizacao(evento.getIdOrganizacao());
        existing.setImagemEvento(evento.getImagemEvento());
        existing.setInscricaoAberta(evento.getInscricaoAberta());
        existing.setVagas(evento.getVagas());
        existing.setVagasDisponiveis(evento.getVagasDisponiveis());
        existing.setUsuarioAlteracao(evento.getUsuarioAlteracao());
        existing.setDataAlteracao(LocalDateTime.now());
        return eventosMapper.toDTO(eventosRepository.save(existing));
    }
}
