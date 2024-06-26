package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class AgendaConsultaCreateRequest {
    private Long id_paciente;
    private String crm_medico;
    private String data;
    private String hora;
}