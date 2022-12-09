package tech.devinhouse.labschoolapi1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.labschoolapi1.enums.EnumSituacaoAluno;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "alunos")
@NoArgsConstructor
public class Aluno extends Pessoa {

    @Enumerated(value = EnumType.STRING)
    private EnumSituacaoAluno situacao;
    private Float nota;
    private int atendimentos;

    public Aluno(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, EnumSituacaoAluno situacao, Float nota) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.situacao = situacao;
        this.nota = nota;
        this.atendimentos = 0;
    }
}