package com.br.sportsevents.service;

import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.repository.EventosRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EventosServiceTest {

    @Test
    void shouldDelegateSearchToRepositoryWithAllFilters() {
        EventosRepository repository = mock(EventosRepository.class);
        EventosService service = new EventosService(repository);
        LocalDateTime date = LocalDateTime.of(2025, 4, 10,4, 30);
        Eventos evento = new Eventos();
        evento.setId(4L);
        evento.setNome("Meia Maratona do Rio");
        evento.setData(date);
        evento.setLocalizacao("Rio de Janeiro");
        evento.setTipoEvento("Corrida de Rua");
        evento.setModalidade("Atletismo");
        List<Eventos> expected = List.of(
                evento
        );

        when(repository.searchEvents(date, "Rio de Janeiro", "Corrida de Rua", "Atletismo")).thenReturn(expected);

        List<Eventos> results = service.searchEvents(date, "Rio de Janeiro", "Corrida de Rua", "Atletismo");

        assertEquals(expected, results);
        verify(repository).searchEvents(date, "Rio de Janeiro", "Corrida de Rua", "Atletismo");
    }
}
