package com.br.sportsevents.mapper;

import com.br.sportsevents.dto.ModalidadeDTO;
import com.br.sportsevents.model.Modalidade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModalidadeMapper {

    public ModalidadeDTO toDTO(Modalidade modalidade) {
        return new ModalidadeDTO(modalidade.getId(), modalidade.getDescricao());
    }

    public List<ModalidadeDTO> toDTOList(List<Modalidade> modalidades) {
        return modalidades.stream().map(this::toDTO).toList();
    }
}
