package ifrs.dev2.buyer.dados;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;


import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Movimento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;


    Date dataMovimento;
    Float quantidade;
    Float valorUnitario;
    Float valorTotal;
    private Long tipo; // 0 nao usar, 1=entrada, 2=saida, 3=compra,  4=cotacao


    @OneToOne
    private Estabelecimento estabelecimento;


    @OneToOne
    private Material material;

    // id

    public Long getId()
    {
        return this.id;
    }
    public void setId(Long valor)
    {
        this.id=valor;
    }


    // estabelecimento

    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    public void setClasse(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    // tipo

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    // material

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}

