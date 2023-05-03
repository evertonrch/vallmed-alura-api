package med.voll.api.medico;

import med.voll.api.endereco.EnderecoRequisicao;

public record DadosMedicoRequisicao(String nome, String email, String crm, Especialidade especialidade, EnderecoRequisicao endereco) {

}
