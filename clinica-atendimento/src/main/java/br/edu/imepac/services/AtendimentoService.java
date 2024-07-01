package br.edu.imepac.services;


import br.edu.imepac.dtos.AtendimentoCreateRequest;
import br.edu.imepac.dtos.AtendimentoDto;
import br.edu.imepac.models.AtendimentoModel;
import br.edu.imepac.repositories.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public void delete(Long id) {
        atendimentoRepository.deleteById(id);
    }

    public List<AtendimentoDto> findAll() {
        List<AtendimentoModel> atendimentos = atendimentoRepository.findAll();
        return atendimentos.stream().map(atendimento -> {
            AtendimentoDto atendimentoDto = new AtendimentoDto();
            atendimentoDto.setId(atendimento.getId());
            atendimentoDto.setId_paciente(atendimento.getId_paciente());
            atendimentoDto.setCrm_medico(atendimento.getCrm_medico());
            atendimentoDto.setPrescricao_medica(atendimento.getPrescricao_medica());

            return atendimentoDto;
        }).collect(Collectors.toList());
    }

    public AtendimentoDto update(Long id, AtendimentoDto atendimentoDetails) {
        Optional<AtendimentoModel> optionalAtendimento = atendimentoRepository.findById(id);

        if (optionalAtendimento.isPresent()) {
            AtendimentoModel atendimentoModel = optionalAtendimento.get();
            atendimentoModel.setId_paciente(atendimentoDetails.getId_paciente());
            atendimentoModel.setCrm_medico(atendimentoDetails.getCrm_medico());
            atendimentoModel.setPrescricao_medica(atendimentoDetails.getPrescricao_medica());

            AtendimentoModel updatedAtendimento = atendimentoRepository.save(atendimentoModel);

            AtendimentoDto atendimentoDto = new AtendimentoDto();
            atendimentoDto.setId(updatedAtendimento.getId());
            atendimentoDto.setId_paciente(updatedAtendimento.getId_paciente());
            atendimentoDto.setCrm_medico(updatedAtendimento.getCrm_medico());
            atendimentoDto.setPrescricao_medica(updatedAtendimento.getPrescricao_medica());

            return atendimentoDto;
        } else {
            return null;
        }
    }

    public AtendimentoDto save(AtendimentoCreateRequest atendimentoRequest) {
        AtendimentoModel atendimentoModel = new AtendimentoModel();
        atendimentoModel.setId_paciente(atendimentoRequest.getId_paciente());
        atendimentoModel.setCrm_medico(atendimentoRequest.getCrm_medico());
        atendimentoModel.setPrescricao_medica(atendimentoRequest.getPrescricao_medica());

        AtendimentoModel savedAtendimento = atendimentoRepository.save(atendimentoModel);

        AtendimentoDto atendimentoDto = new AtendimentoDto();
        atendimentoDto.setId(savedAtendimento.getId());
        atendimentoDto.setId_paciente(savedAtendimento.getId_paciente());
        atendimentoDto.setCrm_medico(savedAtendimento.getCrm_medico());
        atendimentoDto.setPrescricao_medica(savedAtendimento.getPrescricao_medica());

        return atendimentoDto;
    }

    public AtendimentoDto findById(Long id) {
        Optional<AtendimentoModel> optionalAtendimento = atendimentoRepository.findById(id);
        if (optionalAtendimento.isPresent()) {
            AtendimentoModel atendimentoModel = optionalAtendimento.get();
            AtendimentoDto atendimentoDto = new AtendimentoDto();
            atendimentoDto.setId(atendimentoModel.getId());
            atendimentoDto.setId_paciente(atendimentoModel.getId_paciente());
            atendimentoDto.setCrm_medico(atendimentoModel.getCrm_medico());
            atendimentoDto.setPrescricao_medica(atendimentoModel.getPrescricao_medica());

            return atendimentoDto;
        } else {
            return null;
        }
    }
}
