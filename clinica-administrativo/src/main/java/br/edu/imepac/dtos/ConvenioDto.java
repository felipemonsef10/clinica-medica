package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class ConvenioDto {
    private Long id;
    private String nome_rede;
    private String cnpj;
    private String inscricao_estadual;
}
