package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.endereco.EnderecoRequisicao;

public record DadosAtualizarMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoRequisicao endereco) {
}
