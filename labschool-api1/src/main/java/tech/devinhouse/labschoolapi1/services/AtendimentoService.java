package tech.devinhouse.labschoolapi1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi1.enums.EnumSituacaoAluno;
import tech.devinhouse.labschoolapi1.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapi1.models.Aluno;
import tech.devinhouse.labschoolapi1.models.Pedagogo;
import tech.devinhouse.labschoolapi1.repositories.AlunoRepository;
import tech.devinhouse.labschoolapi1.repositories.PedagogoRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AtendimentoService {

    private AlunoRepository alunoRepository;
    private PedagogoRepository pedagogoRepository;

    public void atendimentoPedagogico(Integer codigoAluno, Integer codigoPedagogo) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(codigoAluno);
        Optional<Pedagogo> pedagogoOptional = pedagogoRepository.findById(codigoPedagogo);

        if (alunoOptional.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", codigoAluno);
        if (pedagogoOptional.isEmpty())
            throw new RegistroNaoEncontradoException("Pedagogo", codigoPedagogo);
        Aluno alunoAtualizado = alunoOptional.get();
        Pedagogo pegadodoAtualizado = pedagogoOptional.get();
        alunoAtualizado.setSituacao(EnumSituacaoAluno.ATENDIMENTO_PEDAGOGICO);
        alunoAtualizado.setAtendimentos(alunoAtualizado.getAtendimentos()+1);
        pegadodoAtualizado.setAtendimentos(pegadodoAtualizado.getAtendimentos()+1);
        Aluno alunoAtendimentoRealizado = alunoRepository.save(alunoAtualizado);
        Pedagogo pegadodoAtentimentoRealizado = pedagogoRepository.save(pegadodoAtualizado);
    }
}
