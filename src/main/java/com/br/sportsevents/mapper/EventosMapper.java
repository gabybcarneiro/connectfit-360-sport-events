package com.br.sportsevents.mapper;

import com.br.sportsevents.dto.EventosDTO;
import com.br.sportsevents.model.Eventos;
import org.springframework.stereotype.Component;

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
}
