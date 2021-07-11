package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    Long id;

    String nome;

    String email;

    String senha;

    // id

    public Long getId()
    {
        return this.id;
    }
    public void setId(Long valor)
    {
        this.id=valor;
    }

    // nome

    public String getName()
    {
        return this.nome;
    }
    public void setName(String valor)
    {
        this.nome=valor;
    }

    // email

    public String getEmail()    {        return this.email;    }
    public void setEmail(String valor)
    {
        this.email=valor;
    }


    // senha

    public String getPassword()    {        return this.senha;    }
    public void setPassword(String valor)    {        this.senha=valor;    }

}