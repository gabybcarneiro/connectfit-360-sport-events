package com.br.sportsevents.service;

import com.br.sportsevents.model.SportsEvent;
import com.br.sportsevents.repository.SportsEventRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SportsEventServiceTest {

    @Test
    void shouldDelegateSearchToRepositoryWithAllFilters() {
        SportsEventRepository repository = mock(SportsEventRepository.class);
        SportsEventService service = new SportsEventService(repository);
        LocalDate date = LocalDate.of(2025, 4, 10);
        List<SportsEvent> expected = List.of(
                new SportsEvent(4L, "Meia Maratona do Rio", date, "Rio de Janeiro", "Corrida de Rua", "Atletismo")
        );

        when(repository.searchEvents(date, "Rio de Janeiro", "Corrida de Rua", "Atletismo")).thenReturn(expected);

        List<SportsEvent> results = service.searchEvents(date, "Rio de Janeiro", "Corrida de Rua", "Atletismo");

        assertEquals(expected, results);
        verify(repository).searchEvents(date, "Rio de Janeiro", "Corrida de Rua", "Atletismo");
    }
}
