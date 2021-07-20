package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity
public class ReceitaMaterial {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Receita receita;

    @OneToOne
    private Material material;

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
