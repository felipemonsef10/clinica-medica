package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "agenda_consultas")
@Data
public class AgendaConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_paciente;
    private String crm_medico;
    private String data;
    private String hora;
}
