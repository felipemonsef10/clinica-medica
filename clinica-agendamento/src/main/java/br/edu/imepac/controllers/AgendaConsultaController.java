package br.edu.imepac.controllers;

import br.edu.imepac.dtos.AgendaConsultaCreateRequest;
import br.edu.imepac.dtos.AgendaConsultaDto;
import br.edu.imepac.services.AgendaConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agenda")
public class AgendaConsultaController {

    @Autowired
    private AgendaConsultaService agendaConsultaService;


    @PostMapping
    public ResponseEntity<AgendaConsultaDto> saveAgenda(@RequestBody AgendaConsultaCreateRequest agendaConsultaCreateRequest) {
        AgendaConsultaDto savedAgenda = agendaConsultaService.save(agendaConsultaCreateRequest);
        return new ResponseEntity<>(savedAgenda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AgendaConsultaDto>> listAllAgendas() {
        List<AgendaConsultaDto> agendas = agendaConsultaService.findAll();
        return new ResponseEntity<>(agendas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AgendaConsultaDto> getAgendaById(@PathVariable Long id) {
        AgendaConsultaDto agendaConsultaDto = agendaConsultaService.findById(id);
        if (agendaConsultaDto != null) {
            return new ResponseEntity<>(agendaConsultaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AgendaConsultaDto> updateAgenda(@PathVariable Long id, @RequestBody AgendaConsultaDto agendaDetails) {
        AgendaConsultaDto updatedAgenda = agendaConsultaService.update(id, agendaDetails);
        if (updatedAgenda != null) {
            return new ResponseEntity<>(updatedAgenda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAgenda(@PathVariable Long id) {
        agendaConsultaService.delete(id);
    }
}
