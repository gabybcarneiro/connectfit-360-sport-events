package com.br.sportsevents.service;

import com.br.sportsevents.dto.eventos.EventosCreateDTO;
import com.br.sportsevents.dto.eventos.EventosDTO;
import com.br.sportsevents.dto.eventos.EventosUpdateDTO;
import com.br.sportsevents.dto.ModalidadeDTO;
import com.br.sportsevents.mapper.EventosMapper;
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
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    private EventosMapper eventosMapper;

    @Mock
    private ModalidadeMapper modalidadeMapper;

    @InjectMocks
    private EventosService service;

    @Test
    void shouldDelegateSearchToRepositoryAndReturnDTOList() {
        LocalDateTime date = LocalDateTime.of(2025, 4, 10, 4, 30);
        Eventos evento = new Eventos();
        evento.setId(4L);
        evento.setNome("Meia Maratona do Rio");
        evento.setDataEvento(date);
        evento.setCidade("Rio de Janeiro");
        evento.setIdTipo(1);
        evento.setIdModalidade(2);
        evento.setDistancia("21km");
        List<Eventos> entities = List.of(evento);

        EventosDTO dto = new EventosDTO();
        dto.setId(4L);
        dto.setNome("Meia Maratona do Rio");
        List<EventosDTO> expected = List.of(dto);

        when(eventosRepository.searchEvents(date, "Rio de Janeiro", 1, 2, "21km")).thenReturn(entities);
        when(eventosMapper.toDTOList(entities)).thenReturn(expected);

        List<EventosDTO> results = service.searchEvents(date, "Rio de Janeiro", 1, 2, "21km");

        assertEquals(expected, results);
        verify(eventosRepository).searchEvents(date, "Rio de Janeiro", 1, 2, "21km");
        verify(eventosMapper).toDTOList(entities);
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
    void shouldConvertCreateDTOToEntityAndReturnDTO() {
        EventosCreateDTO createDTO = new EventosCreateDTO();
        createDTO.setNome("Corrida de Rua SP");
        createDTO.setCidade("São Paulo");
        createDTO.setIdTipo(1);
        createDTO.setIdModalidade(2);
        createDTO.setVagas(200);

        Eventos entity = new Eventos();
        entity.setNome("Corrida de Rua SP");

        EventosDTO expected = new EventosDTO();
        expected.setNome("Corrida de Rua SP");

        when(eventosMapper.createToEntity(createDTO)).thenReturn(entity);
        when(eventosRepository.save(entity)).thenReturn(entity);
        when(eventosMapper.toDTO(entity)).thenReturn(expected);

        EventosDTO result = service.createEvent(createDTO);

        assertEquals(expected, result);
        verify(eventosMapper).createToEntity(createDTO);
        verify(eventosRepository).save(entity);
        verify(eventosMapper).toDTO(entity);
    }

    @Test
    void shouldUpdateExistingEventAndReturnDTO() {
        Eventos existing = new Eventos();
        existing.setId(1L);
        existing.setNome("Evento Antigo");
        existing.setCidade("Curitiba");
        existing.setDataInclusao(LocalDateTime.of(2025, 1, 1, 0, 0));
        existing.setUsuarioInclusao("admin");

        EventosUpdateDTO updateDTO = new EventosUpdateDTO();
        updateDTO.setNome("Corrida de Rua SP");
        updateDTO.setDataEvento(LocalDateTime.of(2025, 6, 15, 8, 0));
        updateDTO.setCidade("São Paulo");
        updateDTO.setEstado("SP");
        updateDTO.setPais("Brasil");
        updateDTO.setIdTipo(1);
        updateDTO.setIdModalidade(2);
        updateDTO.setVagas(500);
        updateDTO.setVagasDisponiveis(300);
        updateDTO.setInscricaoAberta(true);

        EventosDTO expected = new EventosDTO();
        expected.setNome("Corrida de Rua SP");

        when(eventosRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(eventosRepository.save(any(Eventos.class))).thenAnswer(inv -> inv.getArgument(0));
        when(eventosMapper.toDTO(existing)).thenReturn(expected);

        EventosDTO result = service.updateEvent(1L, updateDTO);

        assertEquals(expected, result);
        assertEquals("Corrida de Rua SP", existing.getNome());
        assertEquals("São Paulo", existing.getCidade());
        assertNotNull(existing.getDataAlteracao());
        verify(eventosRepository).findById(1L);
        verify(eventosRepository).save(existing);
        verify(eventosMapper).toDTO(existing);
    }

    @Test
    void shouldThrowWhenEventNotFound() {
        when(eventosRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> service.updateEvent(99L, new EventosUpdateDTO()));
    }
}
