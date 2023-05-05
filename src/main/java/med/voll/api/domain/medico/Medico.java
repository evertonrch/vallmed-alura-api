package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.medico.endereco.Endereco;
import med.voll.api.dto.DadosAtualizarMedico;
import med.voll.api.dto.DadosMedicoRequisicao;
import med.voll.api.dto.Especialidade;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosMedicoRequisicao medicoRequisicao) {
        this.ativo = true;
        this.nome = medicoRequisicao.nome();
        this.telefone = medicoRequisicao.telefone();
        this.email = medicoRequisicao.email();
        this.crm = medicoRequisicao.crm();
        this.especialidade = medicoRequisicao.especialidade();
        this.endereco = new Endereco(medicoRequisicao.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarMedico requisicao) {
        if(requisicao.nome() != null)
            this.nome = requisicao.nome();

        if(requisicao.telefone() != null)
            this.nome = requisicao.telefone();

        if(requisicao.endereco() != null)
            this.endereco.atualizarInformacoes(requisicao.endereco());
    }

    public void inativar() {
        ativo = false;
    }
}
