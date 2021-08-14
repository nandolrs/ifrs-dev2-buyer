package ifrs.dev2.buyer.repositorios;


import ifrs.dev2.buyer.dados.ReceitaMaterial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceitaMaterialRepository extends CrudRepository<ReceitaMaterial, Long> {

    @Query("select r from ReceitaMaterial r where r.receita.id = :receitaId")
    List<ReceitaMaterial> findByReceitaId(@Param("receitaId") Long receitaId);

}