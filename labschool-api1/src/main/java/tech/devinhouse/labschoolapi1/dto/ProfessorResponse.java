package tech.devinhouse.labschoolapi1.dto;

import lombok.Data;
import tech.devinhouse.labschoolapi1.enums.EnumEstadoProfessor;
import tech.devinhouse.labschoolapi1.enums.EnumExpProfessor;
import tech.devinhouse.labschoolapi1.enums.EnumFormacaoProfessor;

import java.time.LocalDate;
@Data
public class ProfessorResponse {
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    private Long cpf;

    private EnumFormacaoProfessor formacaoProfessor;

    private EnumExpProfessor expProfessor;

    private EnumEstadoProfessor estadoProfessor;
}
