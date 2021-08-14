package ifrs.dev2.buyer.dados;

import antlr.collections.List;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Receita {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToOne
    private Produto produto;

    @OneToOne
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*
    public List getMateriais() {
        return (List) materiais;
    }

    public void setMateriais(List materiais) {
        this.materiais = (Set<Material>) materiais;
    }

     */
}
