package service;

import br.com.fuctura.gestaoalugueis.repository.InquilinoRepository;
import dto.InquilinoDTO;
import model.Inquilino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    public void cadastrarInquilino(InquilinoDTO inquilinoDTO) {
        Inquilino inquilino = new Inquilino(inquilinoDTO);
        inquilinoRepository.save(inquilino);
    }

}
