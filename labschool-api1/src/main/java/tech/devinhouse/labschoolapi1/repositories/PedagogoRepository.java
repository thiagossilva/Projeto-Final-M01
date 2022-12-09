package tech.devinhouse.labschoolapi1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschoolapi1.models.Aluno;
import tech.devinhouse.labschoolapi1.models.Pedagogo;

import java.util.Optional;

@Repository
public interface PedagogoRepository extends JpaRepository<Pedagogo, Integer> {
    Optional<Pedagogo> findByCpf(Long Cpf);
}
