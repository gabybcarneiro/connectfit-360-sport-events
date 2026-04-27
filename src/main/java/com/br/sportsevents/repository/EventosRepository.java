package com.br.sportsevents.repository;

import com.br.sportsevents.model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventosRepository extends JpaRepository<Eventos, Long> {

    @Query("""
            SELECT e
            FROM Eventos e
            WHERE (:date IS NULL OR e.data = :date)
              AND (:location IS NULL OR LOWER(e.localizacao) = LOWER(:location))
              AND (:eventType IS NULL OR LOWER(e.tipoEvento) = LOWER(:eventType))
              AND (:modality IS NULL OR LOWER(e.modalidade) = LOWER(:modality))
            ORDER BY e.data ASC, e.nome ASC
            """)
    List<Eventos> searchEvents(
            @Param("date") LocalDateTime date,
            @Param("location") String location,
            @Param("eventType") String eventType,
            @Param("modality") Integer modality
    );
}
