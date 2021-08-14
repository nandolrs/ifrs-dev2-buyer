package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class


public class Estoque {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    private Float quantidade;
    private Float pontoMaximo;
    private Float pontoMinimo;
    private Float pontoPedido;

    private Float custoUnitario;
    private Float custoTotal;

    @OneToOne
    private
    Material material;

    @OneToOne
    private
    Local local;

    // id

    public Long getId()
    {
        return this.id;
    }
    public void setId(Long valor)
    {
        this.id=valor;
    }

    // material

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    // local

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    // quantidade

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    // ponto máximo

    public Float getPontoMaximo() {
        return pontoMaximo;
    }

    public void setPontoMaximo(Float pontoMaximo) {
        this.pontoMaximo = pontoMaximo;
    }

    // ponto mínimo

    public Float getPontoMinimo() {
        return pontoMinimo;
    }

    public void setPontoMinimo(Float pontoMinimo) {
        this.pontoMinimo = pontoMinimo;
    }

    // ponto de pedido

    public Float getPontoPedido() {
        return pontoPedido;
    }

    public void setPontoPedido(Float pontoPedido) {
        this.pontoPedido = pontoPedido;
    }

    // custo unitario

    public Float getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(Float custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    // custo total

    public Float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(Float custoTotal) {
        this.custoTotal = custoTotal;
    }
}
