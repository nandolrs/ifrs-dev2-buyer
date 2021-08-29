package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Embalagem;
import ifrs.dev2.buyer.dados.UnidadeMedida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnidadeMedidaRepository extends CrudRepository<UnidadeMedida, Long> {

    List<UnidadeMedida> findByNomeContaining(String nome);


    List<UnidadeMedida> findBySiglaContaining(String sigla);

    @Query("select m from UnidadeMedida m")
    List<UnidadeMedida> findByTudo();


}


