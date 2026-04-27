package com.br.sportsevents.service;

import com.br.sportsevents.dto.ModalidadeDTO;
import com.br.sportsevents.mapper.ModalidadeMapper;
import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.model.Modalidade;
import com.br.sportsevents.repository.EventosRepository;
import com.br.sportsevents.repository.ModalidadeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventosServiceTest {

    @Mock
    private EventosRepository eventosRepository;

    @Mock
    private ModalidadeRepository modalidadeRepository;

    @Mock
    private ModalidadeMapper modalidadeMapper;

    @InjectMocks
    private EventosService service;

    @Test
    void shouldDelegateSearchToRepositoryWithAllFilters() {
        LocalDateTime date = LocalDateTime.of(2025, 4, 10, 4, 30);
        Eventos evento = new Eventos();
        evento.setId(4L);
        evento.setNome("Meia Maratona do Rio");
        evento.setData(date);
        evento.setLocalizacao("Rio de Janeiro");
        evento.setTipoEvento("Corrida de Rua");
        evento.setModalidade("Atletismo");
        List<Eventos> expected = List.of(evento);

        when(eventosRepository.searchEvents(date, "Rio de Janeiro", "Corrida de Rua", 1)).thenReturn(expected);

        List<Eventos> results = service.searchEvents(date, "Rio de Janeiro", "Corrida de Rua", 1);

        assertEquals(expected, results);
        verify(eventosRepository).searchEvents(date, "Rio de Janeiro", "Corrida de Rua", 1);
    }

    @Test
    void shouldReturnMappedModalidades() {
        Modalidade modalidade = new Modalidade();
        modalidade.setId(1L);
        modalidade.setDescricao("Atletismo");
        List<Modalidade> modalidades = List.of(modalidade);
        List<ModalidadeDTO> expected = List.of(new ModalidadeDTO(1L, "Atletismo"));

        when(modalidadeRepository.findAll()).thenReturn(modalidades);
        when(modalidadeMapper.toDTOList(modalidades)).thenReturn(expected);

        List<ModalidadeDTO> results = service.getAllModality();

        assertEquals(expected, results);
        verify(modalidadeRepository).findAll();
        verify(modalidadeMapper).toDTOList(modalidades);
    }

    @Test
    void shouldSetAuditDatesAndSaveEvent() {
        Eventos evento = new Eventos();
        evento.setNome("Corrida de Rua SP");
        evento.setLocalizacao("São Paulo");
        evento.setTipoEvento("Corrida");
        evento.setModalidade("Atletismo");
        evento.setUsuarioInclusao("admin");
        evento.setUsuarioAlteracao("admin");

        when(eventosRepository.save(any(Eventos.class))).thenAnswer(inv -> inv.getArgument(0));

        Eventos result = service.createEvent(evento);

        assertNotNull(result.getDataInclusao());
        assertNotNull(result.getDataAlteracao());
        verify(eventosRepository).save(evento);
    }
}
