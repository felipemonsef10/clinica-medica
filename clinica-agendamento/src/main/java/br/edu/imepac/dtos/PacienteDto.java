package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class PacienteDto {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String endereco;
    private String sexo;
    private String nascimento;
    private String possui_convenio;
    private String convenio;
}
