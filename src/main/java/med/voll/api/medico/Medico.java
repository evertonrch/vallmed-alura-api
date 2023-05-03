package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.endereco.Endereco;
import med.voll.api.endereco.EnderecoRequisicao;

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
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosMedicoRequisicao medicoRequisicao) {
        this.nome = medicoRequisicao.nome();
        this.email = medicoRequisicao.email();
        this.crm = medicoRequisicao.crm();
        this.especialidade = medicoRequisicao.especialidade();
        this.endereco = new Endereco(medicoRequisicao.endereco());
    }
}