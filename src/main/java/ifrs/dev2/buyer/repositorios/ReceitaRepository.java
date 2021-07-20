package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Receita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceitaRepository extends CrudRepository<Receita, Long> {

    List<Receita> findByNomeContaining(String nome);

}
