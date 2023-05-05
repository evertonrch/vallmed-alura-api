package med.voll.api.domain.medico.endereco;

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

    public void atualizarInformacoes(EnderecoRequisicao endereco) {
        if(this.logradouro != null)
            this.logradouro = endereco.logradouro();

        if(this.bairro != null)
            this.bairro = endereco.bairro();

        if(this.cep != null)
            this.cep = endereco.cep();

        if(this.complemento != null)
            this.complemento = endereco.complemento();

        if(this.numero != null)
            this.numero = endereco.numero();

        if(this.cidade != null)
            this.cidade = endereco.cidade();

        if(this.uf != null)
            this.uf = endereco.uf();

    }
}
