package tech.devinhouse.labschoolapi1.controllers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschoolapi1.dto.AlunoAtendimentoRequest;
import tech.devinhouse.labschoolapi1.dto.AlunoRequest;
import tech.devinhouse.labschoolapi1.dto.AlunoResponse;
import tech.devinhouse.labschoolapi1.enums.EnumSituacaoAluno;
import tech.devinhouse.labschoolapi1.models.Aluno;
import tech.devinhouse.labschoolapi1.services.AlunoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listar(@RequestParam (value = "situacao", required = false) String situacaoAluno) {
        List<Aluno> alunos;
        if (situacaoAluno == null) {
            alunos = alunoService.consultar();
        }
         else {
             alunos = alunoService.consultar(situacaoAluno);
        }
        List<AlunoResponse> resp = new ArrayList<>();
        for(Aluno aluno: alunos) {
            AlunoResponse alunoResponse = modelMapper.map(aluno, AlunoResponse.class);
            resp.add(alunoResponse);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<AlunoResponse> listar(@PathVariable("codigo") Integer codigo) {
        Aluno aluno = alunoService.consultar(codigo);
        AlunoResponse alunoResponse = modelMapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(alunoResponse);
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@RequestBody @Valid AlunoRequest alunoRequest) {
        Aluno aluno = modelMapper.map(alunoRequest, Aluno.class);
        aluno = alunoService.criar(aluno);
        AlunoResponse alunoResponsee = modelMapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(alunoResponsee.getCodigo().toString())).body(alunoResponsee);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable("codigo") Integer codigo, @RequestBody @Valid AlunoAtendimentoRequest atendimentoRequest) {
        Aluno aluno = alunoService.atualizarSituacao(codigo, atendimentoRequest.getSituacaoAluno());
        AlunoResponse alunoResponse = modelMapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(alunoResponse);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity excluir(@PathVariable("codigo") Integer codigo) {
        alunoService.excluir(codigo);
        return ResponseEntity.noContent().build();
    }

}
