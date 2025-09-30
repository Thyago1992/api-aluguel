package br.com.fuctura.gestaoalugueis.service;

import br.com.fuctura.gestaoalugueis.dto.AluguelAtrasadoDTO;
import br.com.fuctura.gestaoalugueis.exception.ResourceNotFoundException;
import br.com.fuctura.gestaoalugueis.repository.AluguelRepository;
import br.com.fuctura.gestaoalugueis.dto.AluguelDTO;
import br.com.fuctura.gestaoalugueis.model.Aluguel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AluguelService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AluguelRepository aluguelRepository;

    public AluguelDTO criarAluguel(AluguelDTO aluguelDTO) {
        // Valida se o imóvel foi informado
        if (aluguelDTO.getImovel() == null || aluguelDTO.getImovel().getId() == null) {
            throw new IllegalArgumentException("Imóvel é obrigatório");
        }

        Aluguel aluguel = modelMapper.map(aluguelDTO, Aluguel.class);
        Aluguel salvo = aluguelRepository.save(aluguel);
        return modelMapper.map(salvo, AluguelDTO.class);
    }

    public List<AluguelAtrasadoDTO> listarAlugueisAtrasados() {
        LocalDate hoje = LocalDate.now();

        List<Aluguel> alugueisAtrasadosEntity =
                aluguelRepository.findByPagoFalseAndDataVencimentoLessThanEqual(hoje);

        return alugueisAtrasadosEntity.stream()
                .map(aluguel -> {
                    long dias = ChronoUnit.DAYS.between(aluguel.getDataVencimento(), hoje);
                    Integer diasEmAtraso = (int) dias;

                    // Trata casos onde inquilino pode ser null
                    String nomeInquilino = aluguel.getInquilino() != null
                            ? aluguel.getInquilino().getNome()
                            : "Sem inquilino";

                    return new AluguelAtrasadoDTO(
                            aluguel.getId(),
                            nomeInquilino,
                            aluguel.getImovel().getDescricao(),
                            aluguel.getValor(),
                            diasEmAtraso
                    );
                })
                .collect(Collectors.toList());
    }

    public AluguelDTO marcarComoPago(Long aluguelId) {
        if (aluguelId == null) {
            throw new IllegalArgumentException("ID do aluguel não pode ser nulo");
        }

        Aluguel aluguel = aluguelRepository.findById(aluguelId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel", aluguelId));

        aluguel.setPago(true);
        Aluguel atualizado = aluguelRepository.save(aluguel);

        return modelMapper.map(atualizado, AluguelDTO.class);
    }
}