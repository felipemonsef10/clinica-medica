package br.edu.imepac.services;


import br.edu.imepac.dtos.PacienteCreateRequest;
import br.edu.imepac.dtos.PacienteDto;
import br.edu.imepac.models.PacienteModel;
import br.edu.imepac.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<PacienteDto> findAll() {
        List<PacienteModel> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(paciente -> {
            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(paciente.getId());
            pacienteDto.setNome(paciente.getNome());
            pacienteDto.setRg(paciente.getRg());
            pacienteDto.setCpf(paciente.getCpf());
            pacienteDto.setSexo(paciente.getSexo());
            pacienteDto.setNascimento(paciente.getNascimento());
            pacienteDto.setTelefone(paciente.getTelefone());
            pacienteDto.setEndereco(paciente.getEndereco());
            pacienteDto.setPossui_convenio(paciente.getPossui_convenio());
            pacienteDto.setConvenio(paciente.getConvenio());

            return pacienteDto;
        }).collect(Collectors.toList());
    }

    public PacienteDto update(Long id, PacienteDto pacienteDetails) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.findById(id);

        if (optionalPaciente.isPresent()) {
            PacienteModel pacienteModel = optionalPaciente.get();
            pacienteModel.setNome(pacienteDetails.getNome());
            pacienteModel.setRg(pacienteDetails.getRg());
            pacienteModel.setCpf(pacienteDetails.getCpf());
            pacienteModel.setSexo(pacienteDetails.getSexo());
            pacienteModel.setNascimento(pacienteDetails.getNascimento());
            pacienteModel.setTelefone(pacienteDetails.getTelefone());
            pacienteModel.setEndereco(pacienteDetails.getEndereco());
            pacienteModel.setPossui_convenio(pacienteDetails.getPossui_convenio());
            pacienteModel.setConvenio(pacienteDetails.getConvenio());

            PacienteModel updatedPaciente = pacienteRepository.save(pacienteModel);

            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(updatedPaciente.getId());
            pacienteDto.setNome(updatedPaciente.getNome());
            pacienteDto.setRg(updatedPaciente.getRg());
            pacienteDto.setCpf(updatedPaciente.getCpf());
            pacienteDto.setSexo(updatedPaciente.getSexo());
            pacienteDto.setNascimento(updatedPaciente.getNascimento());
            pacienteDto.setTelefone(updatedPaciente.getTelefone());
            pacienteDto.setEndereco(updatedPaciente.getEndereco());
            pacienteDto.setPossui_convenio(updatedPaciente.getPossui_convenio());
            pacienteDto.setConvenio(updatedPaciente.getConvenio());

            return pacienteDto;
        } else {
            return null;
        }
    }

    public PacienteDto save(PacienteCreateRequest pacienteRequest) {
        PacienteModel pacienteModel = new PacienteModel();
        pacienteModel.setNome(pacienteRequest.getNome());
        pacienteModel.setRg(pacienteRequest.getRg());
        pacienteModel.setCpf(pacienteRequest.getCpf());
        pacienteModel.setSexo(pacienteRequest.getSexo());
        pacienteModel.setNascimento(pacienteRequest.getNascimento());
        pacienteModel.setTelefone(pacienteRequest.getTelefone());
        pacienteModel.setEndereco(pacienteRequest.getEndereco());
        pacienteModel.setPossui_convenio(pacienteRequest.getPossui_convenio());
        pacienteModel.setConvenio(pacienteRequest.getConvenio());

        PacienteModel savedPaciente = pacienteRepository.save(pacienteModel);

        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(savedPaciente.getId());
        pacienteDto.setNome(savedPaciente.getNome());
        pacienteDto.setRg(savedPaciente.getRg());
        pacienteDto.setCpf(savedPaciente.getCpf());
        pacienteDto.setSexo(savedPaciente.getSexo());
        pacienteDto.setNascimento(savedPaciente.getNascimento());
        pacienteDto.setTelefone(savedPaciente.getTelefone());
        pacienteDto.setEndereco(savedPaciente.getEndereco());
        pacienteDto.setPossui_convenio(savedPaciente.getPossui_convenio());
        pacienteDto.setConvenio(savedPaciente.getConvenio());

        return pacienteDto;
    }

    public PacienteDto findById(Long id) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            PacienteModel pacienteModel = optionalPaciente.get();
            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(pacienteModel.getId());
            pacienteDto.setNome(pacienteModel.getNome());
            pacienteDto.setRg(pacienteModel.getRg());
            pacienteDto.setCpf(pacienteModel.getCpf());
            pacienteDto.setSexo(pacienteModel.getSexo());
            pacienteDto.setNascimento(pacienteModel.getNascimento());
            pacienteDto.setTelefone(pacienteModel.getTelefone());
            pacienteDto.setEndereco(pacienteModel.getEndereco());
            pacienteDto.setPossui_convenio(pacienteModel.getPossui_convenio());
            pacienteDto.setConvenio(pacienteModel.getConvenio());

            return pacienteDto;
        } else {
            return null;
        }
    }
}
