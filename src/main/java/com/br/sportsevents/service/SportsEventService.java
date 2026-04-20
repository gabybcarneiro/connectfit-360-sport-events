package com.br.sportsevents.service;

import com.sportsevents.model.SportsEvent;
import com.sportsevents.repository.SportsEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SportsEventService {

    @Autowired
    private SportsEventRepository sportsEventRepository;

    public SportsEventService(SportsEventRepository sportsEventRepository) {
        this.sportsEventRepository = sportsEventRepository;
    }

    public List<SportsEvent> searchEvents(LocalDate date, String location, String eventType, String modality) {
        return sportsEventRepository.searchEvents(date, location, eventType, modality);
    }
}
