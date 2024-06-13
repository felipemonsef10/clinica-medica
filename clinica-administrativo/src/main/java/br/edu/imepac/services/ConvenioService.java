package br.edu.imepac.services;

import br.edu.imepac.dtos.ConvenioCreateRequest;
import br.edu.imepac.dtos.ConvenioDto;
import br.edu.imepac.models.ConvenioModel;
import br.edu.imepac.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    public void delete(Long id) {
        convenioRepository.deleteById(id);
    }

    public List<ConvenioDto> findAll() {
        List<ConvenioModel> convenios = convenioRepository.findAll();
        return convenios.stream().map(convenio -> {
            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(convenio.getId());
            convenioDto.setNome_rede(convenio.getNome_rede());
            convenioDto.setCnpj(convenio.getCnpj());
            convenioDto.setInscricao_estadual(convenio.getInscricao_estadual());
            return convenioDto;
        }).collect(Collectors.toList());
    }

    public ConvenioDto update(Long id, ConvenioDto convenioDetails) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.findById(id);

        if (optionalConvenio.isPresent()) {
            ConvenioModel convenioModel = optionalConvenio.get();
            convenioModel.setNome_rede(convenioDetails.getNome_rede());
            convenioModel.setCnpj(convenioDetails.getCnpj());
            convenioModel.setInscricao_estadual(convenioDetails.getInscricao_estadual());

            ConvenioModel updatedConvenio = convenioRepository.save(convenioModel);

            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(updatedConvenio.getId());
            convenioDto.setNome_rede(updatedConvenio.getNome_rede());
            convenioDto.setCnpj(updatedConvenio.getCnpj());
            convenioDto.setInscricao_estadual(updatedConvenio.getInscricao_estadual());

            return convenioDto;
        } else {
            return null;
        }
    }

    public ConvenioDto save(ConvenioCreateRequest convenioRequest) {
        ConvenioModel convenioModel = new ConvenioModel();
        convenioModel.setNome_rede(convenioRequest.getNome_rede());
        convenioModel.setCnpj(convenioRequest.getCnpj());
        convenioModel.setInscricao_estadual(convenioRequest.getInscricao_estadual());

        ConvenioModel savedConvenio = convenioRepository.save(convenioModel);

        ConvenioDto convenioDto = new ConvenioDto();
        convenioDto.setId(savedConvenio.getId());
        convenioDto.setNome_rede(savedConvenio.getNome_rede());
        convenioDto.setCnpj(savedConvenio.getCnpj());
        convenioDto.setInscricao_estadual(savedConvenio.getInscricao_estadual());

        return convenioDto;
    }

    public ConvenioDto findById(Long id) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.findById(id);
        if (optionalConvenio.isPresent()) {
            ConvenioModel convenioModel = optionalConvenio.get();
            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(convenioModel.getId());
            convenioDto.setNome_rede(convenioModel.getNome_rede());
            convenioDto.setCnpj(convenioModel.getCnpj());
            convenioDto.setInscricao_estadual(convenioModel.getInscricao_estadual());
            return convenioDto;
        } else {
            return null;
        }
    }
}
