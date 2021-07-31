package ifrs.dev2.buyer.repositorios;


import ifrs.dev2.buyer.dados.Estabelecimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstabelecimentoRepository extends CrudRepository<Estabelecimento, Long> {
    List<Estabelecimento> findByNomeFantasiaContaining(String nomeFantasia);

    @Query("select m from Estabelecimento m")
    List<Estabelecimento> findByTudo();

}