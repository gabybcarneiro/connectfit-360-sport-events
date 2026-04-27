package com.br.sportsevents.repository;

import com.br.sportsevents.model.Eventos;
import com.br.sportsevents.model.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {


}
