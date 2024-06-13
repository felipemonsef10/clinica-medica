package br.edu.imepac.services;

import br.edu.imepac.dtos.FuncionarioCreateRequest;
import br.edu.imepac.dtos.FuncionarioDto;
import br.edu.imepac.models.FuncionarioModel;
import br.edu.imepac.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<FuncionarioDto> findAll() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(funcionario -> {
            FuncionarioDto funcionarioDto = new FuncionarioDto();
            funcionarioDto.setId(funcionario.getId());
            funcionarioDto.setNome(funcionario.getNome());
            funcionarioDto.setRg(funcionario.getRg());
            funcionarioDto.setCpf(funcionario.getCpf());
            funcionarioDto.setEndereco(funcionario.getEndereco());
            funcionarioDto.setTelefone(funcionario.getTelefone());
            return funcionarioDto;
        }).collect(Collectors.toList());
    }

    public FuncionarioDto update(Long id, FuncionarioDto funcionarioDetails) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.findById(id);

        if (optionalFuncionario.isPresent()) {
            FuncionarioModel funcionarioModel = optionalFuncionario.get();
            funcionarioModel.setNome(funcionarioDetails.getNome());
            funcionarioModel.setRg(funcionarioDetails.getRg());
            funcionarioModel.setCpf(funcionarioDetails.getCpf());
            funcionarioModel.setEndereco(funcionarioDetails.getEndereco());
            funcionarioModel.setTelefone(funcionarioDetails.getTelefone());

            FuncionarioModel updatedFuncionario = funcionarioRepository.save(funcionarioModel);

            FuncionarioDto funcionarioDto = new FuncionarioDto();
            funcionarioDto.setId(updatedFuncionario.getId());
            funcionarioDto.setNome(updatedFuncionario.getNome());
            funcionarioDto.setRg(updatedFuncionario.getRg());
            funcionarioDto.setCpf(updatedFuncionario.getCpf());
            funcionarioDto.setEndereco(updatedFuncionario.getEndereco());
            funcionarioDto.setTelefone(updatedFuncionario.getTelefone());

            return funcionarioDto;
        } else {
            return null;
        }
    }

    public FuncionarioDto save(FuncionarioCreateRequest funcionarioRequest) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setNome(funcionarioRequest.getNome());
        funcionarioModel.setRg(funcionarioRequest.getRg());
        funcionarioModel.setCpf(funcionarioRequest.getCpf());
        funcionarioModel.setEndereco(funcionarioRequest.getEndereco());
        funcionarioModel.setTelefone(funcionarioRequest.getTelefone());

        FuncionarioModel savedFuncionario = funcionarioRepository.save(funcionarioModel);

        FuncionarioDto funcionarioDto = new FuncionarioDto();
        funcionarioDto.setId(savedFuncionario.getId());
        funcionarioDto.setNome(savedFuncionario.getNome());
        funcionarioDto.setRg(savedFuncionario.getRg());
        funcionarioDto.setCpf(savedFuncionario.getCpf());
        funcionarioDto.setEndereco(savedFuncionario.getEndereco());
        funcionarioDto.setTelefone(savedFuncionario.getTelefone());

        return funcionarioDto;
    }

    public FuncionarioDto findById(Long id) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            FuncionarioModel funcionarioModel = optionalFuncionario.get();
            FuncionarioDto funcionarioDto = new FuncionarioDto();
            funcionarioDto.setId(funcionarioModel.getId());
            funcionarioDto.setNome(funcionarioModel.getNome());
            funcionarioDto.setRg(funcionarioModel.getRg());
            funcionarioDto.setCpf(funcionarioModel.getCpf());
            funcionarioDto.setEndereco(funcionarioModel.getEndereco());
            funcionarioDto.setTelefone(funcionarioModel.getTelefone());

            return funcionarioDto;
        } else {
            return null;
        }
    }
}
