package tech.devinhouse.labschoolapi1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschoolapi1.models.Aluno;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {



    Optional<Aluno> findByCpf(Long Cpf);
}
