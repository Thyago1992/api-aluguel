package service;

import br.com.fuctura.gestaoalugueis.repository.ImovelRepository;
import dto.ImovelDTO;
import model.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public void cadastrarImovel(ImovelDTO imovelDTO) {
        Imovel imovel = new Imovel(imovelDTO);
        imovelRepository.save(imovel);
        // Lógica para cadastrar um imóvel
    }

}
