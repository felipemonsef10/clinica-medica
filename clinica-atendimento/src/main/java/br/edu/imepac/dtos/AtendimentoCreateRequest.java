package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class AtendimentoCreateRequest {
    private Long id;
    private Long id_paciente;
    private String crm_medico;
    private String prescricao_medica;
}