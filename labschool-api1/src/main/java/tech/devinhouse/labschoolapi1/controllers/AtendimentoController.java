package tech.devinhouse.labschoolapi1.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labschoolapi1.dto.AlunoResponse;
import tech.devinhouse.labschoolapi1.dto.AtendimentoRequest;
import tech.devinhouse.labschoolapi1.dto.AtendimentoResponse;
import tech.devinhouse.labschoolapi1.dto.PedagogoResponse;
import tech.devinhouse.labschoolapi1.models.Aluno;
import tech.devinhouse.labschoolapi1.models.Pedagogo;
import tech.devinhouse.labschoolapi1.services.AlunoService;
import tech.devinhouse.labschoolapi1.services.AtendimentoService;
import tech.devinhouse.labschoolapi1.services.PedagogoService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor
public class AtendimentoController {

    private ModelMapper modelMapper;

    private AtendimentoService atendimentoService;

    private AlunoService alunoService;

    private PedagogoService pedagogoService;

    @PutMapping()
    public ResponseEntity<AtendimentoResponse> atendimento(@RequestBody @Valid AtendimentoRequest atendimentoRequest) {
        atendimentoService.atendimentoPedagogico(atendimentoRequest.getCodigoAluno(), atendimentoRequest.getCodigoPedagogo());
        Aluno alunoAtendimento = alunoService.consultar(atendimentoRequest.getCodigoAluno());
        Pedagogo pedagogoAtendimento = pedagogoService.consultar(atendimentoRequest.getCodigoPedagogo());

        AlunoResponse alunoResponse = modelMapper.map(alunoAtendimento, AlunoResponse.class);
        PedagogoResponse pedagogoResponse = modelMapper.map(pedagogoAtendimento, PedagogoResponse.class);

        AtendimentoResponse atendimento = new AtendimentoResponse(alunoResponse, pedagogoResponse);
        return ResponseEntity.ok(atendimento);
    }

}
