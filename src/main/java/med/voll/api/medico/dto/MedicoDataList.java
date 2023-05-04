package med.voll.api.medico.dto;

import med.voll.api.medico.Medico;

public record MedicoDataList(String nome, String email, String crm, Especialidade especialidade) {

    public MedicoDataList(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getEmail(), medico.getEspecialidade());
    }
}
