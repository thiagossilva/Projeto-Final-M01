package tech.devinhouse.labschoolapi1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschoolapi1.models.Aluno;
import tech.devinhouse.labschoolapi1.models.Professor;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    Optional<Professor> findByCpf(Long Cpf);
}
