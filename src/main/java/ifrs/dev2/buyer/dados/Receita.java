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

    //@OneToMany
    //private Set<Material> materiais;

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

    /*
    public List getMateriais() {
        return (List) materiais;
    }

    public void setMateriais(List materiais) {
        this.materiais = (Set<Material>) materiais;
    }

     */
}
