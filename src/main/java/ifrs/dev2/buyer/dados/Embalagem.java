package ifrs.dev2.buyer.dados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Embalagem {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        String nome;
        double capacidade;

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

        public void setCapacidade(double valor) {
            this.capacidade = valor;
        }




    }

