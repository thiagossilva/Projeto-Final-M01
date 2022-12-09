package tech.devinhouse.labschoolapi1.controllers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labschoolapi1.dto.PedagogoResponse;
import tech.devinhouse.labschoolapi1.models.Pedagogo;
import tech.devinhouse.labschoolapi1.services.PedagogoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pedagogos")
@AllArgsConstructor
public class PedagogoController {

    private PedagogoService pedagogoService;
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PedagogoResponse>> listar() {
        List<Pedagogo> pedagogos = pedagogoService.consultar();
        List<PedagogoResponse> resp = new ArrayList<>();
        for(Pedagogo pedagogo: pedagogos) {
            PedagogoResponse pedagogoResp = modelMapper.map(pedagogo, PedagogoResponse.class);
            resp.add(pedagogoResp);
        }
        return ResponseEntity.ok(resp);
    }


}
