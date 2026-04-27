package com.br.sportsevents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventosDTO {

    private Long id;
    private String nome;
    private LocalDateTime dataEvento;
    private String cidade;
    private String estado;
    private String pais;
    private Integer idTipo;
    private Integer idModalidade;
    private Integer idOrganizacao;
    private String imagemEvento;
    private Boolean inscricaoAberta;
    private Integer vagas;
    private Integer vagasDisponiveis;
    private LocalDateTime dataInclusao;
    private String usuarioInclusao;
    private LocalDateTime dataAlteracao;
    private String usuarioAlteracao;
}
