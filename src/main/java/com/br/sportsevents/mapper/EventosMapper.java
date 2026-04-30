package com.br.sportsevents.mapper;

import com.br.sportsevents.dto.eventos.EventosCreateDTO;
import com.br.sportsevents.dto.eventos.EventosDTO;
import com.br.sportsevents.model.Eventos;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EventosMapper {

    public EventosDTO toDTO(Eventos e) {
        EventosDTO dto = new EventosDTO();
        dto.setId(e.getId());
        dto.setNome(e.getNome());
        dto.setDataEvento(e.getDataEvento());
        dto.setCidade(e.getCidade());
        dto.setEstado(e.getEstado());
        dto.setPais(e.getPais());
        dto.setIdTipo(e.getIdTipo());
        dto.setIdModalidade(e.getIdModalidade());
        dto.setIdOrganizacao(e.getIdOrganizacao());
        dto.setImagemEvento(e.getImagemEvento());
        dto.setInscricaoAberta(e.getInscricaoAberta());
        dto.setDistancia(e.getDistancia());
        dto.setVagas(e.getVagas());
        dto.setVagasDisponiveis(e.getVagasDisponiveis());
        dto.setDataInclusao(e.getDataInclusao());
        dto.setUsuarioInclusao(e.getUsuarioInclusao());
        dto.setDataAlteracao(e.getDataAlteracao());
        dto.setUsuarioAlteracao(e.getUsuarioAlteracao());
        return dto;
    }

    public List<EventosDTO> toDTOList(List<Eventos> eventos) {
        return eventos.stream().map(this::toDTO).toList();
    }

    public Eventos toEntity(EventosDTO dto) {
        Eventos e = new Eventos();
        e.setNome(dto.getNome());
        e.setDataEvento(dto.getDataEvento());
        e.setCidade(dto.getCidade());
        e.setEstado(dto.getEstado());
        e.setPais(dto.getPais());
        e.setIdTipo(dto.getIdTipo());
        e.setIdModalidade(dto.getIdModalidade());
        e.setIdOrganizacao(dto.getIdOrganizacao());
        e.setImagemEvento(dto.getImagemEvento());
        e.setInscricaoAberta(dto.getInscricaoAberta());
        e.setDistancia(dto.getDistancia());
        e.setVagas(dto.getVagas());
        e.setVagasDisponiveis(dto.getVagasDisponiveis());
        e.setUsuarioInclusao("sistema");
        return e;
    }

    public Eventos createToEntity(EventosCreateDTO dto) {
        Eventos e = new Eventos();
        e.setNome(dto.getNome());
        e.setDataEvento(dto.getDataEvento());
        e.setCidade(dto.getCidade());
        e.setEstado(dto.getEstado());
        e.setPais(dto.getPais());
        e.setIdTipo(dto.getIdTipo());
        e.setIdModalidade(dto.getIdModalidade());
        e.setIdOrganizacao(dto.getIdOrganizacao());
        e.setImagemEvento(dto.getImagemEvento());
        e.setInscricaoAberta(dto.getInscricaoAberta());
        e.setDistancia(dto.getDistancia());
        e.setVagas(dto.getVagas());
        e.setVagasDisponiveis(dto.getVagasDisponiveis());
        e.setUsuarioInclusao("sistema");
        e.setDataInclusao(LocalDateTime.now());
        return e;
    }
}
