package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Embalagem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String nome;

    private Float capacidade;
    @OneToOne//@MapsId
    private UnidadeMedida unidademedida;

        // id



    @OneToOne
    private UnidadeMedida unidadeMedida;

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

    public String getNome(){return this.nome;}
    public void setNome(String valor)
    {
        this.nome=valor;
    }



    // capacidade

    public Float getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Float capacidade) {
        this.capacidade = capacidade;
    }


    // unidade de medida



    public UnidadeMedida getUnidadeMedida() { return unidademedida;}

    public void setUnidadeMedida(UnidadeMedida unidademedida) {
        this.unidademedida = unidademedida;
    }



}

