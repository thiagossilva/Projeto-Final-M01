package tech.devinhouse.labschoolapi1.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.labschoolapi1.enums.EnumExpProfessor;
import tech.devinhouse.labschoolapi1.enums.EnumFormacaoProfessor;
import tech.devinhouse.labschoolapi1.enums.EnumEstadoProfessor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "professores")
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Pessoa{

    @Enumerated(value = EnumType.STRING)
    private EnumFormacaoProfessor formacao;

    @Enumerated(value = EnumType.STRING)
    private EnumExpProfessor experiencia;

    @Enumerated(value = EnumType.STRING)
    private EnumEstadoProfessor estado;

    public Professor(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, EnumEstadoProfessor estadoProfessor, EnumExpProfessor expProfessor, EnumFormacaoProfessor formacaoProfessor) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.estado = estadoProfessor;
        this.experiencia = expProfessor;
        this.formacao = formacaoProfessor;
    }
}
