package com.br.sportsevents.repository;

import com.br.sportsevents.model.SportsEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SportsEventRepository extends JpaRepository<SportsEvent, Long> {

    @Query("""
            SELECT e
            FROM SportsEvent e
            WHERE (:date IS NULL OR e.date = :date)
              AND (:location IS NULL OR LOWER(e.location) = LOWER(:location))
              AND (:eventType IS NULL OR LOWER(e.eventType) = LOWER(:eventType))
              AND (:modality IS NULL OR LOWER(e.modality) = LOWER(:modality))
            ORDER BY e.date ASC, e.name ASC
            """)
    List<SportsEvent> searchEvents(
            @Param("date") LocalDate date,
            @Param("location") String location,
            @Param("eventType") String eventType,
            @Param("modality") String modality
    );
}
