package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class


public class Material {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String nome;

    @OneToOne
    private
    Produto produto;

    @OneToOne
    private
    Embalagem embalagem;

    // id

    public Long getId()
    {
        return this.id;
    }
    public void setId(Long valor)
    {
        this.id=valor;
    }

    // name

    public String getNome(){return this.nome;}
    public void setNome(String valor)
    {
        this.nome=valor;
    }

    // produto

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // embalagem
    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }
}
