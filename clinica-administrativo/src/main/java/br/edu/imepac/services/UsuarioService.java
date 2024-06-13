package br.edu.imepac.services;

import br.edu.imepac.dtos.UsuarioCreateRequest;
import br.edu.imepac.dtos.UsuarioDto;
import br.edu.imepac.models.UsuarioModel;
import br.edu.imepac.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioDto> findAll() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNome(usuario.getNome());
            usuarioDto.setCpf(usuario.getCpf());

            return usuarioDto;
        }).collect(Collectors.toList());
    }

    public UsuarioDto update(Long id, UsuarioDto usuarioDetails) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            UsuarioModel usuarioModel = optionalUsuario.get();
            usuarioModel.setNome(usuarioDetails.getNome());
            usuarioModel.setCpf(usuarioDetails.getCpf());

            UsuarioModel updatedUsuario = usuarioRepository.save(usuarioModel);

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(updatedUsuario.getId());
            usuarioDto.setNome(updatedUsuario.getNome());
            usuarioDto.setCpf(updatedUsuario.getCpf());

            return usuarioDto;
        } else {
            return null;
        }
    }

    public UsuarioDto save(UsuarioCreateRequest usuarioRequest) {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioRequest.getNome());
        usuarioModel.setCpf(usuarioRequest.getCpf());
        usuarioModel.setLogin(usuarioRequest.getLogin());
        usuarioModel.setSenha(usuarioRequest.getSenha());

        UsuarioModel savedUsuario = usuarioRepository.save(usuarioModel);

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(savedUsuario.getId());
        usuarioDto.setNome(savedUsuario.getNome());
        usuarioDto.setCpf(savedUsuario.getCpf());

        return usuarioDto;
    }

    public UsuarioDto findById(Long id) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            UsuarioModel usuarioModel = optionalUsuario.get();
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuarioModel.getId());
            usuarioDto.setNome(usuarioModel.getNome());
            usuarioDto.setCpf(usuarioModel.getCpf());
            return usuarioDto;
        } else {
            return null;
        }
    }
}
