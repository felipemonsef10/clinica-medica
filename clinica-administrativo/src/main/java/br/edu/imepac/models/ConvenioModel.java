package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "convenios")
@Data
public class ConvenioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_rede;
    private String cnpj;
    private String inscricao_estadual;
}
