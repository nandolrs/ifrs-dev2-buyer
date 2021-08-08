package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Embalagem;
import ifrs.dev2.buyer.dados.Movimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmbalagemRepository extends CrudRepository<Embalagem, Long> {

    List<Embalagem> findByNomeContaining(String nome);

    @Query("select m from Embalagem m where m.unidadeMedida.id = :unidadeMedidalId")
    List<Embalagem> findByunidadeMedidaId(@Param("unidadeMedidalId") Long unidadeMedidalId);

    List<Embalagem> findByCapacidade(float capacidade);

    @Query("select m from Embalagem m")
    List<Embalagem> findByTudo();
}