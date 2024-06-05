package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class ConvenioCreateRequest {
    private String nome_rede;
    private String cnpj;
    private String inscricao_estadual;
}
