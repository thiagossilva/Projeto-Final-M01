package tech.devinhouse.labschoolapi1.controllers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labschoolapi1.dto.ProfessorResponse;
import tech.devinhouse.labschoolapi1.models.Professor;
import tech.devinhouse.labschoolapi1.services.ProfessorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/professores")
@AllArgsConstructor
public class ProfessorController {

    private ProfessorService professorService;
    private ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> listar() {
        List<Professor> professores = professorService.consultar();
        List<ProfessorResponse> resp = new ArrayList<>();
        for(Professor professor: professores) {
            ProfessorResponse professorResp = modelMapper.map(professor, ProfessorResponse.class);
            resp.add(professorResp);
        }
        return ResponseEntity.ok(resp);
    }
}
