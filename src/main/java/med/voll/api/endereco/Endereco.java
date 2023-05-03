package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoRequisicao enderecoRequisicao) {
        this.logradouro = enderecoRequisicao.logradouro();
        this.bairro = enderecoRequisicao.bairro();
        this.cep = enderecoRequisicao.cep();
        this.numero = enderecoRequisicao.numero();
        this.complemento = enderecoRequisicao.complemento();
        this.cidade = enderecoRequisicao.cidade();
        this.uf = enderecoRequisicao.uf();
    }
}
