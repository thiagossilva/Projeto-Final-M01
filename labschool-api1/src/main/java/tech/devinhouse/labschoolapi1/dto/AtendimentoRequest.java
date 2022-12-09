package tech.devinhouse.labschoolapi1.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AtendimentoRequest {

    @NotNull(message = "{campo.obrigatorio}")
    private Integer codigoAluno;

    @NotNull(message = "{campo.obrigatorio}")
    private Integer codigoPedagogo;
}
