package med.voll.api.controller;

import med.voll.api.medico.DadosMedicoRequisicao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public ResponseEntity<DadosMedicoRequisicao> createMedico(@RequestBody DadosMedicoRequisicao medicoRequisicao) {
        System.out.println(medicoRequisicao);
        return ResponseEntity.ok(medicoRequisicao);
    }
}
