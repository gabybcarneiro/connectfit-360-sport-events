package com.br.sportsevents.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_evento")
    private LocalDateTime dataEvento;

    @Column(length = 100)
    private String cidade;

    @Column(length = 100)
    private String estado;

    @Column(length = 100)
    private String pais;

    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "id_modalidade", nullable = false)
    private Integer idModalidade;

    @Column(name = "id_organizacao")
    private Integer idOrganizacao;

    @Column(name = "imagem_evento")
    private String imagemEvento;

    @Column(name = "inscricao_aberta")
    private Boolean inscricaoAberta;

    private Integer vagas;

    @Column(name = "vagas_disponiveis")
    private Integer vagasDisponiveis;

    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "usuario_inclusao")
    private String usuarioInclusao;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    @Column(name = "usuario_alteracao")
    private String usuarioAlteracao;
}
