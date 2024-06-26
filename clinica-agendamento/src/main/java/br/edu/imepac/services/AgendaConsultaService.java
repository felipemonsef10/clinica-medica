package br.edu.imepac.services;


import br.edu.imepac.dtos.AgendaConsultaCreateRequest;
import br.edu.imepac.dtos.AgendaConsultaDto;
import br.edu.imepac.models.AgendaConsultaModel;
import br.edu.imepac.repositories.AgendaConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaConsultaService {

    @Autowired
    private AgendaConsultaRepository agendaConsultaRepository;

    public void delete(Long id) {
        agendaConsultaRepository.deleteById(id);
    }

    public List<AgendaConsultaDto> findAll() {
        List<AgendaConsultaModel> agendas = agendaConsultaRepository.findAll();
        return agendas.stream().map(agenda -> {
            AgendaConsultaDto agendaConsultaDto = new AgendaConsultaDto();
            agendaConsultaDto.setId(agenda.getId());
            agendaConsultaDto.setId_paciente(agenda.getId_paciente());
            agendaConsultaDto.setCrm_medico(agenda.getCrm_medico());
            agendaConsultaDto.setData(agenda.getData());
            agendaConsultaDto.setHora(agenda.getHora());

            return agendaConsultaDto;
        }).collect(Collectors.toList());
    }

    public AgendaConsultaDto update(Long id, AgendaConsultaDto agendaDetails) {
        Optional<AgendaConsultaModel> optionalAgenda = agendaConsultaRepository.findById(id);

        if (optionalAgenda.isPresent()) {
            AgendaConsultaModel agendaConsultaModel = optionalAgenda.get();
            agendaConsultaModel.setId_paciente(agendaDetails.getId_paciente());
            agendaConsultaModel.setCrm_medico(agendaDetails.getCrm_medico());
            agendaConsultaModel.setData(agendaDetails.getData());
            agendaConsultaModel.setHora(agendaDetails.getHora());

            AgendaConsultaModel updatedAgenda = agendaConsultaRepository.save(agendaConsultaModel);

            AgendaConsultaDto agendaConsultaDto = new AgendaConsultaDto();
            agendaConsultaDto.setId(updatedAgenda.getId());
            agendaConsultaDto.setId_paciente(updatedAgenda.getId_paciente());
            agendaConsultaDto.setCrm_medico(updatedAgenda.getCrm_medico());
            agendaConsultaDto.setData(updatedAgenda.getData());
            agendaConsultaDto.setHora(updatedAgenda.getHora());

            return agendaConsultaDto;
        } else {
            return null;
        }
    }

    public AgendaConsultaDto save(AgendaConsultaCreateRequest agendaRequest) {
        AgendaConsultaModel agendaConsultaModel = new AgendaConsultaModel();
        agendaConsultaModel.setId_paciente(agendaRequest.getId_paciente());
        agendaConsultaModel.setCrm_medico(agendaRequest.getCrm_medico());
        agendaConsultaModel.setData(agendaRequest.getData());
        agendaConsultaModel.setHora(agendaRequest.getHora());

        AgendaConsultaModel savedAgenda = agendaConsultaRepository.save(agendaConsultaModel);

        AgendaConsultaDto agendaConsultaDto = new AgendaConsultaDto();
        agendaConsultaDto.setId(savedAgenda.getId());
        agendaConsultaDto.setId_paciente(savedAgenda.getId_paciente());
        agendaConsultaDto.setCrm_medico(savedAgenda.getCrm_medico());
        agendaConsultaDto.setData(savedAgenda.getData());
        agendaConsultaDto.setHora(savedAgenda.getHora());

        return agendaConsultaDto;
    }

    public AgendaConsultaDto findById(Long id) {
        Optional<AgendaConsultaModel> optionalAgenda = agendaConsultaRepository.findById(id);
        if (optionalAgenda.isPresent()) {
            AgendaConsultaModel agendaConsultaModel = optionalAgenda.get();
            AgendaConsultaDto agendaConsultaDto = new AgendaConsultaDto();
            agendaConsultaDto.setId(agendaConsultaModel.getId());
            agendaConsultaDto.setId_paciente(agendaConsultaModel.getId_paciente());
            agendaConsultaDto.setCrm_medico(agendaConsultaModel.getCrm_medico());
            agendaConsultaDto.setData(agendaConsultaModel.getData());
            agendaConsultaDto.setHora(agendaConsultaModel.getHora());

            return agendaConsultaDto;
        } else {
            return null;
        }
    }
}
