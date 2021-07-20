package ifrs.dev2.buyer.dados;

import javax.persistence.*;

@Entity
public class Embalagem {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        String nome;
        double capacidade;

    @OneToOne//@MapsId
    private UnidadeMedida unidademedida;

        // id

        public Long getId() {
            return this.id;
        }

        public void setId(Long valor) {
            this.id = valor;
        }

        // name

        public String getNome() {
            return this.nome;
        }

        public void setNome(String valor) {
            this.nome = valor;
        }

        // capacidade

        public Double getCapacidade(){
        return this.capacidade;
        }


        //unidademedida

    public UnidadeMedida getUnidadeMedida() { return unidademedida;}


    public void setUnidadeMedida(UnidadeMedida unidademedida) {
        this.unidademedida = unidademedida;
    }


    }