package br.com.fuctura.gestaoalugueis.service;

import br.com.fuctura.gestaoalugueis.repository.ImovelRepository;
import br.com.fuctura.gestaoalugueis.dto.ImovelDTO;
import br.com.fuctura.gestaoalugueis.model.Imovel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ImovelDTO cadastrarImovel(ImovelDTO imovelDTO) {
        Imovel imovel = modelMapper.map(imovelDTO, Imovel.class);
        Imovel salvo = imovelRepository.save(imovel);
        return modelMapper.map(salvo, ImovelDTO.class);
    }

}
