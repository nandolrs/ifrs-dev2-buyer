package ifrs.dev2.buyer.dados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Local {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    String nome;

    // id

    public Integer getId()
    {
        return this.id;
    }
    public void setId(Integer valor)
    {
        this.id=valor;
    }

    // name

    public String getNome(){return this.nome;}
    public void setNome(String valor)
    {
        this.nome=valor;
    }


}
