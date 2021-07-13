package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String nome;

    @OneToOne //@MapsId
    private Classe classe;

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

    // classe

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
