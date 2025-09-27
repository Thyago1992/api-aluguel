package service;

import br.com.fuctura.gestaoalugueis.repository.AluguelRepository;
import dto.AluguelDTO;
import model.Aluguel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public void CriarAluguel(AluguelDTO aluguelDTO) {
        Aluguel aluguel = new Aluguel(aluguelDTO);
        aluguelRepository.save(aluguel);
    }

    public List<AluguelDTO> listarAlugueisAtrasados() {
        LocalDate hoje = LocalDate.now();

        // Busca aluguéis com vencimento < hoje e pago = false
        List<Aluguel> alugueisAtrasados = aluguelRepository
                .findByDataVencimentoBeforeAndPagoFalse(hoje);

        return alugueisAtrasados.stream()
                .map(AluguelDTO::new)
                .collect(Collectors.toList());
    }

    public boolean marcarComoPago(AluguelDTO aluguelDTO) {
        // Pega o ID do DTO
        Long aluguelId = aluguelDTO.getId();

        if (aluguelId == null) {
            return false; // ID não fornecido
        }

        Optional<Aluguel> aluguelOpt = aluguelRepository.findById(aluguelId);

        if (aluguelOpt.isPresent()) {
            Aluguel aluguel = aluguelOpt.get();
            aluguel.setPago(true);
            aluguelRepository.save(aluguel);

            // Atualiza o DTO também (opcional)
            aluguelDTO.setPago(true);

            return true; // Sucesso
        }
        return false; // Aluguel não encontrado
    }

}
