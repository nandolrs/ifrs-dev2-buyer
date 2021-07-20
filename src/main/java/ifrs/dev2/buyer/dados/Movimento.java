package ifrs.dev2.buyer.dados;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String data;

    float quantidade;

    float valor_unitario;

    float valor_total;

    Long estabelecimento_id;



    // id

    public Long getId() {
        return this.id;
    }

    public void setId(Long valor) {
        this.id = valor;
    }

    // data

    public String getData() { return this.data; }

    public void setData(String valor) {
        this.data = valor;
    }

    // quantidade

    public float getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(float valor) {
        this.quantidade = valor;
    }

    // valor_unitario

    public float getValor_unitario() {
        return this.valor_unitario;
    }

    public void setValor_unitario(float valor) {
        this.valor_unitario = valor;
    }

    // valor_total

    public float getValor_total() {
        return this.valor_total;
    }

    public void setValor_total(float valor) {
        this.valor_total = valor;
    }

    //estabelecimento_id

    public Long getEstabelecimento_id() {
        return this.estabelecimento_id;
    }

    public void setEstabelecimento_id(Long valor) {
        this.estabelecimento_id = valor;
    }
}

