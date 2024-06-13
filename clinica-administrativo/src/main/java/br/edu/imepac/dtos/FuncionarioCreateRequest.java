package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class FuncionarioCreateRequest {
    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String telefone;
}