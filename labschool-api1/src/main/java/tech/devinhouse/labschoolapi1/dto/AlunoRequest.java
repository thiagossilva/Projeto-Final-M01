package tech.devinhouse.labschoolapi1.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import tech.devinhouse.labschoolapi1.enums.EnumSituacaoAluno;
import tech.devinhouse.labschoolapi1.validator.ValorEnum;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class AlunoRequest {

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 50, message = "{campo.invalido}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")

    private String telefone;

    @NotNull(message = "{campo.obrigatorio}")
    @Past(message = "{campo.invalido}")
    private LocalDate dataNascimento;

    @NotNull(message = "{campo.obrigatorio}")
    private Long cpf;

    @NotEmpty(message = "{campo.obrigatorio}")
    @ValorEnum(enumClass = EnumSituacaoAluno.class, message = "{campo.invalido}")
    private String situacao;

    @NotNull(message = "{campo.obrigatorio}")
    @DecimalMin(value = "0", message = "{campo.invalido}")
    @DecimalMax(value = "10", message = "{campo.invalido}")
    private Float nota;

}
