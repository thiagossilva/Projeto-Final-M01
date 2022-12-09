package tech.devinhouse.labschoolapi1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi1.exception.RegistroExistenteException;
import tech.devinhouse.labschoolapi1.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapi1.models.Pedagogo;
import tech.devinhouse.labschoolapi1.models.Professor;
import tech.devinhouse.labschoolapi1.repositories.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {

    private ProfessorRepository professorRepository;


    public List<Professor> consultar() {
        return professorRepository.findAll();
    }

    public Professor criar(Professor professor) {
        Optional<Professor> professorExistente = professorRepository.findByCpf(professor.getCpf());
        if (professorExistente.isPresent())
            throw new RegistroExistenteException("Professor", professor.getCpf().intValue());
        professorRepository.save(professor);
        return professor;
    }




}

