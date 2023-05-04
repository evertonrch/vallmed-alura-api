package med.voll.api.medico.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.EnderecoRequisicao;

public record DadosAtualizarMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoRequisicao endereco) {
}
