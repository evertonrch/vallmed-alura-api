package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.Medico;
import med.voll.api.medico.dto.DadosMedicoRequisicao;
import med.voll.api.medico.dto.DadosAtualizarMedico;
import med.voll.api.medico.dto.MedicoDataList;
import med.voll.api.medico.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosMedicoRequisicao> createMedico(@RequestBody @Valid DadosMedicoRequisicao medicoRequisicao) {
        Medico medico = new Medico(medicoRequisicao);
        medicoRepository.save(medico);
        return ResponseEntity.ok(medicoRequisicao);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDataList>> listMedicos(@PageableDefault(size = 1, sort = {"nome"}, direction = Sort.Direction.DESC) Pageable pageable) {
        System.out.println(pageable);
        Page<Medico> medicos = medicoRepository.findAllByAtivoTrue(pageable);
        return ResponseEntity.ok(medicos.map(MedicoDataList::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateMedico(@RequestBody @Valid DadosAtualizarMedico requisicao) {
        System.out.println(requisicao);
        var medico = medicoRepository.getReferenceById(requisicao.id());
        medico.atualizarInformacoes(requisicao);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.inativar();
    }
}
