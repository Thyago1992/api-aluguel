package br.com.fuctura.gestaoalugueis.service;

import br.com.fuctura.gestaoalugueis.dto.InquilinoDTO;
import br.com.fuctura.gestaoalugueis.exception.DuplicateResourceException;
import br.com.fuctura.gestaoalugueis.model.Inquilino;
import br.com.fuctura.gestaoalugueis.repository.InquilinoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquilinoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InquilinoRepository inquilinoRepository;

    public InquilinoDTO cadastrarInquilino(InquilinoDTO inquilinoDTO) {
        // Valida duplicidade de email apenas se foi informado
        if (inquilinoDTO.getEmail() != null &&
                !inquilinoDTO.getEmail().isBlank() &&
                inquilinoRepository.existsByEmail(inquilinoDTO.getEmail())) {
            throw new DuplicateResourceException(
                    "Já existe um inquilino cadastrado com o email: " + inquilinoDTO.getEmail()
            );
        }

        Inquilino inquilino = modelMapper.map(inquilinoDTO, Inquilino.class);
        Inquilino salvo = inquilinoRepository.save(inquilino);
        return modelMapper.map(salvo, InquilinoDTO.class);
    }
}