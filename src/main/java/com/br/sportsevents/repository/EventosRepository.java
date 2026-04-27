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
            WHERE (:date IS NULL OR e.dataEvento = :date)
              AND (CAST(:cidade AS string) IS NULL OR LOWER(e.cidade) = LOWER(CAST(:cidade AS string)))
              AND (:idTipo IS NULL OR e.idTipo = :idTipo)
              AND (:idModalidade IS NULL OR e.idModalidade = :idModalidade)
            ORDER BY e.dataEvento ASC, e.nome ASC
            """)
    List<Eventos> searchEvents(
            @Param("date") LocalDateTime date,
            @Param("cidade") String cidade,
            @Param("idTipo") Integer idTipo,
            @Param("idModalidade") Integer idModalidade
    );
}
