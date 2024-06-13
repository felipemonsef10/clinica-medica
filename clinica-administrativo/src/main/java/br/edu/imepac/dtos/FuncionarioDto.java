package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class FuncionarioDto {
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String telefone;
}
