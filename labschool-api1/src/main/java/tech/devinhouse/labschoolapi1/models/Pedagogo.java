package tech.devinhouse.labschoolapi1.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "pedagogos")
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa {

    private int atendimentos;

    public Pedagogo(Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.atendimentos = 0;
    }
}