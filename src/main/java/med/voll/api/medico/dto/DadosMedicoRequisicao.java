package med.voll.api.medico.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.EnderecoRequisicao;

public record DadosMedicoRequisicao(

        @NotBlank(message = "Nome não deve ser nulo ou vazio")
        String nome,

        @NotBlank
        String telefone,

        @NotBlank(message = "Email não deve ser nulo ou vazio")
        @Email
        String email,

        @NotBlank(message = "CRM não deve ser nulo ou vazio")
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        EnderecoRequisicao endereco
) {}
