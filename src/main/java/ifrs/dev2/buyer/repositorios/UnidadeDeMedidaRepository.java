package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.UnidadeDeMedida;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnidadeDeMedidaRepository extends CrudRepository<ifrs.dev2.buyer.dados.UnidadeDeMedida, Long> {

    List<UnidadeDeMedida> findByNomeContaining(String nome, String sigla);
}
