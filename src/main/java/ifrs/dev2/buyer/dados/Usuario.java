package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    Long id;

    private String nome;

    private String email;

    private String senha;

    // id

    public Long getId()
    {
        return this.id;
    }
    public void setId(Long valor)
    {
        this.id=valor;
    }



    // email

    public String getEmail()    { return this.email; }
    public void setEmail(String valor)
    {
        this.email=valor;
    }


    // nome

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // senha

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}

//