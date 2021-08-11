package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Embalagem;
import ifrs.dev2.buyer.dados.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ifrs.dev2.buyer.dados.Movimento;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovimentoRepository extends CrudRepository<Movimento, Long>{

        List<Movimento> findBydataMovimento(Date dataMovimento);

        List<Movimento> findByQuantidade(float quantidade);

        @Query("select m from Movimento m where m.material.id = :materialId")
        List<Movimento> findByMaterialId(@Param("materialId") Long materialId);


        @Query("select m from Movimento m")
        List<Movimento> findByTudo();


        @Query("select m from Movimento m where m.estabelecimento.id = :estabelecimentoId")
        List<Movimento> findByEstabelecimentoId(@Param("estabelecimentoId") Long estabelecimentoId);



}