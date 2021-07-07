package ifrs.dev2.buyer.dados;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UnidadeDeMedida {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String nome;
	String sigla;

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

    // sigla

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String valor) {
		this.sigla = valor;
	}
}
