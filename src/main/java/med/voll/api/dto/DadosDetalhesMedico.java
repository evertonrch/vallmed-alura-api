package med.voll.api.dto;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.endereco.Endereco;

public record DadosDetalhesMedico(Long id, String nome, String email, String telefone, String crm,
                                  Especialidade especialidade, Endereco endereco) {

    public DadosDetalhesMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }

}
