package tech.devinhouse.labschoolapi1.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoResponse {
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    private Long cpf;

    private String situacaoAluno;

    private Float nota;

    private int atendimentos;

}
