package br.edu.imepac.repositories;

import br.edu.imepac.models.AgendaConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaConsultaRepository extends JpaRepository<AgendaConsultaModel, Long> {

}
