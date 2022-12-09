package tech.devinhouse.labschoolapi1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoResponse {

    private AlunoResponse alunoResponse;

    private PedagogoResponse pedagogoResponse;
}
