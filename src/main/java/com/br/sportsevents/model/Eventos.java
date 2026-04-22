package com.br.sportsevents.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false, length = 100)
    private String localizacao;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipoEvento;

    @Column(nullable = false, length = 100)
    private String modalidade;

    @Column(name= "data_inclusao", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name= "usuario_inclusao", nullable = false)
    private String usuarioInclusao;

    @Column(name= "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao;

    @Column(name= "usuario_alteracao", nullable = false)
    private String usuarioAlteracao;
}
