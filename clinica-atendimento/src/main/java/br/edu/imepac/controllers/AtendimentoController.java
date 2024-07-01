package br.edu.imepac.controllers;

import br.edu.imepac.dtos.AtendimentoCreateRequest;
import br.edu.imepac.dtos.AtendimentoDto;
import br.edu.imepac.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;


    @PostMapping
    public ResponseEntity<AtendimentoDto> saveAtendimento(@RequestBody AtendimentoCreateRequest atendimentoCreateRequest) {
        AtendimentoDto savedAtendimento = atendimentoService.save(atendimentoCreateRequest);
        return new ResponseEntity<>(savedAtendimento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoDto>> listAllAtendimentos() {
        List<AtendimentoDto> atendimentos = atendimentoService.findAll();
        return new ResponseEntity<>(atendimentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AtendimentoDto> getAtendimentoById(@PathVariable Long id) {
        AtendimentoDto atendimentoDto = atendimentoService.findById(id);
        if (atendimentoDto != null) {
            return new ResponseEntity<>(atendimentoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AtendimentoDto> updateAtendimento(@PathVariable Long id, @RequestBody AtendimentoDto atendimentoDetails) {
        AtendimentoDto updatedAtendimento = atendimentoService.update(id, atendimentoDetails);
        if (updatedAtendimento != null) {
            return new ResponseEntity<>(updatedAtendimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAtendimento(@PathVariable Long id) {
        atendimentoService.delete(id);
    }
}
