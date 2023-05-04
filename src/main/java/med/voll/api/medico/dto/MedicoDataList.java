package med.voll.api.medico.dto;

import med.voll.api.medico.Medico;

public record MedicoDataList(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoDataList(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
