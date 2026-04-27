package com.br.sportsevents.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "modalidade")
public class Modalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(name= "data_inc", nullable = false)
    private LocalDateTime dataInclusao;

    @Column(name= "usuario_inc", nullable = false)
    private String usuarioInclusao;

}
