package med.voll.api.controller;

import med.voll.api.medico.DadosMedicoRequisicao;
import med.voll.api.medico.Medico;
import med.voll.api.medico.repository.MedicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosMedicoRequisicao> createMedico(@RequestBody DadosMedicoRequisicao medicoRequisicao) {

        Medico medico = new Medico(medicoRequisicao);

        medicoRepository.save(medico);
        return ResponseEntity.ok(medicoRequisicao);
    }
}
