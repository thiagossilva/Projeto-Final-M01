package tech.devinhouse.labschoolapi1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi1.exception.RegistroExistenteException;
import tech.devinhouse.labschoolapi1.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapi1.models.Pedagogo;
import tech.devinhouse.labschoolapi1.repositories.PedagogoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedagogoService {

    private PedagogoRepository pedagogoRepository;


    public List<Pedagogo> consultar() {
        return pedagogoRepository.findAll();
    }

    public Pedagogo consultar(Integer codigo) {
        Optional<Pedagogo> pedagogoOptional = pedagogoRepository.findById(codigo);
        if (pedagogoOptional.isPresent())
            return pedagogoOptional.get();
        throw new RegistroNaoEncontradoException("Pedagogo", codigo);
    }

    public Pedagogo criar(Pedagogo pedagogo) {
        Optional<Pedagogo> pedagogoExistente = pedagogoRepository.findByCpf(pedagogo.getCpf());

        if (pedagogoExistente.isPresent())
            throw new RegistroExistenteException("Pedagogo", pedagogo.getCpf().intValue());
        pedagogoRepository.save(pedagogo);
        return pedagogo;
    }
}