package tech.devinhouse.labschoolapi1.dto;

import lombok.Data;
import tech.devinhouse.labschoolapi1.enums.EnumSituacaoAluno;

@Data
public class AlunoAtendimentoRequest {
    private EnumSituacaoAluno situacaoAluno;
}
