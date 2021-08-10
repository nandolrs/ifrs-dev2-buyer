package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Local {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String nome;

    @OneToOne
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
