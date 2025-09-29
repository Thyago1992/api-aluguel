package br.com.fuctura.gestaoalugueis.service;

import br.com.fuctura.gestaoalugueis.dto.AluguelAtrasadoDTO;
import br.com.fuctura.gestaoalugueis.repository.AluguelRepository;
import br.com.fuctura.gestaoalugueis.dto.AluguelDTO;

import br.com.fuctura.gestaoalugueis.model.Aluguel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AluguelService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AluguelRepository aluguelRepository;

    public AluguelDTO criarAluguel(AluguelDTO aluguelDTO) {
        Aluguel aluguel = modelMapper.map(aluguelDTO, Aluguel.class); // ✅ ModelMapper
        Aluguel salvo = aluguelRepository.save(aluguel);
        return modelMapper.map(salvo, AluguelDTO.class); // ✅ ModelMapper
    }

    public List<AluguelAtrasadoDTO> listarAlugueisAtrasados() {
        LocalDate hoje = LocalDate.now();

        // 1. Busca os Aluguéis (retorna List<Aluguel>)
        List<Aluguel> alugueisAtrasadosEntity = aluguelRepository.findByPagoFalseAndDataVencimentoLessThanEqual(hoje);

        // 2. Mapeamento e Coleta
        return alugueisAtrasadosEntity.stream()
                // Inicia o mapeamento de Aluguel para AluguelAtrasadoDTO
                .map(aluguel -> {
                    // Cálculo dos dias em atraso
                    long dias = ChronoUnit.DAYS.between(aluguel.getDataVencimento(), hoje);
                    Integer diasEmAtraso = (int) dias;

                    // Retorna a nova instância do DTO
                    return new AluguelAtrasadoDTO(
                            aluguel.getId(),
                            aluguel.getInquilino().getNome(),
                            aluguel.getImovel().getDescricao(),
                            aluguel.getValor(),
                            diasEmAtraso
                    );
                })
                // 3. Coleta o resultado em uma List<AluguelAtrasadoDTO>
                .collect(Collectors.toList());
    }

    public boolean marcarComoPago(Long aluguelId) {
        if (aluguelId == null) {
            return false;
        }

        Optional<Aluguel> aluguelOpt = aluguelRepository.findById(aluguelId);

        if (aluguelOpt.isPresent()) {
            Aluguel aluguel = aluguelOpt.get();
            aluguel.setPago(true);
            aluguelRepository.save(aluguel);
            return true;
        }
        return false;
    }

}
