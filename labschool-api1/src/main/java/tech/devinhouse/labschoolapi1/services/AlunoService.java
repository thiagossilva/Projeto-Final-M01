package tech.devinhouse.labschoolapi1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi1.enums.EnumSituacaoAluno;
import tech.devinhouse.labschoolapi1.exception.RegistroExistenteException;
import tech.devinhouse.labschoolapi1.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapi1.models.Aluno;
import tech.devinhouse.labschoolapi1.repositories.AlunoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;


    public List<Aluno> consultar() {
        return alunoRepository.findAll();
    }

    public List<Aluno> consultar(String situacaoAluno) {
        List<Aluno> alunosSituacao = alunoRepository.findAll();
        List<Aluno> listaAlunosSituacao = new ArrayList<>();
        for (Aluno aluno : alunosSituacao) {
            if (aluno.getSituacao().toString().equals(situacaoAluno))
                listaAlunosSituacao.add(aluno);
        }
        return listaAlunosSituacao;
    }

    public Aluno consultar(Integer codigo) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(codigo);
        if (alunoOptional.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", codigo);
        return alunoOptional.get();
    }

    public Aluno criar(Aluno aluno) {
        Optional<Aluno> alunoExistente = alunoRepository.findByCpf(aluno.getCpf());
        if (alunoExistente.isPresent())
            throw new RegistroExistenteException("Aluno", aluno.getCpf().intValue());
        alunoRepository.save(aluno);
        return aluno;
    }

    public Aluno atualizarSituacao(Integer codigo, EnumSituacaoAluno situacaoAluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(codigo);
        if (alunoOptional.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", codigo);
        Aluno alunoSituacao = alunoOptional.get();
        alunoSituacao.setSituacao(situacaoAluno);
        alunoRepository.save(alunoSituacao);
        return alunoSituacao;
    }

    public void excluir(Integer codigo) {
        boolean alunoExistente = alunoRepository.existsById(codigo);
        if (!alunoExistente)
            throw new RegistroNaoEncontradoException("Aluno", codigo);

        alunoRepository.deleteById(codigo);
    }
}
