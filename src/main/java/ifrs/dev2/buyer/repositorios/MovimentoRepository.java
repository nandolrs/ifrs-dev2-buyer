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

        @Query("select m from Movimento m where m.dataMovimento = :dataMovimento and m.local.usuario.id = :usuarioId")
        List<Movimento> findBydataMovimento(@Param("dataMovimento") Date dataMovimento
                ,@Param("usuarioId") Long usuarioId);

        @Query("select m from Movimento m where m.quantidade = :quantidade and m.local.usuario.id = :usuarioId")
        List<Movimento> findByQuantidade(@Param("quantidade") float quantidade
                ,@Param("usuarioId") Long usuarioId);

        @Query("select m from Movimento m where m.material.id = :materialId and m.local.usuario.id = :usuarioId")
        List<Movimento> findByMaterialId(@Param("materialId") Long materialId
                ,@Param("usuarioId") Long usuarioId);

        @Query("select m from Movimento m where m.local.usuario.id = :usuarioId")
        List<Movimento> findByTudo(@Param("usuarioId") Long usuarioId);

        @Query("select m from Movimento m where m.estabelecimento.id = :estabelecimentoId and m.local.usuario.id = :usuarioId")
        List<Movimento> findByEstabelecimentoId(@Param("estabelecimentoId") Long estabelecimentoId
                ,@Param("usuarioId") Long usuarioId);


        @Query("select m from Movimento m where m.tipo = :tipo and m.local.usuario.id = :usuarioId")
        List<Movimento> findByTipo(@Param("tipo") Long tipo
                ,@Param("usuarioId") Long usuarioId);


}