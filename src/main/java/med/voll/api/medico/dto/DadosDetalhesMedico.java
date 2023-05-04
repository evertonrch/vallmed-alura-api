package med.voll.api.medico.dto;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Medico;

public record DadosDetalhesMedico(Long id, String nome, String email, String telefone, String crm,
                                  Especialidade especialidade, Endereco endereco) {

    public DadosDetalhesMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }

}
