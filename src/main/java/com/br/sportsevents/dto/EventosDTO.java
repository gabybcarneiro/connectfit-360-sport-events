package com.br.sportsevents.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EventosDTO {

    private Long id;
    private String nome;
    private LocalDateTime dataEvento;
    private Integer distancia;
    private String localizacao;
    private String tipoEvento;
    private Integer modalidade;
    private LocalDateTime dataInclusao;
    private String usuarioInclusao;
    private LocalDateTime dataAlteracao;
    private String usuarioAlteracao;
    private Boolean inscricaoAberta;
    private Integer vagas;
    private Integer vagasRestantes;
    private OrganizadorDTO organizador;

}
